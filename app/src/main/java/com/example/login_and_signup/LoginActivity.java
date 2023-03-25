package com.example.login_and_signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobile_activity.R;

public class LoginActivity extends AppCompatActivity {
    EditText edt_username;
    EditText edt_pass;
    TextView tv_cancel;
    TextView tv_login;
    TextView tv_notU;
    MySharePreference mySharePreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        mySharePreference = new MySharePreference(LoginActivity.this);
        addListener();
    }

    private void initView(){
        edt_username= findViewById(R.id.edt_username);
        edt_pass = findViewById(R.id.edt_pass);
        tv_cancel = findViewById(R.id.tv_cancel);
        tv_login = findViewById(R.id.tv_login);
        tv_notU = findViewById(R.id.tv_notU);
    }

    private  void addListener(){
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uName = edt_username.getText().toString();
                String passNew = edt_pass.getText().toString();
                String pass = mySharePreference.getStringValues(uName);
                if(passNew.equals(pass)){
                    Toast.makeText(LoginActivity.this,"Login Success",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(LoginActivity.this, "UserName or Pass incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });

        tv_notU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }
}