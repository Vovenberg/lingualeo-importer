package com.killprojects.client.exceptions;

/**
 * Created by vladimir on 05.03.2018.
 */
public enum ClientErrorsDictionary {
    HTTP_ERROR(1, "Http error"),
    JSON_PARSE_ERROR(2, "Json parse error"),
    ALREADY_AUTHENTIFACATED(3, "Authentification already accomplished"),
    UNKNOWN_ERROR(4, "Unknown internal error"),
    NONE_AUTHENTIFACATED_REQUEST(5, "NONE_AUTHENTIFACATED_REQUEST");

    private int code;
    private String message;

    ClientErrorsDictionary(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
