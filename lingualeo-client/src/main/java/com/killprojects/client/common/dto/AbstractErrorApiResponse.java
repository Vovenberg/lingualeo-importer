package com.killprojects.client.common.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Consumer;

@Data
public abstract class AbstractErrorApiResponse extends AbsractSessionApiResponse {

    @JSONField(name = "error_msg")
    private String errorMessage;

    public void assertIsSuccess(Consumer<String> func) {
        if (StringUtils.isNotBlank(errorMessage)) {
            func.accept(errorMessage);
        }
    }

}
