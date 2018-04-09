package com.killprojects.client;

import com.killprojects.client.dto.User;
import com.killprojects.common.Result;

/**
 * Created by vladimir on 04.03.2018.
 */
interface AuthClientApi {

    Result<User> auth(String login, String password);

}
