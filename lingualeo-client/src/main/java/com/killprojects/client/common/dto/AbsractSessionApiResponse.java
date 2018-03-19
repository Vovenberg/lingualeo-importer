package com.killprojects.client.common.dto;


import org.apache.http.cookie.Cookie;

import java.util.List;

public abstract class AbsractSessionApiResponse implements ApiResponse {

    private Long sessionId;
    private List<Cookie> cookies;

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public List<Cookie> getCookies() {
        return cookies;
    }

    public void setCookies(List<Cookie> cookies) {
        this.cookies = cookies;
    }
}
