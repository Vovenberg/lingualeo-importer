//package com.killprojects.client.service.api;
//
//import com.killprojects.client.ComplexClientApi;
//import com.killprojects.client.dto.Translations;
//import com.killprojects.client.dto.Word;
//import com.killprojects.client.service.LeoComplexClientService;
//import com.killprojects.common.Result;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import static com.killprojects.common.ResultHandler.handleResult;
//
///**
// * Created by vladimir on 05.03.2018.
// */
//public class LeoComplexClientApiService implements ComplexClientApi {
//
//    @Autowired
//    private LeoComplexClientService complexClientService;
//
//    @Override
//    public Result<Boolean> auth(String login, String password) {
//        return handleResult(() -> {
//            complexClientService.auth()
//        }
//    }
//
//    @Override
//    public Result<Translations> getTranslate(String word) {
//        return handleResult(() -> {
//
//        }
//    }
//
//    @Override
//    public Result<Word> addWord(String word, String translate) {
//        return handleResult(() -> {
//
//        }
//    }
//}
