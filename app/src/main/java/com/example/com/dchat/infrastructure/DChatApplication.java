package com.example.com.dchat.infrastructure;

import android.app.Application;

import com.example.com.dchat.services.Module;
import com.squareup.otto.Bus;

public class DChatApplication extends Application {
    private Auth auth;
    private Bus bus;

    public DChatApplication() {
        bus = new Bus();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        auth = new Auth(this);
        Module.register(this);
    }

    public Auth getAuth() {
        return auth;
    }

    public Bus getBus() {
        return bus;
    }
}
