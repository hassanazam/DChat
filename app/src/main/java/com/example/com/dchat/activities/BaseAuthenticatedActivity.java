package com.example.com.dchat.activities;

import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;

public abstract class BaseAuthenticatedActivity extends BaseActivity {
    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(!application.getAuth().getUser().isLoggedIn()) {

            //if authToken is there in SharedPreferences
            if(application.getAuth().hasAuthToken()) {
                Intent intent = new Intent(this, AuthenticationActivity.class);
                intent.putExtra(AuthenticationActivity.ReturnActivity, getClass().getName());
                startActivity(intent);
            } else {
                startActivity(new Intent(this, LoginActivity.class));
            }

            finish();
            return;
        }

        onDChatCreate(savedInstanceState);
    }

    protected abstract void onDChatCreate(Bundle savedInstanceState);
}
