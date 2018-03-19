package com.killprojects.client.common.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by vladimir on 02.03.2018.
 */
public class AuthResponse extends AbsractSessionApiResponse {
    @JSONField(name = "error_msg")
    private String error_msg;
    @JSONField(name = "user")
    private User user;

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public class User {
        @JSONField(name = "user_id")
        String user_id;
        @JSONField(name = "nickname")
        String nickname;
        @JSONField(name = "meatballs")
        String meatballs;

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getMeatballs() {
            return meatballs;
        }

        public void setMeatballs(String meatballs) {
            this.meatballs = meatballs;
        }
    }
}
