package com.example.bezay.easyeat.menu;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bezay.easyeat.R;

public class Terms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);

        ActionBar ab = getSupportActionBar();
        ab.setTitle("Terms And Conditions");
    }
}
