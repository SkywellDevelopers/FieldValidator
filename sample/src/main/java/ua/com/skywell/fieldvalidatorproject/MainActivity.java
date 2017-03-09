package ua.com.skywell.fieldvalidatorproject;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ua.com.skywell.fieldvalidator.FieldValidator;
import ua.com.skywell.fieldvalidator.StringUtils;
import ua.com.skywell.fieldvalidatorproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    protected ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        binding.validateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.nameEt.getText().toString();
                String surname = binding.surnameEt.getText().toString();
                String credentials = binding.credentialsEt.getText().toString();
                String userName = binding.usernameEt.getText().toString();
                String email = binding.emailEt.getText().toString();
                String phoneNumber = binding.phoneNumberEt.getText().toString();
                String creditCard = binding.creditCardEt.getText().toString();
                String password = binding.passwordEt.getText().toString();

                if (!FieldValidator.isNameValidEager(name)) {
                    binding.nameTil.setError(getString(R.string.name_validation_error));
                } else {
                    binding.nameTil.setErrorEnabled(false);
                }

                if (!FieldValidator.isNameValidEager(surname)) {
                    binding.surnameTil.setError(getString(R.string.surname_validation_error));
                } else {
                    binding.surnameTil.setErrorEnabled(false);
                }

                if (!FieldValidator.isCredentialsValidEager(credentials)) {
                    binding.credentialsEt.setError(getString(R.string.credentials_validation_error));
                } else {
                    binding.credentialsTil.setErrorEnabled(false);
                }

                if (!FieldValidator.isUsernameValidEager(userName)) {
                    binding.usernameTil.setError(getString(R.string.username_validation_error));
                } else {
                    binding.usernameTil.setErrorEnabled(false);
                }

                if (!FieldValidator.isEmailValid(email)) {
                    binding.emailTil.setError(getString(R.string.email_validation_error));
                } else {
                    binding.emailTil.setErrorEnabled(false);
                }

                if (!StringUtils.isDigitsEager(phoneNumber, 9)) {
                    binding.phoneNumberTil.setError(getString(R.string.phone_number_validation_error));
                } else {
                    binding.phoneNumberTil.setErrorEnabled(false);
                }

                if (!FieldValidator.isCreditCardValidEager(creditCard)) {
                    binding.creditCardTil.setError(getString(R.string.credit_card_validation_error));
                } else {
                    binding.creditCardTil.setErrorEnabled(false);
                }

                if (!FieldValidator.isPasswordValidEager(password)) {
                    binding.passwordTil.setError(getString(R.string.password_validation_error));
                } else {
                    binding.passwordTil.setErrorEnabled(false);
                }

            }
        });
    }
}