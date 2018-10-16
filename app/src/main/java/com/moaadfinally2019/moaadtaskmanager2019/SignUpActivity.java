package com.moaadfinally2019.moaadtaskmanager2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {
    private FirebaseAuth auth;// to make SignIn ,SignUp
    private FirebaseUser user;//user
    private TextView tvFirst;
    private TextView tvLast;
    private EditText etPssword;
    private EditText etEmail;
    private Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();//
        etEmail = (EditText)findViewById(R.id.etEmail);
        etPssword = (EditText)findViewById(R.id.etPassword);
        btnSave = (Button) findViewById(R.id.btnSave);
        tvFirst = findViewById(R.id.tvFirst);
        tvLast = findViewById(R.id.tvLast);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
