package com.killprojects.client.common;

import com.killprojects.client.common.dto.AddWordResponse;
import com.killprojects.client.common.dto.AuthResponse;
import com.killprojects.client.common.dto.GetTranslationsResponse;
import com.killprojects.client.common.exceptions.ClientErrors;
import com.killprojects.client.common.exceptions.ClientErrors.HttpRequestException;
import com.killprojects.client.common.exceptions.ClientErrors.UnknownException;
import com.killprojects.common.InternalSystemException;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Created by vladimir on 02.03.2018.
 */
public interface ApiClient {

    AuthResponse auth(String login, String password, HttpPropertyContext context) throws InternalSystemException;

    GetTranslationsResponse getTranslations(String word, HttpPropertyContext propertyContext) throws InternalSystemException;

    AddWordResponse addWord(String word, String translate, String context, HttpPropertyContext propertyContext) throws InternalSystemException;
}
