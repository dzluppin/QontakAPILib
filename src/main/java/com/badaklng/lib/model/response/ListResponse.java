package com.badaklng.lib.model.response;

import com.badaklng.lib.model.response.util.Meta;
import lombok.Data;

import java.util.List;

@Data
public class ListResponse<T> {
    private String status;
    private List<T> data;
    private Meta meta;
}
