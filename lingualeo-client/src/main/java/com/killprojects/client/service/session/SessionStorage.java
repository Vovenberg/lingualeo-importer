package com.killprojects.client.service.session;

import com.killprojects.client.common.dto.SessionContext;
import com.killprojects.client.common.dto.SessionId;
import com.killprojects.common.InternalSystemException;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import static com.killprojects.client.exceptions.ClientErrorsDictionary.ALREADY_AUTHENTIFACATED;

/**
 * Created by vladimir on 05.03.2018.
 */
@Component
public class SessionStorage {

    private AtomicLong idCounter = new AtomicLong(1);

    private ConcurrentHashMap<Long, SessionContext> sessions = new ConcurrentHashMap<>();

    public long saveSession(SessionContext context) {
        long key = idCounter.incrementAndGet();
        sessions.put(key, context);
        return key;
    }

    public boolean isSessionExist(Long sessionId) {
        return sessions.containsKey(sessionId);
    }

    public SessionContext get(Long id) {
        return sessions.get(id);
    }
}
