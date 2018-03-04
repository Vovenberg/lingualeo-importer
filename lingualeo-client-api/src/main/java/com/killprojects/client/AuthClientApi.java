package com.killprojects.client;

import com.killprojects.common.Result;

/**
 * Created by vladimir on 04.03.2018.
 */
interface AuthClientApi {

    Result<Boolean> auth(String login, String password);

}
