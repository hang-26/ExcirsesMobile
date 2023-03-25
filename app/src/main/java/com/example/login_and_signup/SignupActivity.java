package com.example.login_and_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobile_activity.R;

public class SignupActivity extends AppCompatActivity {
    EditText edt_username_signup;
    EditText edt_pass_signup;
    TextView tv_cancel;
    TextView tv_signup;
    MySharePreference mySharePreference ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        intitView();
        mySharePreference = new MySharePreference(SignupActivity.this);
        addListenner();
    }

    private void intitView(){
        edt_username_signup = findViewById(R.id.edt_username_signup);
        edt_pass_signup = findViewById(R.id.edt_pass_signup);
        tv_cancel = findViewById(R.id.tv_cancel);
        tv_signup = findViewById(R.id.tv_signup);
    }

    private void addListenner(){
        tv_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String us = edt_username_signup.getText().toString();
                String pass = edt_pass_signup.getText().toString();
                mySharePreference.putStringValues(us,pass);
                Toast.makeText(SignupActivity.this, "Sign up success!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}