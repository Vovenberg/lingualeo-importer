package com.killprojects.client.common;

import com.killprojects.client.SelectionType;
import com.killprojects.client.dto.User;
import com.killprojects.client.dto.Word;
import com.killprojects.common.InternalSystemException;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Created by vladimir on 05.03.2018.
 */
public interface SmartClientService {
    Pair<Long, User> auth(String login, String password) throws InternalSystemException;

    Word smartAddWord(String word, SelectionType selectionType, Long sessionId) throws InternalSystemException;
}
