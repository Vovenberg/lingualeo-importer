package com.killprojects.client.common.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.ArrayList;
import java.util.List;

public class GetTranslationsResponse extends AbsractSessionApiResponse {
    @JSONField(name = "error_msg")
    private String errorMsg;
    @JSONField(name = "is_user")
    private Integer isUser;
    @JSONField(name = "translate")
    private List<WordTranslation> wordTranslations = new ArrayList<>();
    private String transcription;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Integer getIsUser() {
        return isUser;
    }

    public void setIsUser(Integer isUser) {
        this.isUser = isUser;
    }

    public List<WordTranslation> getWordTranslations() {
        return wordTranslations;
    }

    public void setWordTranslations(List<WordTranslation> wordTranslations) {
        this.wordTranslations = wordTranslations;
    }

    public String getTranscription() {
        return transcription;
    }

    public void setTranscription(String transcription) {
        this.transcription = transcription;
    }
}