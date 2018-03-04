package com.killprojects.common;

import java.util.function.Consumer;

/**
 * Created by vladimir on 05.03.2018.
 */
public final class ResultHandler {

    private ResultHandler() {
    }

    public static <T> Result<T> handleResult(CommonSupplier<T> supplier, Consumer<InternalSystemException> logger) {
        try {
            T value = supplier.get();
            return Result.success(value);
        } catch (InternalSystemException e) {
            logger.accept(e);
            return Result.error(Error.is(e));
        }
    }
}
