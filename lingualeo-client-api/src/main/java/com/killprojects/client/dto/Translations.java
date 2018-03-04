package com.killprojects.client.dto;

import java.util.List;

/**
 * Created by vladimir on 04.03.2018.
 */
public class Translations {

    private List<Word> words;

    public Translations(List<Word> words) {
        this.words = words;
    }

    public List<Word> getWords() {
        return words;
    }
}
