package com.badaklng.lib.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
public class OauthTokenResponse {
    private String access_token;
    private String token_type;
    private long expires_in;
    private String refresh_token;

    @JsonProperty("created_at")
    private Instant created_at;
}
