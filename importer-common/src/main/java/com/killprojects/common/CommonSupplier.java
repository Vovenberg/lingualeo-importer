package com.killprojects.common;

/**
 * Created by vladimir on 05.03.2018.
 */
@FunctionalInterface
public interface CommonSupplier<T> {

    T get() throws InternalSystemException;
}
