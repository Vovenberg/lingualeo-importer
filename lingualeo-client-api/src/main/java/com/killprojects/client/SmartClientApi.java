package com.killprojects.client;

import com.killprojects.client.dto.Word;
import com.killprojects.common.Result;

/**
 * Created by vladimir on 04.03.2018.
 */
public interface SmartClientApi extends AuthClientApi {

    Result<Word> smartAddWord(String word, SelectionType selectionType, Long sessionId);

}
