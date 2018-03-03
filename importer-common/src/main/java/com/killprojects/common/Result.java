package com.killprojects.common;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Created by vladimir on 03.03.2018.
 */
public final class Result<T> implements Serializable {

    private final T result;
    private final boolean isSuccess;
    private final Error error;

    private Result(T result, boolean isSuccess, Error error) {
        this.result = result;
        this.isSuccess = isSuccess;
        this.error = error;
    }

    public static <T> Result<T> success(T result) {
        Objects.requireNonNull(result);
        return new Result<>(result, true, null);
    }

    public static Result error(Error error) {
        Objects.requireNonNull(error);
        return new Result<>(null, false, error);
    }

    public boolean isSuccess() {
        return isSuccess;
    }


    public Optional<T> getResult() {
        return Optional.ofNullable(result);
    }

    public Optional<Error> getError() {
        return Optional.ofNullable(error);
    }

    public Result<T> ifSuccess(Consumer<T> func) {
        if (isSuccess && result != null) {
            func.accept(result);
        }
        return this;
    }

    public Result<T> ifError(Consumer<Error> func) {
        if (!isSuccess && error != null) {
            func.accept(error);
        }
        return this;
    }
}
