package com.example.com.dchat.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.com.dchat.R;

public class LoginFragment extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup root, Bundle savedState) {
        View view = inflater.inflate(R.layout.fragment_login, root, false);

        return view;
    }
}
