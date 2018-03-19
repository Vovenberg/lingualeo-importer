package com.killprojects.client.service;

import com.alibaba.fastjson.JSON;
import com.killprojects.client.common.ApiClient;
import com.killprojects.client.common.HttpPropertyContext;
import com.killprojects.client.common.dto.AbsractSessionApiResponse;
import com.killprojects.client.common.dto.AddWordResponse;
import com.killprojects.client.common.dto.AuthResponse;
import com.killprojects.client.common.dto.GetTranslationsResponse;
import com.killprojects.client.common.exceptions.ClientErrors.HttpRequestException;
import com.killprojects.client.common.exceptions.ClientErrors.UnknownException;
import com.killprojects.client.service.session.deprecated.SessionAction;
import com.killprojects.client.service.session.deprecated.SessionMode;
import com.killprojects.common.InternalSystemException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Created by vladimir on 02.03.2018.
 */
@Service
public class LeoApiClient implements ApiClient {

    private static final String AUTH_URL = "http://api.lingualeo.com/api/login";
    private static final String GET_TRANSLATES_URL = "http://api.lingualeo.com/gettranslates";
    private static final String ADD_WORD_URL = "http://api.lingualeo.com/addword";

    @Override
    public AuthResponse auth(String login, String password, HttpPropertyContext propertyContext)
            throws InternalSystemException {

        RequestBuilder requestBuilder;
        try {
            requestBuilder = RequestBuilder.post(AUTH_URL)
                    .setEntity(new UrlEncodedFormEntity(Arrays.asList(
                            new BasicNameValuePair("email", login),
                            new BasicNameValuePair("password", password))));
        } catch (UnsupportedEncodingException e) {
            throw new HttpRequestException(e);
        }
        HttpUriRequest uriRequest = buildWithCommonProperty(requestBuilder, propertyContext);

        return executeAndParse(uriRequest, AuthResponse.class);
    }

    @Override
    public GetTranslationsResponse getTranslations(String word, HttpPropertyContext propertyContext)
            throws InternalSystemException {
        RequestBuilder requestBuilder = RequestBuilder.get(GET_TRANSLATES_URL)
                .addParameter("word", word);
        HttpUriRequest uriRequest = buildWithCommonProperty(requestBuilder, propertyContext);

        return executeAndParse(uriRequest, GetTranslationsResponse.class);
    }

    @Override
    public AddWordResponse addWord(String word, String translate, String context,
                                   HttpPropertyContext propertyContext)
            throws InternalSystemException {
        RequestBuilder requestBuilder;
        try {
            requestBuilder = RequestBuilder.post(ADD_WORD_URL)
                    .setEntity(new UrlEncodedFormEntity(Arrays.asList(
                            new BasicNameValuePair("word", word),
                            new BasicNameValuePair("tword", translate),
                            new BasicNameValuePair("context", context))));
        } catch (UnsupportedEncodingException e) {
            throw new HttpRequestException(e);
        }
        HttpUriRequest uriRequest = buildWithCommonProperty(requestBuilder, propertyContext);

        return executeAndParse(uriRequest, AddWordResponse.class);
    }

    private HttpUriRequest buildWithCommonProperty(RequestBuilder requestBuilder, HttpPropertyContext propertyContext) {
        propertyContext.getCookie().ifPresent(cookie -> {
            requestBuilder.addHeader("Connection", "keep-alive");
            requestBuilder.addHeader("Host", "api.lingualeo.com");
            requestBuilder.addHeader("Content-Type", "application/x-www-form-urlencoded");
            requestBuilder.addHeader("Cookie", cookie);
            requestBuilder.setCharset(Charset.defaultCharset());
        });

        RequestConfig.Builder configBuilder = RequestConfig.custom();
        propertyContext.getTimeout().ifPresent(configBuilder::setConnectTimeout);

        requestBuilder.setConfig(configBuilder.build());
        return requestBuilder.build();
    }

    private <T extends AbsractSessionApiResponse> T executeAndParse(HttpUriRequest uriRequest,
                                                                    Class<T> classToParse)
            throws HttpRequestException, UnknownException {
        T responseObject;

        CookieStore cookieStore = new BasicCookieStore();
        try (CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultCookieStore(cookieStore).build()) {
            CloseableHttpResponse response = httpClient.execute(uriRequest);

            InputStream responseStream = response.getEntity().getContent();
            responseObject = JSON.parseObject(responseStream, classToParse, null);
        } catch (ClientProtocolException e) {
            throw new HttpRequestException(e);
        } catch (IOException e) {
            throw new UnknownException(e);
        }

        responseObject.setCookies(cookieStore.getCookies());
        return responseObject;
    }
}
