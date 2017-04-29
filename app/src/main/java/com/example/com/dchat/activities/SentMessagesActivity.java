package com.example.com.dchat.activities;

import android.os.Bundle;

import com.example.com.dchat.R;
import com.example.com.dchat.views.MainNavDrawer;

public class SentMessagesActivity extends BaseAuthenticatedActivity {

    @Override
    protected void onDChatCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_sent_messages);
        setNavDrawer(new MainNavDrawer(this));
    }
}
