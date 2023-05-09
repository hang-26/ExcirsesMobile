package com.example.romdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import java.util.List;

@Entity
public  class Product {
    public Product(){}
    public Product(int id, String nameProduct, double priceProduct, String ui_image, int numProduct, String storeProduct) {
        this.uid = id;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.ui_image = ui_image;
        this.numProduct = numProduct;
        this.storeProduct = storeProduct;
    }

    @PrimaryKey()
    public int uid;

    @ColumnInfo(name = "name_product")
    public String nameProduct;

    @ColumnInfo(name = "price_product")
    public double priceProduct;

    @ColumnInfo(name = "ui_image")
    public String ui_image;

    @ColumnInfo(name ="num")
    public int numProduct;

    @ColumnInfo(name="store")
    public String storeProduct;

    @Ignore
    public Store store;
}
