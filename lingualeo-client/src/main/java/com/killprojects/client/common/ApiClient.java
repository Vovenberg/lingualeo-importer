package com.killprojects.client.common;

import com.killprojects.client.common.dto.AddWordResponse;
import com.killprojects.client.common.dto.AuthResponse;
import com.killprojects.client.common.dto.GetTranslationsResponse;
import com.killprojects.client.common.exceptions.ClientErrors;
import com.killprojects.client.common.exceptions.ClientErrors.HttpRequestException;
import com.killprojects.client.common.exceptions.ClientErrors.UnknownException;

/**
 * Created by vladimir on 02.03.2018.
 */
public interface ApiClient {

    AuthResponse auth(String login, String password, HttpPropertyContext context) throws HttpRequestException, UnknownException;

    GetTranslationsResponse getTranslations(String word, HttpPropertyContext propertyContext) throws HttpRequestException, UnknownException;

    AddWordResponse addWord(String word, String translate, String context, HttpPropertyContext propertyContext) throws HttpRequestException, UnknownException;
}
