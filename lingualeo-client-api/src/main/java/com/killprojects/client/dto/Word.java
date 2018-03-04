package com.killprojects.client.dto;

/**
 * Created by vladimir on 04.03.2018.
 */
public class Word {

    private String value;
    private Integer votes;

    public Word(String value, Integer votes) {
        this.value = value;
        this.votes = votes;
    }

    public String getValue() {
        return value;
    }

    public Integer getVotes() {
        return votes;
    }
}
