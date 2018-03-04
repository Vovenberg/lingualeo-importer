package com.killprojects.client.service;

import com.alibaba.fastjson.JSON;
import com.killprojects.client.common.ApiClient;
import com.killprojects.client.common.HttpPropertyContext;
import com.killprojects.client.common.dto.AddWordResponse;
import com.killprojects.client.common.dto.ApiResponse;
import com.killprojects.client.common.dto.AuthResponse;
import com.killprojects.client.common.dto.GetTranslationsResponse;
import com.killprojects.client.common.exceptions.ClientErrors.HttpRequestException;
import com.killprojects.client.common.exceptions.ClientErrors.UnknownException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by vladimir on 02.03.2018.
 */
@Service
public class LinguaLeoApiClient implements ApiClient {

    private static final String AUTH_URL = "http://api.lingualeo.com/api/login";
    private static final String GET_TRANSLATES_URL = "http://api.lingualeo.com/gettranslates";
    private static final String ADD_WORD_URL = "http://api.lingualeo.com/addword";

    @Override
    public AuthResponse auth(String login, String password, HttpPropertyContext propertyContext)
            throws HttpRequestException, UnknownException {
        RequestBuilder requestBuilder = RequestBuilder.get(AUTH_URL)
                .addParameter("login", login)
                .addParameter("password", password);
        HttpUriRequest uriRequest = buildWithCommonProperty(requestBuilder, propertyContext);

        return executeAndParse(uriRequest, AuthResponse.class);
    }

    @Override
    public GetTranslationsResponse getTranslations(String word, HttpPropertyContext propertyContext)
            throws HttpRequestException, UnknownException {
        RequestBuilder requestBuilder = RequestBuilder.get(GET_TRANSLATES_URL)
                .addParameter("word", word);
        HttpUriRequest uriRequest = buildWithCommonProperty(requestBuilder, propertyContext);

        return executeAndParse(uriRequest, GetTranslationsResponse.class);
    }

    @Override
    public AddWordResponse addWord(String word, String translate, String context,
                                   HttpPropertyContext propertyContext) throws HttpRequestException, UnknownException {
        RequestBuilder requestBuilder = RequestBuilder.get(ADD_WORD_URL)
                .addParameter("word", word)
                .addParameter("translate", translate)
                .addParameter("context", context);
        HttpUriRequest uriRequest = buildWithCommonProperty(requestBuilder, propertyContext);

        return executeAndParse(uriRequest, AddWordResponse.class);
    }

    private HttpUriRequest buildWithCommonProperty(RequestBuilder requestBuilder, HttpPropertyContext propertyContext) {
        propertyContext.getCookie().ifPresent(cookie -> requestBuilder.addParameter("Cookie", cookie));

        RequestConfig.Builder configBuilder = RequestConfig.custom();
        propertyContext.getTimeout().ifPresent(configBuilder::setConnectTimeout);

        requestBuilder.setConfig(configBuilder.build());
        return requestBuilder.build();
    }

    private <T extends ApiResponse> T executeAndParse(HttpUriRequest uriRequest, Class<T> classToParse)
            throws HttpRequestException, UnknownException {
        T getTranslationsResponse;

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            CloseableHttpResponse response = httpClient.execute(uriRequest);

            InputStream responseStream = response.getEntity().getContent();
            getTranslationsResponse = JSON.parseObject(responseStream, classToParse, null);
        } catch (ClientProtocolException e) {
            throw new HttpRequestException(e);
        } catch (IOException e) {
            throw new UnknownException(e);
        }

        return getTranslationsResponse;
    }
}
