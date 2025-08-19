package com.badaklng.lib.model.request.util;

import lombok.Data;

@Data
public class TemplateParameter {
    private String key;
    private String value;
    private String value_text;

    public TemplateParameter(String key, String value, String value_text){
        this.key = key;
        this.value = value;
        this.value_text = value_text;
    }
}
