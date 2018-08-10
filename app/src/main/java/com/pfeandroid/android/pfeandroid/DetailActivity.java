package com.pfeandroid.android.pfeandroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
ImageView image_produit;
TextView nom_produit, prix_produit,description_produit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    image_produit =(ImageView)findViewById(R.id.image_produit);
        nom_produit = (TextView) findViewById(R.id.nom_produit);
        prix_produit =(TextView) findViewById(R.id.prix_produit);
        description_produit =(TextView) findViewById(R.id.description_produit);


        if(getIntent().getSerializableExtra("product") != null){
        Product product = (Product) getIntent().getSerializableExtra("product");

            String fullUrl = "http://firasjerbi.000webhostapp.com/hd_pics/" + product.image_produit;


            Picasso.with(this)
                    .load(fullUrl)
                    .placeholder(R.drawable.pp)
                    .error(android.R.drawable.stat_notify_error)
                    .into(image_produit);

            nom_produit.setText(product.nom_produit);
            prix_produit.setText(product.prix_produit +"TND");
            nom_produit.setText(product.description_produit);
    }

    }

}
