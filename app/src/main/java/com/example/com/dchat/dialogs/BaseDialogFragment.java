package com.example.com.dchat.dialogs;

import android.app.DialogFragment;
import android.os.Bundle;

import com.example.com.dchat.infrastructure.DChatApplication;
import com.squareup.otto.Bus;


public class BaseDialogFragment extends DialogFragment {
    protected DChatApplication application;
    protected Bus bus;

    @Override
    public void onCreate (Bundle savedState) {
        super.onCreate(savedState);
        application = (DChatApplication) getActivity().getApplication();
        bus = application.getBus();

        bus.register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }
}
