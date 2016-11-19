package com.example.bezay.easyeat.menu;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.bezay.easyeat.R;
import com.example.bezay.easyeat.adapter.ListAdapter;
import com.example.bezay.easyeat.model.Product;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class Cafe extends AppCompatActivity {
    private ListView listView;
    private ListAdapter listAdapter;
    private List<Product> mProductList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe);
        listView = (ListView)findViewById(R.id.cafe_list);


    }
}
