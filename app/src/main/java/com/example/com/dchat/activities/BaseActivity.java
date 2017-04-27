package com.example.com.dchat.activities;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.com.dchat.R;
import com.example.com.dchat.infrastructure.DChatApplication;

public abstract class BaseActivity extends AppCompatActivity{
    protected DChatApplication application;
    protected Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        application = (DChatApplication) getApplication();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResId) {
        super.setContentView(layoutResId);

        toolbar = (Toolbar) findViewById(R.id.include_toolbar);
        if(toolbar != null)
            setSupportActionBar(toolbar);
    }
}



