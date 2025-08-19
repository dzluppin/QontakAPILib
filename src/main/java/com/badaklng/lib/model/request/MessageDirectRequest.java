package com.badaklng.lib.model.request;

import com.badaklng.lib.model.request.util.Language;
import com.badaklng.lib.model.request.util.Parameter;
import com.badaklng.lib.model.request.util.TemplateParameter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
public class MessageDirectRequest {
    public static final String API_URL = "/api/open/v1/broadcasts/whatsapp/direct";
    private String to_number;
    private String to_name;

    @JsonProperty("message_template_id")
    private String template_id;

    @JsonProperty("channel_integration_id")
    private String channel_id;
    private Language language;
    private Parameter parameters;

    public MessageDirectRequest(String toNumber, String toName, String templateId, String channelId, Parameter param) {
        this.to_number = toNumber;
        this.to_name = toName;
        this.template_id = templateId;
        this.channel_id = channelId;
        this.parameters = param;
        this.language = new Language("id");
    }

    public MessageDirectRequest(String toNumber, String toName, String templateId, String channelId, TemplateParameter[] params) {
        this.to_number = toNumber;
        this.to_name = toName;
        this.template_id = templateId;
        this.channel_id = channelId;
        this.parameters = new Parameter(params);
        this.language = new Language("id");
    }
}
