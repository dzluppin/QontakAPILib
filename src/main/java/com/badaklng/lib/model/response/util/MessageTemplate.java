package com.badaklng.lib.model.response.util;

import lombok.Data;

@Data
public class MessageTemplate {
    private String id;
    private String name;
    private String language;
    private String header;
    private String body;
    private String footer;
    private String status;
    private String category;
}
