package com.example.bezay.easyeat.login;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bezay.easyeat.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    private EditText UserName;
    private EditText Password;
    private TextView registerlink;
    private TextView forgotPassword;

    private String username, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        UserName = (EditText) findViewById(R.id.user_name);
        Password = (EditText) findViewById(R.id.input_password);
        registerlink = (TextView) findViewById(R.id.link_signup);
        forgotPassword = (TextView) findViewById(R.id.forgot);

        registerlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ResetPassword.class));
            }
        });

    }

    public void userLogin(View view){
        username = UserName.getText().toString();
        password = Password.getText().toString();
        String method = "login";
        BackgroundTask backgroundTask  = new BackgroundTask(this);
        backgroundTask.execute(method,username,password);
    }
}

