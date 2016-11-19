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

public class Register extends AppCompatActivity {
    private EditText Email;
    private EditText Name;
    private EditText UserName;
    private EditText Password;
    private EditText Contact;
    private EditText ConPassword;
    private TextView already;
    String name,email,password,username,conpass,contact;
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        builder = new AlertDialog.Builder(Register.this);
        Email = (EditText) findViewById(R.id.input_email);
        Name = (EditText) findViewById(R.id.input_name);
        UserName = (EditText)findViewById(R.id.user_name);
        Password = (EditText) findViewById(R.id.input_password);
        ConPassword = (EditText)findViewById(R.id.confirm_password);
        Contact = (EditText) findViewById(R.id.input_phone);
        already = (TextView) findViewById(R.id.already);

        already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });

    }
    public void userReg(View view) {
        name = Name.getText().toString();
        email = Email.getText().toString();
        password = Password.getText().toString();
        username = UserName.getText().toString();
        conpass = ConPassword.getText().toString();
        contact = Contact.getText().toString();


        if(name.isEmpty()||email.isEmpty()||username.isEmpty()||password.isEmpty()||contact.isEmpty()){
            builder.setTitle("Registration failed");
            builder.setMessage("please fill all the fields");
            builder.show();
        }

            else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            builder.setTitle("Registration failed");
            builder.setMessage("Enter valid email address");
            builder.show();

            }

           else if (!(password.equals(conpass))) {
            builder.setTitle("Registration failed");
            builder.setMessage("password didn't match");
            builder.show();

            }
            else {
            String method = "register";
            BackgroundTask backgroundTask = new BackgroundTask(this);
            backgroundTask.execute(method, name, email, password, username, contact);
            finish();
        }

    }
}
