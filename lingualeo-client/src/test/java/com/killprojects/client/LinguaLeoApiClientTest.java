package com.killprojects.client;


import com.killprojects.client.common.HttpPropertyContext;
import com.killprojects.client.common.dto.GetTranslationsResponse;
import com.killprojects.client.common.dto.WordTranslation;
import com.killprojects.client.service.LinguaLeoApiClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

/**
 * Created by vladimir on 02.03.2018.
 */
@SpringBootTest
public class LinguaLeoApiClientTest {

    @Autowired
    private LinguaLeoApiClient linguaLeoApiClient;

    @Test
    @DisplayName("simple checking translation word Treasure")
    void successGetWordTranslations() throws UnknownException, HttpRequestException {
        GetTranslationsResponse translationsResponse =
                linguaLeoApiClient.getTranslations("treasure", HttpPropertyContext.empty());

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