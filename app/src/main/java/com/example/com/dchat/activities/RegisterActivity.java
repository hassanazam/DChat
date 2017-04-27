package com.example.com.dchat.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.com.dchat.R;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    private EditText usernametext;
    private EditText passwordtext;
    private EditText emailtext;
    private Button registerButton;
    private View progressbar;

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
        progressbar.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View v) {
        if(v == registerButton) {
            application.getAuth().getUser().setLoggedIn(true);

            setResult(RESULT_OK);
            finish();
        }
    }
}
