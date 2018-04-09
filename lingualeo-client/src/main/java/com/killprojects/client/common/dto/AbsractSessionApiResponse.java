package com.killprojects.client.common.dto;


import lombok.Data;
import org.apache.http.cookie.Cookie;

import java.util.List;

@Data
public abstract class AbsractSessionApiResponse implements ApiResponse {

    private Long sessionId;
    private List<Cookie> cookies;

}
