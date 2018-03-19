package com.killprojects.common;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

import static com.killprojects.common.ResultStatus.ERROR;
import static com.killprojects.common.ResultStatus.SUCCESS;

/**
 * Created by vladimir on 03.03.2018.
 */
public final class Result<T> implements Serializable {

    private final T result;
    private final ResultStatus status;
    private final Error error;

    private Result(T result, ResultStatus status, Error error) {
        this.result = result;
        this.status = status;
        this.error = error;
    }

    public static <T> Result<T> success(T result) {
        Objects.requireNonNull(result);
        return new Result<>(result, SUCCESS, null);
    }

    public static <T> Result<T> error(Error error) {
        Objects.requireNonNull(error);
        return new Result<>(null, ERROR, error);
    }

    public ResultStatus getStatus() {
        return status;
    }

    public Optional<T> getResult() {
        return Optional.ofNullable(result);
    }

    public Optional<Error> getError() {
        return Optional.ofNullable(error);
    }

    public Result<T> ifSuccess(Consumer<T> func) {
        if (status == SUCCESS && result != null) {
            func.accept(result);
        }
        return this;
    }

    public Result<T> ifError(Consumer<Error> func) {
        if (status == SUCCESS && error != null) {
            func.accept(error);
        }
        return this;
    }
}
