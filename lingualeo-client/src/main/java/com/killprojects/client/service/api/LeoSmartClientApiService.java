package com.killprojects.client.service.api;

import com.killprojects.client.SelectionType;
import com.killprojects.client.SmartClientApi;
import com.killprojects.client.common.SmartClientService;
import com.killprojects.client.dto.User;
import com.killprojects.client.dto.Word;
import com.killprojects.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.killprojects.common.ResultHandler.handleResult;

/**
 * Created by vladimir on 05.03.2018.
 */
@Service
public class LeoSmartClientApiService implements SmartClientApi {

    private final SmartClientService smartClientService;

    @Autowired
    public LeoSmartClientApiService(SmartClientService smartClientService) {
        this.smartClientService = smartClientService;
    }

    @Override
    public Result<User> auth(String login, String password) {
        return handleResult(() -> smartClientService.auth(login, password).getRight(),
                System.out::println);
    }

    @Override
    public Result<Word> smartAddWord(String word, SelectionType selectionType, Long sessionId) {
        return handleResult(() -> smartClientService.smartAddWord(word, selectionType, sessionId),
                System.out::println);
    }
}
