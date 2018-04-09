package com.killprojects.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Created by vladimir on 04.03.2018.
 */
@Data
@AllArgsConstructor
@Builder
public class Word {

    private String value;
    private Integer votes;

}
