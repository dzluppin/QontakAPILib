package com.badaklng.lib.model.response;

import lombok.Data;

import java.util.List;

@Data
public class ListResponse<T> {
    private String status;
    private List<T> data;
    private Meta meta;

    @Data
    public static class Meta {
        private Pagination pagination;

        @Data
        public static class Pagination {
            private Cursor cursor;
            private Integer offset;
            private Integer limit;
            private Integer total;

            @Data
            public static class Cursor {
                private String next;
                private String prev;
            }
        }
    }
}
