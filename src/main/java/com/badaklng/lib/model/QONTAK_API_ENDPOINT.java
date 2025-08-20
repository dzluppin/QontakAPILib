package com.badaklng.lib.model;

import lombok.Getter;

public enum QONTAK_API_ENDPOINT {
    AUTH_TOKEN("/oauth/token"),
    WA_CHANNEL_LIST("/api/open/v1/integration"),
    WA_MSG_TEMPLATE("/api/open/v1/templates/whatsapp"),
    WA_MSG_OUT_DIRECT("/api/open/v1/broadcasts/whatsapp/direct"),
    WA_MSG_LOG_DIRECT("/api/open/v1/broadcasts/{id}/whatsapp/log");

    private @Getter
    final String url;

    QONTAK_API_ENDPOINT(String path) {
        this.url = path;
    }
}
