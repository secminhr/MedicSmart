package com.example.android.medicsmart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;

import static com.example.android.medicsmart.R.id.btnEmailLogin;
import static com.example.android.medicsmart.R.id.btnGoogleLogin;
import static com.example.android.medicsmart.R.id.textViewSignup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    FirebaseAuth mAuth;
    EditText editTextEmail, editTextPassword;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        findViewById(textViewSignup).setOnClickListener(this);
        findViewById(btnEmailLogin).setOnClickListener(this);
        findViewById(btnGoogleLogin).setOnClickListener(this);

    }




    @Override
    protected void onStart() {
        super.onStart();

        if (mAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(this, ProfileActivity.class));
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case textViewSignup:
                Intent signup = new Intent(this, SignUpActivity.class);
                startActivity(signup);
                break;

            case btnEmailLogin:
                Intent emailLogin = new Intent(this, EmailLoginActivity.class);
                startActivity(emailLogin);
                break;

            case btnGoogleLogin:
                Intent googleLogin = new Intent(this, GoogleLoginActivity.class);
                startActivity(googleLogin);
                break;

//            case R.id.buttonLogin:
//                userLogin();
//                break;
        }
    }
}
