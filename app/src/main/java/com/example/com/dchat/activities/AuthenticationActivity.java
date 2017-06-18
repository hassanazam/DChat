package com.example.com.dchat.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.com.dchat.R;
import com.example.com.dchat.infrastructure.Auth;
import com.example.com.dchat.services.Account;
import com.squareup.otto.Subscribe;

public class AuthenticationActivity extends BaseActivity {

    private Auth auth;
    public static final String ReturnActivity = "ReturnActivity";

    @Override
    public void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        setContentView(R.layout.activity_authentication);

        auth = application.getAuth();

        if(!auth.hasAuthToken()) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }

        bus.post(new Account.LoginWithLocalTokenRequest(auth.getAuthToken()));
    }

    @Subscribe
    public void onLoginWithLocalToken(Account.LoginWithLocalTokenResponse response) {
        if(!response.didSucceed()) {
            Toast.makeText(this, "Please login again", Toast.LENGTH_SHORT).show();
            auth.setAuthToken(null);
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }

        Intent intent;
        String returnTo = getIntent().getStringExtra(ReturnActivity);
        if(returnTo != null) {
            try {
                intent = new Intent(this, Class.forName(returnTo));
            } catch (Exception ignored) {
                intent = new Intent(this, MainActivity.class);
            }
        } else {
            intent = new Intent(this, MainActivity.class);
        }

        startActivity(intent);
        finish();
    }
}
