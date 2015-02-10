package com.example.utils;

public abstract class ThrowableRunner implements Runnable {

    public abstract void onRun() throws Exception;

    @Override
    public void run() {
        try {
            onRun();
        } catch(final Exception e) {
            throw new RuntimeException(e);
        }
    }
}
