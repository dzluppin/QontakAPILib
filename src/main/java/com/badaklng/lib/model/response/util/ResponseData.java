package com.badaklng.lib.model.response.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializer;
import lombok.Data;

import java.time.Instant;

@Data
public class ResponseData {
    private String id;
    private String name;
    private String organization_id;
    private String channel_integration_id;
    private String contact_list_id;  // null kalau tidak ada
    private String contact_id;
    private String target_channel;
    private ResponseParameter parameters;

    @JsonProperty("created_at")
    @JsonDeserialize(using = InstantDeserializer.class)
    @JsonSerialize(using = InstantSerializer.class)
    private Instant created_at;

    @JsonProperty("send_at")
    @JsonDeserialize(using = InstantDeserializer.class)
    @JsonSerialize(using = InstantSerializer.class)
    private Instant send_at;
    private MessageStatusCount message_status_count;
    private MessageTemplate message_template;

}
