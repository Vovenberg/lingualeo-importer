package com.killprojects.client;

import com.killprojects.client.dto.AddWordResponse;
import com.killprojects.client.dto.AuthResponse;
import com.killprojects.client.dto.GetTranslationsResponse;
import com.killprojects.client.exceptions.HttpRequestException;
import com.killprojects.client.exceptions.UnknownException;

/**
 * Created by vladimir on 02.03.2018.
 */
public interface ApiClient {

    AuthResponse auth(String login, String password, HttpPropertyContext context) throws HttpRequestException, UnknownException;

    GetTranslationsResponse getTranslations(String word, HttpPropertyContext propertyContext) throws HttpRequestException, UnknownException;

    AddWordResponse addWord(String word, String translate, String context, HttpPropertyContext propertyContext) throws HttpRequestException, UnknownException;
}
