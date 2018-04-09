package com.killprojects.client.service;

import com.killprojects.client.SelectionType;
import com.killprojects.client.common.ApiClient;
import com.killprojects.client.common.SmartClientService;
import com.killprojects.client.common.contexts.HttpPropertyContext;
import com.killprojects.client.common.dto.AuthResponse;
import com.killprojects.client.common.dto.GetTranslationsResponse;
import com.killprojects.client.common.dto.WordTranslation;
import com.killprojects.client.common.exceptions.ClientErrors;
import com.killprojects.client.dto.User;
import com.killprojects.client.dto.Word;
import com.killprojects.common.InternalSystemException;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;

import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isNoneBlank;

/**
 * Created by vladimir on 04.03.2018.
 */
@Service
public class LeoSmartClientService implements SmartClientService {

    private final ApiClient client;

    @Autowired
    public LeoSmartClientService(ApiClient client) {
        this.client = client;
    }

    @Override
    public Pair<Long, User> auth(String login, String password) throws InternalSystemException {
        assert isNoneBlank(login) : "Login unspecified";
        assert isNoneBlank(password) : "Password unspecified";

        AuthResponse authResponse = client.auth(login, password, HttpPropertyContext.empty());
        authResponse.assertIsSuccess(ClientErrors.UnknownAuthorizedException::new);

        AuthResponse.User authResponseUser = authResponse.getUser();
        User user = User.builder()
                .user_id(authResponseUser.getUser_id())
                .meatballs(authResponseUser.getMeatballs())
                .nickname(authResponseUser.getNickname())
                .build();

        return ImmutablePair.of(authResponse.getSessionId(), user);
    }

    @Override
    public Word smartAddWord(String word, SelectionType selectionType, Long sessionId) throws InternalSystemException {
        assert isNoneBlank(word) : "Word unspecified";
        assert nonNull(sessionId) : "Session id unspecified";

        GetTranslationsResponse translationsResponse = client.getTranslations(word, HttpPropertyContext.builder()
                .sesionId(sessionId)
                .build());
        translationsResponse.assertIsSuccess(ClientErrors.UnknownAddWordException::new);

        WordTranslation electedWord = translationsResponse.getWordTranslations().stream()
                .max(Comparator.comparingInt(WordTranslation::getVotes))
                .get();

        return new Word(electedWord.getValue(), electedWord.getVotes());
    }
}
