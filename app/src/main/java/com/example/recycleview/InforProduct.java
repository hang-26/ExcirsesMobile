package com.example.recycleview;

import android.widget.ImageView;

public class InforProduct {
    private String nameProduct;
    private double priceProduct;
    private ImageView viewProduct;
    public void setNameProduct(String name){
        this.nameProduct = name;
    }

    public InforProduct(String name, double price, ImageView view){
        this.nameProduct = name;
        this.priceProduct = price;
        this.viewProduct = view;
    }

    public String getNameProduct(){
        return nameProduct;
    }

    public double getPriceProduct(){
        return priceProduct;
    }

    public ImageView getViewProduct(){
        return viewProduct;
    }
}
