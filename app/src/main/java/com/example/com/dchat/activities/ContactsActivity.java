package com.example.com.dchat.activities;

import android.os.Bundle;

import com.example.com.dchat.R;
import com.example.com.dchat.views.MainNavDrawer;

public class ContactsActivity extends BaseAuthenticatedActivity {

    @Override
    protected void onDChatCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_contacts);
        setNavDrawer(new MainNavDrawer(this));
    }
}
