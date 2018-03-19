package com.killprojects.client.service;

import com.killprojects.client.common.ApiClient;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by vladimir on 17.03.2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class LeoSmartClientServiceTest {


    @Autowired
    private ApiClient client;

    @Test
    void auth() {
        assertEquals(25, 5 * 5);
    }

    @Test
    void smartAddWord() {
    }

}