package com.example.com.dchat.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.com.dchat.R;
import com.example.com.dchat.services.Account;
import com.squareup.otto.Subscribe;

public class ChangePasswordDialog extends BaseDialogFragment implements View.OnClickListener {

    private EditText currentPassword;
    private EditText newPassword;
    private EditText confirmNewPassword;

    private AlertDialog progressDialog;

    @Override
    public Dialog onCreateDialog(Bundle savedState) {
        View dialogView = getActivity().getLayoutInflater().inflate(R.layout.dialog_change_password, null, false);

        currentPassword = (EditText) dialogView.findViewById(R.id.dialog_change_password_currentPassword);
        newPassword = (EditText) dialogView.findViewById(R.id.dialog_change_password_newPassword);
        confirmNewPassword = (EditText) dialogView.findViewById(R.id.dialog_change_password_confirmNewPassword);

        if(!application.getAuth().getUser().isHasPassword())
            currentPassword.setVisibility(View.GONE);


        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setView(dialogView)
                .setPositiveButton("Update", null)
                .setNegativeButton("Cancel", null)
                .setTitle("Change Password")
                .show();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(this);

        return dialog;
    }

    @Override
    public void onClick(View v) {

        progressDialog = new ProgressDialog.Builder(getActivity())
                .setTitle("Changing Password")
                .setCancelable(false)
                .show();

        bus.post(new Account.ChangePasswordRequest(
                currentPassword.getText().toString(),
                newPassword.getText().toString(),
                confirmNewPassword.getText().toString()));

    }

    @Subscribe
    public void passwordChanged(Account.ChangePasswordResponse response) {

        progressDialog.dismiss();
        progressDialog = null;

        if( response.didSucceed()) {
            Toast.makeText(getActivity(), "Password Updated", Toast.LENGTH_LONG).show();
            dismiss();

            application.getAuth().getUser().setHasPassword(true);
            return;
        }


        currentPassword.setError(response.getPropertyError("currentPassword"));
        newPassword.setError(response.getPropertyError("newPassword"));
        confirmNewPassword.setError(response.getPropertyError("confirmNewPassword"));

        response.showErrorToast(getActivity());
    }
}
