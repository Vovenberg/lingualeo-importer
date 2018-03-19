package com.killprojects.client.service.session.deprecated;

import com.killprojects.client.common.HttpPropertyContext;
import com.killprojects.client.service.session.SessionStorage;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Aspect
@Component
public class SessionAspect {

    @Autowired
    private SessionStorage storage;

    @Pointcut(value = "@annotation(sessionMode)")
    public void sessionModeAnnotate(SessionMode sessionMode) {}



    @Around(value = "sessionModeAnnotate(sessionMode)")
    public Object saveSessionMode(ProceedingJoinPoint joinPoint, SessionMode sessionMode) throws Throwable {

        //todo dirty hack. Need reimplemented without aspect, with tricky pattern
        HttpPropertyContext httpPropertyContext = Stream.of(joinPoint.getArgs().clone())
                .filter(obj -> obj instanceof HttpPropertyContext)
                .map(obj -> ((HttpPropertyContext) obj))
                .findFirst().orElseThrow(IllegalAccessError::new);

        switch (sessionMode.mode()) {
            case CREATE_SESSION:
                break;
            case SESSION_REQUIRED:
                break;
            case SESSION_NOT_IMPORTANT:
                break;
        }
        Object result = joinPoint.proceed();
        return result;
    }
}
