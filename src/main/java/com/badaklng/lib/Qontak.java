package com.badaklng.lib;

import com.badaklng.lib.model.request.MessageDirectRequest;
import com.badaklng.lib.model.request.util.TemplateParameter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import okhttp3.*;

import java.io.IOException;

public class Qontak {
    private static final String BASE_URL = "https://service-chat.qontak.com";
    private static final String CLIENT_ID = "";
    private static final String CLIENT_SECRET = "";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";
    private static final String ACCESS_TOKEN_TEST = "";
    public static final String CHANNEL_ID_TEST = "";
    public static final String TEMPLATE_TEST = "";

    private final OkHttpClient client;
    private final ObjectMapper mapper;

    public Qontak() {
        this.client = new OkHttpClient();
        this.mapper = new ObjectMapper().registerModule(new JavaTimeModule()).disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    public String getAccessToken() {
        return null;
    }

    public String sendMsgOutDirect(String toNumber, String toName, String templateId, TemplateParameter... params) throws JsonProcessingException {
        MessageDirectRequest mdr = new MessageDirectRequest(toNumber, toName, templateId, getDefaultChannelIntegrationId(), params);
        String endpoint = BASE_URL + MessageDirectRequest.API_URL;
        String jsonBody = mapper.writeValueAsString(mdr);
        return null;
    }

    public String sendMsgOutDirect(String toNumber, String toName, String templateId, String channelId, TemplateParameter... params) throws IOException {
        MessageDirectRequest mdr = new MessageDirectRequest(toNumber, toName, templateId, channelId, params);
        String endpoint = BASE_URL + MessageDirectRequest.API_URL;
        String jsonBody = mapper.writeValueAsString(mdr);

        return null;
    }

    private String getDefaultOrganizationId() {
        return null;
    }

    private String getDefaultChannelIntegrationId() {
        return null;
    }
}
