package com.killprojects.client.controller;

import com.killprojects.client.SelectionType;
import com.killprojects.client.SmartClientApi;
import com.killprojects.client.common.exceptions.ClientErrors;
import com.killprojects.client.dto.User;
import com.killprojects.client.dto.Word;
import com.killprojects.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vladimir on 04.03.2018.
 */
@RestController
@RequestMapping("/api/smart/")
public class SmartClientRestController {


    private SmartClientApi smartLeoClientService;


    @GetMapping(path = "auth")
    public Result<User> auth(@RequestParam(value = "login") String login,
                                @RequestParam(value = "password") String password) {

        return smartLeoClientService.auth(login, password);
    }

    @GetMapping(path = "addWord")
    public Result<Word> addWord(@RequestParam(value = "word") String word,
                                @RequestParam(value = "sessionId") String sessionId) {

        return smartLeoClientService.smartAddWord(word, SelectionType.VOTES_SELECTION, Long.valueOf(sessionId));
    }

    @Autowired
    public void setSmartLeoClientService(SmartClientApi smartLeoClientService) {
        this.smartLeoClientService = smartLeoClientService;
    }
}
