package com.killprojects.client.common.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class WordTranslation {
    private Integer id;
    private String value;
    private Integer votes;
    @JSONField(name = "is_user")
    private Integer isUser;

}