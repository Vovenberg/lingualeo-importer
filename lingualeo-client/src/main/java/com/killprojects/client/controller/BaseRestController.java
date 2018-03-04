package com.killprojects.client.controller;

import com.killprojects.common.Result;
import com.killprojects.client.common.ApiClient;
import com.killprojects.client.common.HttpPropertyContext;
import com.killprojects.client.common.dto.GetTranslationsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vladimir on 03.03.2018.
 */
@RestController
@RequestMapping("/api/base/")
public class BaseRestController {

    private ApiClient linguaLeoApiClient;

    @GetMapping(path = "hello")
    public String helloWorld() {
        return "HELLO FUCKING WORLD";
    }

    @GetMapping(path = "getTranslations")
    public Result<GetTranslationsResponse> getTranslationsResponse(@RequestParam(value = "word") String word)
            throws UnknownException, HttpRequestException {

        GetTranslationsResponse translationsResponse = linguaLeoApiClient.getTranslations(word, HttpPropertyContext.empty());
        return Result.success(translationsResponse);
    }

    @Autowired
    public void setLinguaLeoApiClient(ApiClient linguaLeoApiClient) {
        this.linguaLeoApiClient = linguaLeoApiClient;
    }
}