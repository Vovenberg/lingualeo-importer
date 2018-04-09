package com.killprojects.client.common.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * Created by vladimir on 02.03.2018.
 */
@Data
public class AuthResponse extends AbstractErrorApiResponse {

    @JSONField(name = "user")
    private User user;

    @Data
    public class User {
        @JSONField(name = "user_id")
        String user_id;
        @JSONField(name = "nickname")
        String nickname;
        @JSONField(name = "meatballs")
        String meatballs;
    }
}
