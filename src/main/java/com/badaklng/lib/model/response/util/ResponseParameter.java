package com.badaklng.lib.model.response.util;

import lombok.Data;

import java.util.Map;

@Data
public class ResponseParameter {
    private Map<String, String> header;
    private Map<String, String> body;
}
