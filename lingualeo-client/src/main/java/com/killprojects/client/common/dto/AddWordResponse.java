package com.killprojects.client.common.dto;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by vladimir on 02.03.2018.
 */
public class AddWordResponse extends AbsractSessionApiResponse {

    @JSONField(name = "error_msg")
    private String error_msg;

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }
}
