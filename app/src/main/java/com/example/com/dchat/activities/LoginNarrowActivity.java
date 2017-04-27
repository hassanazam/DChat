package com.example.com.dchat.activities;


import android.os.Bundle;

import com.example.com.dchat.R;
import com.example.com.dchat.fragments.LoginFragment;

public class LoginNarrowActivity extends BaseActivity implements LoginFragment.CallBacks{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_narrow);
    }

    @Override
    public void onLoggedIn() {
        setResult(RESULT_OK);
        finish();
    }
}
