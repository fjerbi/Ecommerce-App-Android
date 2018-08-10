package com.pfeandroid.android.pfeandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class HomeNav extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_nav);

        LinearLayout cnx= (LinearLayout) findViewById(R.id.cnx);
        LinearLayout map= (LinearLayout) findViewById(R.id.map);
        LinearLayout shop= (LinearLayout) findViewById(R.id.shop);
        LinearLayout desc= (LinearLayout) findViewById(R.id.desc);
        LinearLayout fb_login= (LinearLayout) findViewById(R.id.fb_login);


        fb_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeNav.this, FacebookActivity.class));
            }
        });
        cnx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeNav.this, LoginActivity.class));
            }
        });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeNav.this, MapsActivity.class));
            }
        });
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeNav.this, MainActivity.class));
            }
        });

        desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeNav.this, SliderActivity.class));
            }
        });

    }
}
