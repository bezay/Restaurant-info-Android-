package com.example.bezay.easyeat;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RestaurantDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);
        creatAndAddFragment();
    }

    private void creatAndAddFragment(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        RestaurantViewFragment restaurantViewFragment = new RestaurantViewFragment();
        fragmentTransaction.add(R.id.restaurant_container,restaurantViewFragment, "RESTAURANT_VIEW_FRAGMENT");
        fragmentTransaction.commit();
    }
}
