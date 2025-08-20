package com.badaklng.lib;

import com.badaklng.lib.model.QONTAK_API_ENDPOINT;
import com.badaklng.lib.model.request.ChannelListRequest;
import com.badaklng.lib.model.request.MessageDirectRequest;
import com.badaklng.lib.model.request.OauthTokenRequest;
import com.badaklng.lib.model.request.util.TemplateParameter;
import com.badaklng.lib.model.response.APIResponse;
import com.badaklng.lib.model.response.ListResponse;
import com.badaklng.lib.model.response.OauthTokenResponse;
import com.badaklng.lib.model.response.util.Channel;
import com.badaklng.lib.model.response.util.MessageLog;
import com.badaklng.lib.model.response.util.MessageTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import okhttp3.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Qontak {
    private static final String BASE_URL = "https://service-chat.qontak.com";
    private String CLIENT_ID;
    private String CLIENT_SECRET;
    private String USERNAME;
    private String PASSWORD;
    private String ACCESS_TOKEN;
    private String CHANNEL_ID;

    private final String configFileName;
    private final OkHttpClient client;
    private final ObjectMapper mapper;

    public Qontak() {
        this("qontak.config");
    }

    public Qontak(String configFileName) {
        this.client = new OkHttpClient();
        this.mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        this.configFileName = configFileName;
        initializeProp(configFileName, false);
    }

    public Qontak(Boolean isTest) {
        this.client = new OkHttpClient();
        this.mapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        this.configFileName = isTest ? "qontak-test.config" : "qontak.config";
        initializeProp(this.configFileName, isTest);
    }

    public void initializeProp(String configFileName, Boolean isTest) {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(configFileName)) {
            prop.load(fis);
            if (!isTest) {
                CLIENT_ID = prop.getProperty("CLIENT_ID");
                CLIENT_SECRET = prop.getProperty("CLIENT_SECRET");
                USERNAME = prop.getProperty("USERNAME");
                PASSWORD = prop.getProperty("PASSWORD");
                ACCESS_TOKEN = retrieveAccessToken().getAccess_token();
                CHANNEL_ID = getDefaultChannelIntegrationId();
            } else {
                ACCESS_TOKEN = prop.getProperty("ACCESS_TOKEN");
                CHANNEL_ID = prop.getProperty("CHANNEL_ID");
            }
        } catch (IOException e) {
            throw new RuntimeException(configFileName + " file not found");
        }
    }

    // === Public APIs ===
    public OauthTokenResponse retrieveAccessToken() throws JsonProcessingException {
        OauthTokenRequest otr = new OauthTokenRequest(USERNAME, PASSWORD, CLIENT_ID, CLIENT_SECRET);
        String endpoint = BASE_URL + OauthTokenRequest.API_URL;
        return sendRequest(endpoint, "POST", mapper.writeValueAsString(otr), OauthTokenResponse.class, false);
    }

    public APIResponse sendMsgOutDirect(String toNumber, String toName, String templateId, TemplateParameter... params) throws JsonProcessingException {
        MessageDirectRequest mdr = new MessageDirectRequest(toNumber, toName, templateId, CHANNEL_ID, params);
        String endpoint = BASE_URL + MessageDirectRequest.API_URL;
        return sendRequest(endpoint, "POST", mapper.writeValueAsString(mdr), APIResponse.class, true);
    }

    public APIResponse sendMsgOutDirect(String toNumber, String toName, String templateId, String channelId, TemplateParameter... params) throws IOException {
        MessageDirectRequest mdr = new MessageDirectRequest(toNumber, toName, templateId, channelId, params);
        String endpoint = BASE_URL + MessageDirectRequest.API_URL;
        return sendRequest(endpoint, "POST", mapper.writeValueAsString(mdr), APIResponse.class, true);
    }

    public ListResponse<Channel> getWhatsAppChannelList() {
        ChannelListRequest clr = new ChannelListRequest();
        String endpoint = BASE_URL + ChannelListRequest.API_URL +
                "?target_channel=" + clr.getTarget_channel() +
                "&limit=" + clr.getLimit();

        return sendRequest(endpoint, "GET", null, new TypeReference<ListResponse<Channel>>() {
        }, true);
    }

    public ListResponse<MessageTemplate> getWhatsAppMessageTemplateList() {
        String endpoint = BASE_URL + QONTAK_API_ENDPOINT.WA_MSG_TEMPLATE.getUrl();
        return sendRequest(endpoint, "GET", null, new TypeReference<ListResponse<MessageTemplate>>() {
        }, true);
    }

    public ListResponse<MessageLog> getWhatsAppMessageLogList(String id) {
        String endpoint = BASE_URL + QONTAK_API_ENDPOINT.WA_MSG_LOG_DIRECT.getUrl().replace("{id}", id);
        return sendRequest(endpoint, "GET", null, new TypeReference<ListResponse<MessageLog>>() {
        }, true);
    }

    // === Private Helpers ===
    private String getDefaultChannelIntegrationId() {
        List<Channel> channels = getWhatsAppChannelList().getData();
        if (!channels.isEmpty())
            return channels.get(0).getId();
        throw new RuntimeException("No WhatsApp Channel Available");
    }


    // === Generic Request Handler ===
    private <T> T sendRequest(String endpoint, String method, String jsonBody, Class<T> clazz, boolean auth) {
        try {
            Request.Builder builder = new Request.Builder().url(endpoint);
            if ("POST".equalsIgnoreCase(method) && jsonBody != null) {
                builder.post(RequestBody.create(jsonBody, MediaType.parse("application/json")));
            } else {
                builder.get();
            }
            if (auth) builder.addHeader("Authorization", "Bearer " + ACCESS_TOKEN);
            builder.addHeader("Content-Type", "application/json");

            try (Response response = client.newCall(builder.build()).execute()) {
                if (!response.isSuccessful()) {
                    String err = response.body() != null ? response.body().string() : "No error body";
                    throw new RuntimeException("Request Unsuccessful : " + response.code() + " -> " + err);
                }
                if (response.body() == null) throw new RuntimeException("Empty response body");
                return mapper.readValue(response.body().string(), clazz);
            }
        } catch (IOException e) {
            throw new RuntimeException("Request failed [IOException] : " + e.getMessage(), e);
        }
    }

    private <T> T sendRequest(String endpoint, String method, String jsonBody, TypeReference<T> typeRef, boolean auth) {
        try {
            Request.Builder builder = new Request.Builder().url(endpoint);
            if ("POST".equalsIgnoreCase(method) && jsonBody != null) {
                builder.post(RequestBody.create(jsonBody, MediaType.parse("application/json")));
            } else {
                builder.get();
            }
            if (auth) builder.addHeader("Authorization", "Bearer " + ACCESS_TOKEN);
            builder.addHeader("Content-Type", "application/json");

            try (Response response = client.newCall(builder.build()).execute()) {
                if (!response.isSuccessful()) {
                    String err = response.body() != null ? response.body().string() : "No error body";
                    throw new RuntimeException("Request Unsuccessful : " + response.code() + " -> " + err);
                }
                if (response.body() == null) throw new RuntimeException("Empty response body");
                return mapper.readValue(response.body().string(), typeRef);
            }
        } catch (IOException e) {
            throw new RuntimeException("Request failed [IOException] : " + e.getMessage(), e);
        }
    }
}
