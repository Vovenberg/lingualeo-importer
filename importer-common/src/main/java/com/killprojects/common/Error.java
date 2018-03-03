package com.killprojects.common;

import java.io.Serializable;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Created by vladimir on 03.03.2018.
 */
public class Error implements Serializable {

    private ErrorType errorType;
    private final Throwable throwable;

    private Error(ErrorType errorType, Throwable throwable) {
        this.errorType = errorType;
        this.throwable = throwable;
    }

    public static Error is(ErrorType errorType, Throwable throwable) {
        Objects.requireNonNull(throwable);
        Objects.requireNonNull(errorType);
        return new Error(errorType, throwable);
    }

    public Throwable getException() {
        return throwable;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public void process(Consumer<Throwable> func) {
        func.accept(throwable);
    }
}
