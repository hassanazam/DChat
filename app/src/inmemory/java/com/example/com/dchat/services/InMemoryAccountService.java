package com.example.com.dchat.services;

import com.example.com.dchat.infrastructure.DChatApplication;
import com.squareup.otto.Subscribe;

public class InMemoryAccountService {
    private DChatApplication application;

    public InMemoryAccountService(DChatApplication application) {
        application.getBus().register(this);
        this.application = application;
    }

    @Subscribe
    public void updateProfile(Account.UpdateProfileRequest request) {
        Account.UpdateProfileResponse response = new Account.UpdateProfileResponse();
        application.getBus().post(response);
    }
}
