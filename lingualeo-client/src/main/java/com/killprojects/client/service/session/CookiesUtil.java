package com.killprojects.client.service.session;

import org.apache.http.cookie.Cookie;

import java.util.List;
import java.util.stream.Collectors;

public final class CookiesUtil {

    private CookiesUtil() {
    }

    public static String parse(List<Cookie> cookies) {
        return cookies.stream()
                .map(cookie -> String.format("%s=%s;", cookie.getName(), cookie.getValue()))
                .collect(Collectors.joining());
    }
}
