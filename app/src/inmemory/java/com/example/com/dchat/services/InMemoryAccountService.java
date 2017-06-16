package com.example.com.dchat.services;

import com.example.com.dchat.infrastructure.DChatApplication;
import com.squareup.otto.Subscribe;

public class InMemoryAccountService extends BaseInMemoryService {
    private DChatApplication application;

    public InMemoryAccountService(DChatApplication application) {
        super(application);
    }

    @Subscribe
    public void updateProfile(Account.UpdateProfileRequest request) {
        Account.UpdateProfileResponse response = new Account.UpdateProfileResponse();

        if(request.DisplayName.equals("Hassan")) {
            response.setPropertyError("displayName", "checking inmem error detection");
        }

        postDelayed(response, 4000);
    }

    @Subscribe
    public void updateAvatar(Account.ChangeAvatarRequest request) {
        postDelayed(new Account.ChangeAvatarResponse());
    }

    @Subscribe
    public void changePassword(Account.ChangePasswordRequest request) {
        Account.ChangePasswordResponse response = new Account.ChangePasswordResponse();

        if(!request.NewPassword.equals(request.ConfirmNewPassword)) {
            response.setPropertyError("confirmNewPassword", "Password must match");
        }

        if(request.NewPassword.length() < 3) {
            response.setPropertyError("newPassword", "Password must be larger than 3 characters!");
        }

        postDelayed(response);
    }
}
