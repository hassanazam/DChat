package com.example.com.dchat.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.com.dchat.R;
import com.example.com.dchat.services.Account;
import com.squareup.otto.Subscribe;

import static android.app.Activity.RESULT_OK;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    private EditText usernametext;
    private EditText passwordtext;
    private EditText emailtext;
    private Button registerButton;
    private View progressbar;
    private String defaultRegisterButtonText;

    @Override
    protected void onCreate (Bundle savedState) {
        super.onCreate(savedState);

        setContentView(R.layout.activity_register);

        usernametext = (EditText) findViewById(R.id.activity_register_username);
        emailtext = (EditText) findViewById(R.id.activity_register_email);
        passwordtext = (EditText) findViewById(R.id.activity_register_password);
        registerButton = (Button) findViewById(R.id.register_activity_registerButton);
        progressbar = findViewById(R.id.activity_register_progressBar);

        registerButton.setOnClickListener(this);
        defaultRegisterButtonText = registerButton.getText().toString();
        progressbar.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        if(v == registerButton) {

            progressbar.setVisibility(View.VISIBLE);
            registerButton.setText("");
            registerButton.setEnabled(false);
            usernametext.setEnabled(false);
            passwordtext.setEnabled(false);
            emailtext.setEnabled(false);

            bus.post(new Account.RegisterRequest(
                    usernametext.getText().toString(),
                    emailtext.getText().toString(),
                    passwordtext.getText().toString()
            ));

        }

    }

    @Subscribe
    public void registerResponse(Account.RegisterResponse response) {
        onUserResponse(response);
    }

    @Subscribe
    public void externalRegisterResponse(Account.RegisterWIthExternalTokenResponse response) {
        onUserResponse(response);
    }

    private void onUserResponse(Account.UserResponse response) {
        if(response.didSucceed()) {
            setResult(RESULT_OK);
            finish();
            return;
        }

        response.showErrorToast(this);
        usernametext.setError(response.getPropertyError("username"));
        passwordtext.setError(response.getPropertyError("password"));
        emailtext.setError(response.getPropertyError("email"));

        registerButton.setEnabled(true);
        usernametext.setEnabled(true);
        passwordtext.setEnabled(true);
        emailtext.setEnabled(true);

        progressbar.setVisibility(View.GONE);
        registerButton.setText(defaultRegisterButtonText);
    }
}
