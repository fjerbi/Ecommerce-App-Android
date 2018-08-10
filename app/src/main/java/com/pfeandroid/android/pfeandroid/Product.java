package com.pfeandroid.android.pfeandroid;


import java.io.Serializable;

public class Product implements Serializable {
    public int id;
    public String nom_produit;
    public int quantite_produit;
    public double prix_produit;
    public String image_produit;
    public String description_produit;
    public int user_id;

}
