package com.example.com.dchat.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.com.dchat.infrastructure.DChatApplication;

public abstract class BaseFragment extends Fragment {
    protected DChatApplication application;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        application = (DChatApplication) getActivity().getApplication();
    }
}
