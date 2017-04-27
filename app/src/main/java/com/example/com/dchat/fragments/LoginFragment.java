package com.example.com.dchat.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.com.dchat.R;

public class LoginFragment extends BaseFragment implements View.OnClickListener {
    private Button loginButton;
    private CallBacks callbacks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup root, Bundle savedState) {
        View view = inflater.inflate(R.layout.fragment_login, root, false);

        loginButton = (Button) view.findViewById(R.id.fragment_login_loginButton);
        loginButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(v == loginButton) {
            application.getAuth().getUser().setLoggedIn(true);
            /* notify parent activity */
            callbacks.onLoggedIn();
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        callbacks = (CallBacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callbacks = null;
    }

    public interface CallBacks {
        void onLoggedIn();
    }
}
