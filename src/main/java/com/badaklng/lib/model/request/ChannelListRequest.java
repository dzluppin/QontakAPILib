package com.badaklng.lib.model.request;

import com.badaklng.lib.model.QONTAK_API_ENDPOINT;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChannelListRequest {
    public static final String API_URL = QONTAK_API_ENDPOINT.WA_CHANNEL_LIST.getUrl();

    private @NonNull @Builder.Default() Integer limit = 10;
    private @NonNull @Builder.Default() String target_channel = "wa";
}
