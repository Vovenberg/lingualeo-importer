package com.killprojects.client.service.session.deprecated;

import com.killprojects.client.common.HttpPropertyContext;
import com.killprojects.client.common.dto.AuthResponse;

public enum SessionAction {

    CREATE_SESSION,
    SESSION_REQUIRED,
    SESSION_NOT_IMPORTANT;


    public void checkBeforeRequest(HttpPropertyContext propertyContext) {

    }

    public void processResponse(AuthResponse authResponse) {

    }
}
