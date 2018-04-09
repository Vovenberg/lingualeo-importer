package com.killprojects.client.service.session;

import com.killprojects.client.common.ApiClient;
import com.killprojects.client.common.contexts.HttpPropertyContext;
import com.killprojects.client.common.dto.AddWordResponse;
import com.killprojects.client.common.dto.AuthResponse;
import com.killprojects.client.common.dto.GetTranslationsResponse;
import com.killprojects.client.common.dto.SessionContext;
import com.killprojects.client.common.exceptions.ClientErrors;
import com.killprojects.client.service.LeoApiClient;
import com.killprojects.common.InternalSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


@Service
@Primary
public class SessionLeoApiClient implements ApiClient {


    private final LeoApiClient client;
    private final SessionStorage sessionStorage;

    @Autowired
    public SessionLeoApiClient(LeoApiClient client, SessionStorage sessionStorage) {
        this.client = client;
        this.sessionStorage = sessionStorage;
    }

    @Override
    public AuthResponse auth(String login, String password, HttpPropertyContext context)
            throws InternalSystemException {
        AuthResponse authResponse = client.auth(login, password, context);
        long sessionId = sessionStorage.saveSession(new SessionContext(authResponse.getCookies()));
        authResponse.setSessionId(sessionId);
        return authResponse;
    }

    @Override
    public GetTranslationsResponse getTranslations(String word, HttpPropertyContext propertyContext)
            throws InternalSystemException {
        Long sessionId = 0L;
        propertyContext.getSesionId().ifPresent(id -> {
            if (sessionStorage.isSessionExist(id)) addCookiesFromStorage(propertyContext, id);
        });

        GetTranslationsResponse translationsResponse = client.getTranslations(word, propertyContext);
        translationsResponse.setSessionId(sessionId);
        return translationsResponse;
    }


    @Override
    public AddWordResponse addWord(String word, String translate, String context, HttpPropertyContext propertyContext)
            throws InternalSystemException {
        Long sessionId = propertyContext.getSesionId().orElseThrow(IllegalArgumentException::new);
        if (sessionStorage.isSessionExist(sessionId)) {
            addCookiesFromStorage(propertyContext, sessionId);
        } else {
            throw new ClientErrors.NonAuthorizedRequest();
        }

        AddWordResponse addWordResponse = client.addWord(word, translate, context, propertyContext);
        addWordResponse.setSessionId(sessionId);
        return addWordResponse;
    }

    private void addCookiesFromStorage(HttpPropertyContext propertyContext, Long id) {
        SessionContext sessionContext = sessionStorage.get(id);
        String rawCookie = CookiesUtil.parse(sessionContext.getCookieStore());
        propertyContext.setCookie(rawCookie);
    }
}
