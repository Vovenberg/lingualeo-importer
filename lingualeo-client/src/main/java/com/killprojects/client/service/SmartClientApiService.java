package com.killprojects.client.service;

import com.killprojects.client.SelectionType;
import com.killprojects.client.SmartClientApi;
import com.killprojects.client.dto.Word;
import com.killprojects.common.Result;
import org.springframework.stereotype.Service;

/**
 * Created by vladimir on 04.03.2018.
 */
@Service
public class SmartClientApiService extends AbstractClientApiService implements SmartClientApi {
    @Override
    public Result<Boolean> auth(String login, String password) {
        return null;
    }

    @Override
    public Result<Word> smartAddWord(String word, SelectionType selectionType) {
        return null;
    }
}
