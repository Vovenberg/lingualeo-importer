package com.killprojects.client.service;


import com.killprojects.client.App;
import com.killprojects.client.common.HttpPropertyContext;
import com.killprojects.client.common.dto.AddWordResponse;
import com.killprojects.client.common.dto.AuthResponse;
import com.killprojects.client.common.dto.GetTranslationsResponse;
import com.killprojects.client.common.dto.WordTranslation;
import com.killprojects.common.InternalSystemException;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by vladimir on 02.03.2018.
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = App.class)
class LeoApiClientTest {

    @Autowired
    private LeoApiClient leoApiClient;


    @Test
    @DisplayName("simple checking translation word Treasure")
    void successGetWordTranslations() throws InternalSystemException {
        HttpPropertyContext propertyContext = HttpPropertyContext.builder()
                .setSessionId(10L)
                .build();

        GetTranslationsResponse translationsResponse =
                leoApiClient.getTranslations("treasure", propertyContext);

        Assertions.assertAll("check response",
                () -> assertNotNull(translationsResponse),
                () -> {
                    //check translations in response
                    List<WordTranslation> wordTranslations = translationsResponse.getWordTranslations();
                    assertNotNull(wordTranslations);
                    assertEquals(5, wordTranslations.size());
                },
                () -> {
                    //check other values in response
                    assertTrue(translationsResponse.getErrorMsg().isEmpty());
                });
    }

    @Test
    @DisplayName("simple checking auth")
    void successAuth() throws InternalSystemException {
        AuthResponse authResponse =
                leoApiClient.auth("qwerty", "asdf", HttpPropertyContext.empty());

        Assertions.assertAll("check response",
                () -> assertNotNull(authResponse),
                () -> {
                    assertTrue(Strings.isEmpty(authResponse.getError_msg()));
                    assertNotNull(authResponse.getUser());
                });
    }

    @Test
    @DisplayName("simple checking addWord")
    void successAddWord() throws InternalSystemException {
        AddWordResponse response = leoApiClient.addWord("vanish",
                "werwerw", "sdfsdf", HttpPropertyContext.builder()
                        .setSessionId(20L).build());

        Assertions.assertAll("check response",
                () -> assertNotNull(response),
                () -> {
                    assertTrue(Strings.isEmpty(response.getError_msg()));

                });
    }

}