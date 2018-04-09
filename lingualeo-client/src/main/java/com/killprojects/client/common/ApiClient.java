package com.killprojects.client.common;

import com.killprojects.client.common.contexts.HttpPropertyContext;
import com.killprojects.client.common.dto.AddWordResponse;
import com.killprojects.client.common.dto.AuthResponse;
import com.killprojects.client.common.dto.GetTranslationsResponse;
import com.killprojects.common.InternalSystemException;

/**
 * Created by vladimir on 02.03.2018.
 */
public interface ApiClient {

    AuthResponse auth(String login, String password, HttpPropertyContext context) throws InternalSystemException;

    GetTranslationsResponse getTranslations(String word, HttpPropertyContext propertyContext) throws InternalSystemException;

    AddWordResponse addWord(String word, String translate, String context, HttpPropertyContext propertyContext) throws InternalSystemException;
}
