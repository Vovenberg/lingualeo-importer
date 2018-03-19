package com.killprojects.common;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by vladimir on 03.03.2018.
 */
public class Error implements Serializable {

    private final int code;
    private final String message;

    private Error(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static Error is(InternalSystemException exception) {
        Objects.requireNonNull(exception);
        return is(exception.getCode(), exception.getMessage());
    }

    public static Error is(int code, String message) {
        Objects.requireNonNull(code);
        Objects.requireNonNull(message);
        return new Error(code, message);
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
