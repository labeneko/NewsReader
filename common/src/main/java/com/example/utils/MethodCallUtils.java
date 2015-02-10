package com.example.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

public final class MethodCallUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodCallUtils.class);

    private MethodCallUtils() {
    }

    public static void callQuietly(final ThrowableRunner runner) {
        try {
            runner.run();
        } catch(final Throwable tr) {
            LOGGER.error("callQuietly error.", tr);
        }
    }

    public static <T> T callOrNull(final Callable<T> callable) {
        try {
            return callable.call();
        } catch(final Throwable tr) {
            LOGGER.error("call error.", tr);
            return null;
        }
    }

    public static <T> T callOrSubstitute(final Callable<T> callable, final T defaultValue) {
        try {
            return callable.call();
        } catch(final Throwable tr) {
            LOGGER.error("call error.", tr);
            return defaultValue;
        }
    }
}
