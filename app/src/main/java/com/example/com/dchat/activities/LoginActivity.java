package com.example.com.dchat.activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.com.dchat.R;

public class LoginActivity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
    }

    public void doLogin(View view) {
        application.getAuth().getUser().setLoggedIn(true);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
