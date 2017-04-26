package com.example.com.dchat.activities;

import android.content.Intent;
import android.os.Bundle;

public abstract class BaseAuthenticatedActivity extends BaseActivity {
    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(!application.getAuth().getUser().isLoggedIn()) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }

        onDChatCreate(savedInstanceState);
    }

    protected abstract void onDChatCreate(Bundle savedInstanceState);
}
