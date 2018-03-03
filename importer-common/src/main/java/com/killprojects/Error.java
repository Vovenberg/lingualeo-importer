package com.killprojects;

/**
 * Created by vladimir on 03.03.2018.
 */
public class Error {

    private Throwable throwable;

    private Error(Throwable throwable) {
        this.throwable = throwable;
    }

    public static Error is(Throwable throwable) {
        return new Error(throwable);
    }

    public Throwable getThrowable() {
        return throwable;
    }

    @Override
    public String toString() {
        return throwable.getMessage();
    }
}
