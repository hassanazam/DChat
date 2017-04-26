package com.example.com.dchat.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.com.dchat.infrastructure.DChatApplication;

public abstract class BaseActivity extends AppCompatActivity{
    protected DChatApplication application;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        application = (DChatApplication) getApplication();
    }
}



