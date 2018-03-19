package com.killprojects.client.service.api;

import com.killprojects.client.SelectionType;
import com.killprojects.client.SmartClientApi;
import com.killprojects.client.dto.Word;
import com.killprojects.client.service.LeoComplexClientService;
import com.killprojects.client.service.LeoSmartClientService;
import com.killprojects.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.killprojects.common.ResultHandler.handleResult;

/**
 * Created by vladimir on 05.03.2018.
 */
@Service
public class LeoSmartClientApiService implements SmartClientApi {

    @Autowired
    private LeoSmartClientService smartClientService;

    @Override
    public Result<Boolean> auth(String login, String password) {
        return handleResult(() -> smartClientService.auth(login, password), System.out::println);
    }

    @Override
    public Result<Word> smartAddWord(String word, SelectionType selectionType) {
        return handleResult(() -> smartClientService.smartAddWord(word, selectionType), System.out::println);
    }
}
