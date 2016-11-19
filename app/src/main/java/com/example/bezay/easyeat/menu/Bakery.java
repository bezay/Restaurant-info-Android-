package com.example.bezay.easyeat.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.bezay.easyeat.R;
import com.example.bezay.easyeat.adapter.ListAdapter;
import com.example.bezay.easyeat.model.Product;

import java.util.List;

public class Bakery extends AppCompatActivity {

    private ListView listView;
    private ListAdapter listAdapter;
    private List<Product> mProductList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bakery);

    }
}
