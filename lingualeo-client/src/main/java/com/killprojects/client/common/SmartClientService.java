package com.killprojects.client.common;

import com.killprojects.client.SelectionType;
import com.killprojects.client.dto.Word;
import com.killprojects.common.InternalSystemException;

/**
 * Created by vladimir on 05.03.2018.
 */
public interface SmartClientService {
    Boolean auth(String login, String password) throws InternalSystemException;

    Word smartAddWord(String word, SelectionType selectionType) throws InternalSystemException;
}
