package com.killprojects.client.dto;

import com.alibaba.fastjson.annotation.JSONField;

public class WordTranslation {
    private Integer id;
    private String value;
    private Integer votes;
    @JSONField(name = "is_user")
    private Integer isUser;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public Integer getIsUser() {
        return isUser;
    }

    public void setIsUser(Integer isUser) {
        this.isUser = isUser;
    }
}