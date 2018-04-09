package com.killprojects.client.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.http.cookie.Cookie;

import java.util.List;

/**
 * Created by vladimir on 05.03.2018.
 */
@Getter
@AllArgsConstructor
public class SessionContext {

    private List<Cookie> cookieStore;

}
