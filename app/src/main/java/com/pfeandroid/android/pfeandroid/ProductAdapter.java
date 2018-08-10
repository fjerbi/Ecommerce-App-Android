package com.pfeandroid.android.pfeandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context context;
    private ArrayList<Product> products;

    public ProductAdapter(Context context, ArrayList<Product> products){
        this.context = context;
        this.products = products;
    }
View view;
    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
         view = inflater.from(parent.getContext())
                .inflate(R.layout.product_cardview_layout, parent, false);

        ProductViewHolder productViewHolder = new ProductViewHolder(view);
        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        final Product selectedProduct = products.get(position);
        holder.nom_produit.setText(selectedProduct.nom_produit);
        holder.prix_produit.setText(selectedProduct.prix_produit +"TND");

        String fullUrl = "https://firasjerbi.000webhostapp.com/hd_pics/" + selectedProduct.image_produit;

        Picasso.with(context)
                .load(fullUrl)
                .placeholder(R.drawable.pp)
                .error(android.R.drawable.stat_notify_error)
                .into(holder.image_produit);

        holder.image_produit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(context, DetailActivity.class);
                in.putExtra("product", selectedProduct);
in.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(in);
                Toast.makeText(context, selectedProduct.nom_produit, Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        if(products != null){
            return products.size();
        }
        return 0;
    }


    //ViewHolder class
    public static class ProductViewHolder extends RecyclerView.ViewHolder{

        public CardView cvProduct;
        public ImageView image_produit;
        public TextView nom_produit;
        public TextView prix_produit;

        public ProductViewHolder(View itemView) {
            super(itemView);
            cvProduct = (CardView)itemView.findViewById(R.id.cvProduct);
            image_produit = (ImageView)itemView.findViewById(R.id.image_produit);
            nom_produit = (TextView)itemView.findViewById(R.id.nom_produit);
            prix_produit = (TextView)itemView.findViewById(R.id.prix_produit);

        }
    }
}
