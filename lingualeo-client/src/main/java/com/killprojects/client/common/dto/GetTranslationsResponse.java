package com.killprojects.client.common.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class GetTranslationsResponse extends AbstractErrorApiResponse {
    @JSONField(name = "is_user")
    private Integer isUser;
    @JSONField(name = "translate")
    private List<WordTranslation> wordTranslations = new ArrayList<>();
    private String transcription;

}