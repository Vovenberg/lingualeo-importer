package com.killprojects.client.common;

import java.util.Optional;

/**
 * Created by vladimir on 02.03.2018.
 */
public class HttpPropertyContext {
    private String cookie;
    private Integer timeout;

    private HttpPropertyContext() {
    }

    public Optional<String> getCookie() {
        return Optional.ofNullable(cookie);
    }

    private void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public Optional<Integer> getTimeout() {
        return Optional.ofNullable(timeout);
    }

    private void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public static HttpPropertyContextBuilder builder() {
        return new HttpPropertyContextBuilder();
    }

    public static HttpPropertyContext empty() {
        return new HttpPropertyContext();
    }

    private static class HttpPropertyContextBuilder {
        private String cookie;
        private int timeout;

        public HttpPropertyContextBuilder setCookie(String cookie) {
            this.cookie = cookie;
            return this;
        }

        public HttpPropertyContextBuilder setTimeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public HttpPropertyContext build() {
            HttpPropertyContext httpPropertyContext = new HttpPropertyContext();
            httpPropertyContext.setCookie(cookie);
            httpPropertyContext.setTimeout(timeout);
            return httpPropertyContext;
        }
    }
}
