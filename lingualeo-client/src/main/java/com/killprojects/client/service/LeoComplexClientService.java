package com.killprojects.client.service;

import com.killprojects.client.ComplexClientApi;
import com.killprojects.client.common.HttpPropertyContext;
import com.killprojects.client.common.dto.AuthResponse;
import com.killprojects.client.common.dto.SessionContext;
import com.killprojects.client.common.dto.SessionId;
import com.killprojects.client.dto.Translations;
import com.killprojects.client.dto.Word;
import com.killprojects.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.killprojects.common.ResultHandler.handleResult;

/**
 * Created by vladimir on 04.03.2018.
 */
@Service
public class LeoComplexClientService implements ComplexClientApi {


    @Autowired
    private LeoApiClient client;

    @Override
    public Result<Boolean> auth(String login, String password) {
        return handleResult(() -> {
                    AuthResponse authResponse = client.auth(login, password, HttpPropertyContext.empty());
                    return true;
                },
                System.out::println
        );
    }

    @Override
    public Result<Translations> getTranslate(String word) {
        return null;
    }

    @Override
    public Result<Word> addWord(String word, String translate) {
        return null;
    }
}
