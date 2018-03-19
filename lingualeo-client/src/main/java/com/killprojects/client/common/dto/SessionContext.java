package com.killprojects.client.common.dto;

import org.apache.http.cookie.Cookie;

import java.util.List;

/**
 * Created by vladimir on 05.03.2018.
 */
public class SessionContext {

    private List<Cookie> cookieStore;

    public SessionContext() {
    }

    public SessionContext(List<Cookie> cookieStore) {
        this.cookieStore = cookieStore;
    }

    public List<Cookie> getCookieStore() {
        return cookieStore;
    }


}
