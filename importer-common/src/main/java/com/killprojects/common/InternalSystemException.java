package com.killprojects.common;

/**
 * Created by vladimir on 05.03.2018.
 */
public class InternalSystemException extends Exception {

    private int code;

    public InternalSystemException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public InternalSystemException(int code, String message) {
        super(message);
        this.code = code;
    }

}
