package com.example.com.dchat.infrastructure;

import android.app.Application;

public class DChatApplication extends Application {
    private Auth auth;

    @Override
    public void onCreate() {
        super.onCreate();
        auth = new Auth(this);
    }

    public Auth getAuth() {
        return auth;
    }
}
