package com.badaklng.lib.model.response;

import com.badaklng.lib.model.response.util.ResponseData;
import lombok.Data;

@Data
public class APIResponse {
    private String status;
    private ResponseData data;
}
