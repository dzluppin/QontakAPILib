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
    private static final String ACCESS_TOKEN_TEST = "WfLZntjWKuuCXJzbNuNxJ1l28J803Q8pYi6N9URX12k";
    public static final String CHANNEL_ID_TEST = "f7b0e1b3-eb77-4c0b-a7b0-c9d63a174dc4";
    public static final String TEMPLATE_TEST = "6242aa10-a7ac-4655-be41-f8fb1b8ddcde";

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
