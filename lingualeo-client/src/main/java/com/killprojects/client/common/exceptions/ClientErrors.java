package com.killprojects.client.common.exceptions;

import com.killprojects.common.InternalSystemException;

import static com.killprojects.client.exceptions.ClientErrorsDictionary.HTTP_ERROR;
import static com.killprojects.client.exceptions.ClientErrorsDictionary.UNKNOWN_ERROR;

/**
 * Created by vladimir on 05.03.2018.
 */
public final class ClientErrors {

    private ClientErrors() {
    }

    public static class HttpRequestException extends InternalSystemException {

        public HttpRequestException(Throwable cause) {
            super(HTTP_ERROR.getCode(), HTTP_ERROR.getMessage(), cause);
        }
    }

    public static class UnknownException extends InternalSystemException {

        public UnknownException(Throwable cause) {
            super(UNKNOWN_ERROR.getCode(), UNKNOWN_ERROR.getMessage(), cause);
        }
    }
}
