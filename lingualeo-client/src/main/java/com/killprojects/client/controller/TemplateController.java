package com.killprojects.client.controller;

import com.killprojects.client.SelectionType;
import com.killprojects.client.dto.User;
import com.killprojects.client.dto.Word;
import com.killprojects.client.service.LeoSmartClientService;
import com.killprojects.common.InternalSystemException;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@Controller
public class TemplateController {


    @Autowired
    private LeoSmartClientService smartClientService;

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/smart")
    public String smart(Map<String, Object> model) {
        return "/smart";
    }

    @GetMapping("/smart/auth?{email}&{password}")
    public String smartAuth(@PathVariable("email") String email,
                        @PathVariable("password") String password,
                        Map<String, Object> model) throws InternalSystemException {
        Pair<Long, User> result = smartClientService.auth(email, password);
        model.put("sessionId", result.getLeft());
        model.put("user", result.getRight());
        return "/smart";
    }

    @GetMapping("/smart/auth?{word}&{sessionId}")
    public String smartAddWord(@PathVariable("word") String word,
                               @PathVariable("sessionId") String sessionId,
                        Map<String, Object> model) throws InternalSystemException {
        Word result = smartClientService.smartAddWord(word, SelectionType.VOTES_SELECTION, Long.valueOf(sessionId));
        model.put("result", result);
        return "/smart";
    }

}
