package com.killprojects.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created by vladimir on 04.03.2018.
 */
@Data
@AllArgsConstructor
@Builder
public class Translations {

    private List<Word> words;

}
