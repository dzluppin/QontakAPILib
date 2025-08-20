package com.badaklng.lib.model.response.util;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessageStatusCount {
    private int failed;
    private int delivered;
    private int read;
    private int pending;
    private int sent;
}
