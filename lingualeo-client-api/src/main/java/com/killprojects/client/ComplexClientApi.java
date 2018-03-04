package com.killprojects.client;

import com.killprojects.client.dto.Translations;
import com.killprojects.client.dto.Word;
import com.killprojects.common.Result;

/**
 * Created by vladimir on 04.03.2018.
 */
public interface ComplexClientApi extends AuthClientApi {

    Result<Translations> getTranslate(String word);

    Result<Word> addWord(String word, String translate);
}
