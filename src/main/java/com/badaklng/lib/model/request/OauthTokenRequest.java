package com.badaklng.lib.model.request;

import com.badaklng.lib.model.QONTAK_API_ENDPOINT;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OauthTokenRequest {
    public enum GRANT_TYPE {PASSWORD, REFRESH_TOKEN}

    public static final String API_URL = QONTAK_API_ENDPOINT.AUTH_TOKEN.getUrl();

    private String username;
    private String password;
    private String refresh_token;
    private @NonNull @Builder.Default() String grant_type = "password";
    private String client_id;
    private String client_secret;

    public OauthTokenRequest(String username, String password, String client_id, String client_secret) {
        this.username = username;
        this.password = password;
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.grant_type = GRANT_TYPE.PASSWORD.toString().toLowerCase();
    }

    public OauthTokenRequest(String refresh_token, String client_id, String client_secret) {
        this.refresh_token = refresh_token;
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.grant_type = GRANT_TYPE.REFRESH_TOKEN.toString().toLowerCase();
    }
}
