package com.killprojects.client.controller;

import com.killprojects.client.ComplexClientApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vladimir on 04.03.2018.
 */
@RestController
@RequestMapping("/api/complex/")
public class ComplexClientRestController {

    private ComplexClientApi complexClientService;

    @Autowired
    public void setComplexClientApi(ComplexClientApi complexClientApi) {
        this.complexClientService = complexClientApi;
    }
}
