package com.killprojects.client.service.session;

import com.killprojects.client.App;
import com.killprojects.client.common.contexts.HttpPropertyContext;
import com.killprojects.client.common.dto.AddWordResponse;
import com.killprojects.client.common.dto.AuthResponse;
import com.killprojects.client.common.dto.GetTranslationsResponse;
import com.killprojects.common.InternalSystemException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = App.class)
public class SessionLeoApiClientTest {


    @Autowired
    private SessionLeoApiClient leoApiClient;

    @Test
    @DisplayName("simple checking translation word Treasure")
    void successGetWordTranslations() throws InternalSystemException {
        HttpPropertyContext propertyContext = HttpPropertyContext.builder()
                .sesionId(10L)
                .build();

        GetTranslationsResponse translationsResponse =
                leoApiClient.getTranslations("treasure", propertyContext);

        Assertions.assertAll("check response",
                () -> assertNotNull(translationsResponse),
                () -> {
                    //check session data in response
                    assertNotNull(translationsResponse.getCookies());
                    assertNotNull(translationsResponse.getSessionId());
                });
    }

    @Test
    @DisplayName("simple checking auth")
    void successAuth() throws InternalSystemException {
        AuthResponse authResponse =
                leoApiClient.auth("qwe", "qwda", HttpPropertyContext.empty());

        Assertions.assertAll("check response",
                () -> assertNotNull(authResponse),
                () -> {
                    //check session data in response
                    assertNotNull(authResponse.getCookies());
                    assertNotNull(authResponse.getSessionId());
                });
    }

    @Test
    @DisplayName("simple checking auth")
    void successAddWord() throws InternalSystemException {
        AuthResponse authResponse = leoApiClient.auth("v.kildushev@yandex.ru", "sdfsdfsdfsdfxcvxv", HttpPropertyContext.empty());
        Long sessionId = authResponse.getSessionId();

        AddWordResponse response = leoApiClient.addWord("vanish",
                "werwerw", "sdfsdf", HttpPropertyContext.builder()
                        .sesionId(sessionId).build());

        Assertions.assertAll("check response",
                () -> assertNotNull(response),
                () -> {
                    //check session data in response
                    assertNotNull(response.getCookies());
                    assertNotNull(response.getSessionId());
                });
    }

}