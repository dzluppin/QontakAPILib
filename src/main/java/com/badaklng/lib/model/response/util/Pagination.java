package com.badaklng.lib.model.response.util;

import lombok.Data;

@Data
public class Pagination {
    private Cursor cursor;
    private Integer offset;
    private Integer limit;
    private Integer total;
}
