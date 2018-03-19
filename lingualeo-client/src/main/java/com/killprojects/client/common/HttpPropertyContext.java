package com.killprojects.client.common;

import java.util.Optional;

/**
 * Created by vladimir on 02.03.2018.
 */
public class HttpPropertyContext {
    private Long sesionId;
    private String cookie;
    private Integer timeout;

    private HttpPropertyContext() {
    }

    public Optional<Long> getSesionId() {
        return Optional.ofNullable(sesionId);
    }

    public void setSesionId(Long sesionId) {
        this.sesionId = sesionId;
    }

    public Optional<String> getCookie() {
        return Optional.ofNullable(cookie);
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public Optional<Integer> getTimeout() {
        return Optional.ofNullable(timeout);
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public static HttpPropertyContextBuilder builder() {
        return new HttpPropertyContextBuilder();
    }

    public static HttpPropertyContext empty() {
        return new HttpPropertyContext();
    }

    public static class HttpPropertyContextBuilder {
        private String cookie;
        private int timeout;
        private Long sesionId;


        public HttpPropertyContextBuilder setCookie(String cookie) {
            this.cookie = cookie;
            return this;
        }

        public HttpPropertyContextBuilder setTimeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public HttpPropertyContextBuilder setSessionId(Long sessionId) {
            this.sesionId = sessionId;
            return this;
        }

        public HttpPropertyContext build() {
            HttpPropertyContext httpPropertyContext = new HttpPropertyContext();
            httpPropertyContext.setCookie(cookie);
            httpPropertyContext.setTimeout(timeout);
            httpPropertyContext.setSesionId(sesionId);
            return httpPropertyContext;
        }
    }
}
