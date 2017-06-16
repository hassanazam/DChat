package com.example.com.dchat.services;


import android.os.Handler;

import com.example.com.dchat.infrastructure.DChatApplication;
import com.squareup.otto.Bus;

import java.util.Random;

public abstract class BaseInMemoryService {
    protected final Bus bus;
    protected final DChatApplication application;
    protected final Handler handler;
    protected final Random random;

    protected BaseInMemoryService(DChatApplication application) {
        this.application = application;
        bus = application.getBus();
        handler = new Handler();
        random = new Random();

        bus.register(this);
    }

    protected void invokeDelayed(Runnable runnable, long msMin, long msMax) {
        if(msMin > msMax)
            throw new IllegalArgumentException("Min must be smaller than Max");

        long delay = (long)(random.nextDouble() * (msMax-msMin)) + msMin;

        handler.postDelayed(runnable, delay);
    }

    protected void postDelayed(final Object event, long msMin, long msMax) {
        invokeDelayed(new Runnable() {
            @Override
            public void run() {
                bus.post(event);
            }
        }, msMin, msMax);
    }

    protected void postDelayed(Object event, long ms) {
        postDelayed(event, ms, ms);
    }

    protected void postDelayed(Object event) {
        postDelayed(event, 600, 1200);
    }

}
