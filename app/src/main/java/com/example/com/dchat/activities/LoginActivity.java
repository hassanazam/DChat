package com.example.com.dchat.activities;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.com.dchat.R;
import com.example.com.dchat.fragments.LoginFragment;

public class LoginActivity extends BaseActivity implements View.OnClickListener, LoginFragment.CallBacks {
    private static final int REQUEST_NARROW_LOGIN = 1;
    private static final int REQUEST_REGISTER = 2;
    private static final int REQUEST_EXTERNAL_LOGIN = 3;

    private View loginButton;
    private View registerButton;
    private View facebookLogInButton;
    private View googleLogInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.activity_login_login);
        registerButton = findViewById(R.id.activity_login_register);
        facebookLogInButton = findViewById(R.id.activity_login_facebook);
        googleLogInButton = findViewById(R.id.activity_login_google);

        if(loginButton != null) {
            /* On phone */
            loginButton.setOnClickListener(this);
        }

        registerButton.setOnClickListener(this);
        facebookLogInButton.setOnClickListener(this);
        googleLogInButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == loginButton) {
            startActivityForResult(new Intent(this, LoginNarrowActivity.class),REQUEST_NARROW_LOGIN);
        }
        else if(v == registerButton) {
            startActivityForResult(new Intent(this, RegisterActivity.class), REQUEST_REGISTER);
        }
        else if(v == facebookLogInButton) {
            doExternalLogin("Facebook");
        }
        else if(v == googleLogInButton) {
            doExternalLogin("Google");
        }
    }

    private void doExternalLogin(String externalService) {
        Intent intent = new Intent(this, ExternalLoginActivity.class);
        intent.putExtra(ExternalLoginActivity.EXTRA_EXTERNAL_SERVICE, externalService);
        startActivityForResult(intent, REQUEST_EXTERNAL_LOGIN);        
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode != RESULT_OK)
            return;

        if(requestCode == REQUEST_NARROW_LOGIN ||
           requestCode == REQUEST_REGISTER ||
           requestCode == REQUEST_EXTERNAL_LOGIN)
            finishLogin();
    }

    private void finishLogin () {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onLoggedIn() {
        finishLogin();
    }
}
