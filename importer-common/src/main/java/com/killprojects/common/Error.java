package com.killprojects.common;

import java.io.Serializable;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Created by vladimir on 03.03.2018.
 */
public class Error implements Serializable {

    private final InternalSystemException exception;

    private Error(InternalSystemException exception) {
        this.exception = exception;
    }

    public static Error is(InternalSystemException throwable) {
        Objects.requireNonNull(throwable);
        return new Error(throwable);
    }

    public InternalSystemException getException() {
        return exception;
    }

    public void process(Consumer<InternalSystemException> func) {
        func.accept(exception);
    }
}
