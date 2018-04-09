package com.killprojects.client.service;

import com.killprojects.client.SelectionType;
import com.killprojects.client.common.SmartClientService;
import com.killprojects.client.dto.User;
import com.killprojects.client.dto.Word;
import com.killprojects.common.InternalSystemException;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Created by vladimir on 17.03.2018.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class LeoSmartClientServiceTest {


    @Autowired
    private SmartClientService client;

    @Test
    void smartAddWord() throws InternalSystemException {
        Pair<Long, User> authResult = client.auth("v.kildyushev@yandex.ru", "e598ttSamara");
        Assert.assertNotNull(authResult);

        Long sessionID = authResult.getLeft();
        Word word = client.smartAddWord("pretend", SelectionType.VOTES_SELECTION, sessionID);
        Assert.assertNotNull(word);
    }

}