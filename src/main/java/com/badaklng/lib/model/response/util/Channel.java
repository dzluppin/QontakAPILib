package com.badaklng.lib.model.response.util;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class Channel {
    private String id;
    private String target_channel;
    private String webhook;
    private ChannelSetting settings;
    private String organization_id;
    private OffsetDateTime created_at;
}
