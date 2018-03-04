package com.killprojects.client.service;

import com.killprojects.client.common.dto.SessionContext;
import com.killprojects.client.common.dto.SessionId;
import com.killprojects.common.InternalSystemException;

import java.util.concurrent.ConcurrentHashMap;

import static com.killprojects.client.exceptions.ClientErrorsDictionary.ALREADY_AUTHENTIFACATED;

/**
 * Created by vladimir on 05.03.2018.
 */
public abstract class AbstractClientApiService {

    private ConcurrentHashMap<SessionId, SessionContext> sessions = new ConcurrentHashMap<>();

    protected boolean saveSession(SessionId id, SessionContext context) throws InternalSystemException {
        if (sessions.contains(id)) {
            throw new InternalSystemException(ALREADY_AUTHENTIFACATED.getCode(), ALREADY_AUTHENTIFACATED.getMessage());
        }

        sessions.put(id, context);
        return true;
    }

}
