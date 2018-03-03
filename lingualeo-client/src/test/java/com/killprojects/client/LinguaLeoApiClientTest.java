package com.killprojects.client;


import com.killprojects.client.dto.GetTranslationsResponse;
import com.killprojects.client.dto.WordTranslation;
import com.killprojects.client.exceptions.HttpRequestException;
import com.killprojects.client.exceptions.UnknownException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Created by vladimir on 02.03.2018.
 */
public class LinguaLeoApiClientTest {


    @Test
    @DisplayName("simple checking translation word Treasure")
    void successGetWordTranslations() throws UnknownException, HttpRequestException {
        GetTranslationsResponse translationsResponse =
                new LinguaLeoApiClient().getTranslations("treasure", HttpPropertyContext.empty());

        Assertions.assertAll("check response",
                () -> Assertions.assertNotNull(translationsResponse),
                () -> {
                    //check translations in response
                    List<WordTranslation> wordTranslations = translationsResponse.getWordTranslations();
                    Assertions.assertNotNull(wordTranslations);
                    Assertions.assertEquals(5, wordTranslations.size());
                },
                () -> {
                    //check other values in response
                    Assertions.assertTrue(translationsResponse.getErrorMsg().isEmpty());
                });
    }

}