package com.badaklng.lib.model.request.util;

import lombok.Data;

@Data
public class Language {
    private String code;

    public Language(String code){
        this.code = code;
    }
}
