package com.example.com.dchat.services;

import android.net.Uri;

import com.example.com.dchat.infrastructure.ServiceResponse;
import com.example.com.dchat.infrastructure.User;

public final class Account {

    private Account() {

    }

    public static class UserResponse extends ServiceResponse {
        public int Id;
        public String avatarUrl;
        public String DisplayName;
        public String UserName;
        public String Email;
        public String AuthToken;
        public boolean HasPassword;
    }

    public static class LoginWithUsernameRequest {
        public String Username;
        public String Password;

        public LoginWithUsernameRequest(String username, String password) {
            Username = username;
            Password = password;
        }
    }

    public static class LoginWithUsernameResponse extends UserResponse {

    }

    public static class LoginWithLocalTokenRequest {
        public String AuthToken;

        public LoginWithLocalTokenRequest(String authToken) {
            AuthToken = authToken;
        }
    }

    public static class LoginWithLocalTokenResponse extends UserResponse {

    }

    public static class LoginWithExternalTokenRequest {
        public String provider;
        public String Token;
        public String ClientId;

        public LoginWithExternalTokenRequest(String provider, String token, String clientId) {
            this.provider = provider;
            Token = token;
            ClientId = "android";
        }
    }

    public static class LoginWithExternalTokenResponse extends UserResponse {

    }

    public static class RegisterRequest {
        public String UserName;
        public String Email;
        public String Password;
        public String ClientId;

        public RegisterRequest(String userName, String email, String password) {
            UserName = userName;
            Email = email;
            Password = password;
            this.ClientId = "android";
        }
    }

    public static class RegisterResponse extends UserResponse {

    }

    public static class RegisterWithExternalTokenRequest {
        public String Username;
        public String Email;
        public String Provider;
        public String ClientId;
        public String Token;

        public RegisterWithExternalTokenRequest(String username, String email, String provider, String clientId, String token) {
            Username = username;
            Email = email;
            Provider = provider;
            ClientId = "android";
            Token = token;
        }
    }

    public static class RegisterWIthExternalTokenResponse extends UserResponse {

    }

    public static class ChangeAvatarRequest {
        public Uri NewAvatarUri;

        public ChangeAvatarRequest(Uri newAvatarUri) {
            NewAvatarUri = newAvatarUri;
        }
    }

    public static class ChangeAvatarResponse extends ServiceResponse {

    }

    public static class UpdateProfileRequest {
        public String DisplayName;
        public String Email;

        public UpdateProfileRequest(String displayName, String email) {
            DisplayName = displayName;
            Email = email;
        }
    }

    public static class UpdateProfileResponse extends ServiceResponse {

    }

    public static class ChangePasswordRequest {
        public String CurrentPassword;
        public String NewPassword;
        public String ConfirmNewPassword;

        public ChangePasswordRequest(String currentPassword, String newPassword, String confirmNewPassword) {
            CurrentPassword = currentPassword;
            NewPassword = newPassword;
            ConfirmNewPassword = confirmNewPassword;
        }
    }

    public static class ChangePasswordResponse extends ServiceResponse {

    }

    public static class UserDetailsUpdatedEvent {
        public User user;

        public UserDetailsUpdatedEvent(User user) {
            this.user = user;
        }
    }
}
