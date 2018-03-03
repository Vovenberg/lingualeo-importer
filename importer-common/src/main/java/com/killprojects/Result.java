package com.killprojects;

/**
 * Created by vladimir on 03.03.2018.
 */
public final class Result<T> {

    private T result;
    private boolean isSuccess;
    private Error error;

    private Result(T result, boolean isSuccess, Error error) {
        this.result = result;
        this.isSuccess = isSuccess;
        this.error = error;
    }

    public static <T> Result<T> success(T result) {
        return new Result<>(result, true, null);
    }

    public static Result error(Error error) {
        return new Result<>(null, false, error);
    }

    public T getResult() {
        return result;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public Error getError() {
        return error;
    }
}
