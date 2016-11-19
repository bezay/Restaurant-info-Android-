package com.example.bezay.easyeat;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bezay.easyeat.adapter.ListAdapter;
import com.example.bezay.easyeat.adapter.ViewPagerAdapter;
import com.example.bezay.easyeat.login.Login;
import com.example.bezay.easyeat.menu.About;
import com.example.bezay.easyeat.menu.Bakery;
import com.example.bezay.easyeat.menu.Cafe;
import com.example.bezay.easyeat.menu.FAQ;
import com.example.bezay.easyeat.menu.Restaurant;
import com.example.bezay.easyeat.menu.Terms;
import com.example.bezay.easyeat.model.Product;
import com.example.bezay.easyeat.tabs.SlidingTabLayout;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView = null;
    Toolbar toolbar = null;
    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[]={"All","New"};
    int NumofTabs = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

     /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "welcome", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        adapter = new ViewPagerAdapter(getSupportFragmentManager(),Titles,NumofTabs);

        pager =(ViewPager)findViewById(R.id.pager);
        pager.setAdapter(adapter);

        tabs = (SlidingTabLayout)findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true);

        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer(){

            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.colorblack);
            }
        });
        tabs.setViewPager(pager);

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.search_bar) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.restaurant) {
            startActivity(new Intent(getApplicationContext(),Restaurant.class));

        } else if (id == R.id.bakery) {
            startActivity(new Intent(getApplicationContext(), Bakery.class));

        } else if (id == R.id.cafe) {
            startActivity(new Intent(getApplicationContext(), Cafe.class));


        } else if (id == R.id.about) {
            startActivity(new Intent(getApplicationContext(), About.class));


        } else if (id == R.id.faq) {
            startActivity(new Intent(getApplicationContext(), FAQ.class));


        } else if (id == R.id.terms) {
            startActivity(new Intent(getApplicationContext(), Terms.class));


        } else if (id == R.id.call) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:+9779806619876"));
            startActivity(intent);


        } else if (id == R.id.login) {
            startActivity(new Intent(getApplicationContext(), Login.class));


        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }
}

