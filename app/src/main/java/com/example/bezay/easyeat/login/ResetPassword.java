package com.example.bezay.easyeat.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bezay.easyeat.R;

public class ResetPassword extends AppCompatActivity {

    private EditText number;
    private Button btnsms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        number = (EditText)findViewById(R.id.contact_num);
        btnsms = (Button)findViewById(R.id.reset);

        btnsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendSms();
            }

            private void sendSms() {
                String num = number.getText().toString();
                boolean valid= true;

                if(num.equals("")){
                    number.setError("Please enter contact number");
                    valid= false;
                }
                else{
                    number.setError(null);
                }

                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(num, null, "rest of code", null, null);
                    Toast.makeText(getApplicationContext(), "SMS Sent!",
                            Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again later!",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }


            }
        });
    }
}
