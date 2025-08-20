package com.badaklng.lib.model.response.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Channel {
    private String id;
    private String target_channel;
    private String webhook;
    private ChannelSetting settings;
    private String organization_id;
    private OffsetDateTime created_at;

    @Data
    public static class ChannelSetting {
        private String domain_server;
        private String authorization;
        private String account_name;
        private String server_wa_id;
    }
}
