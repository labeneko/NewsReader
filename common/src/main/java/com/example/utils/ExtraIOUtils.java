package com.example.utils;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.concurrent.Callable;

public final class ExtraIOUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExtraIOUtils.class);

    private ExtraIOUtils() {
    }

    public static String toStringOrNull(final InputStream inputStream) {
        return toStringOrNull(inputStream, Charset.defaultCharset());
    }

    public static String toStringOrNull(final InputStream inputStream, final Charset charset) {
        try {
            return IOUtils.toString(inputStream, charset.displayName());
        } catch(final Exception e) {
            LOGGER.error("toStringOrNull error");
            return null;
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

    public static byte[] toByteArrayOrNull(final InputStream inputStream) {
        try {
            return IOUtils.toByteArray(inputStream);
        } catch(final Exception e) {
            LOGGER.error("toByteArray error", e);
            return null;
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

    public static void writeQuietly(final byte[] data, final File file) {
        if(data == null || file == null) {
            return;
        }
        final OutputStream outputStream = openFileOutputStreamOrNull(file);
        if(outputStream == null) {
            return;
        }
        try {
            IOUtils.write(data, outputStream);
        } catch(final Exception e) {
            LOGGER.error("writeQuietly error", e);
        } finally {
            IOUtils.closeQuietly(outputStream);
        }
    }

    public static FileInputStream openFileInputStreamOrNull(final File file) {
        return MethodCallUtils.callOrNull(new Callable<FileInputStream>() {
            @Override
            public FileInputStream call() throws Exception {
                return new FileInputStream(file);
            }
        });
    }

    public static FileOutputStream openFileOutputStreamOrNull(final File file) {
        return MethodCallUtils.callOrNull(new Callable<FileOutputStream>() {
            @Override
            public FileOutputStream call() throws Exception {
                return new FileOutputStream(file);
            }
        });
    }
}