package com.killprojects.client.service;

import com.killprojects.client.SelectionType;
import com.killprojects.client.common.HttpPropertyContext;
import com.killprojects.client.common.dto.AuthResponse;
import com.killprojects.client.common.dto.SessionContext;
import com.killprojects.client.common.dto.SessionId;
import com.killprojects.client.common.SmartClientService;
import com.killprojects.client.dto.Word;
import com.killprojects.common.InternalSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by vladimir on 04.03.2018.
 */
@Service
public class LeoSmartClientService implements SmartClientService {

    @Autowired
    private LeoApiClient client;

    @Override
    public Boolean auth(String login, String password) throws InternalSystemException {
        AuthResponse authResponse = client.auth(login, password, HttpPropertyContext.empty());
        return true;
    }

    @Override
    public Word smartAddWord(String word, SelectionType selectionType) throws InternalSystemException {
        return null;
    }
}
