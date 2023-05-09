package com.example.inventory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;

import com.example.mobile_activity.R;
import com.example.recycleview.AdapterInventory;
import com.example.recycleview.AdapterProduct;
import com.example.romdatabase.Product;
import com.example.romdatabase.ProductDao;
import com.example.romdatabase.ProductDatabase;
import com.example.romdatabase.Store;
import com.example.romdatabase.StoreDao;
import com.example.romdatabase.StoreDatabase;
import com.example.store.StoreActivity;

import java.util.List;

public class InventoryActivity extends AppCompatActivity {
    RecyclerView inventory_recycleview;
    AdapterInventory adapterInventory;
    ProductDatabase productDatabase;
    List<Product> productList ;
    ProductDao productDao;
    Store store;
    StoreDao storeDao;
    StoreDatabase storeDatabase;
    List<Store> listStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
        initView();
        productDatabase = Room.databaseBuilder(InventoryActivity.this,ProductDatabase.class,"data product").allowMainThreadQueries().build();
        productDao = productDatabase.productDao();
        storeDatabase = Room.databaseBuilder(InventoryActivity.this, StoreDatabase.class,"data store").allowMainThreadQueries().build();
        storeDao = storeDatabase.storeDao();
        productList = productDao.getAll();
        listStore= storeDao.getAll();
        for(Product product: productList){
            int id = product.uid;
            store = storeDao.loadSingle(id);
            product.store = store;
        }
        adapterInventory = new AdapterInventory(productList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(InventoryActivity.this);
        inventory_recycleview.setAdapter(adapterInventory);
        inventory_recycleview.setLayoutManager(linearLayoutManager);
    }

    private void initView(){
        inventory_recycleview = findViewById(R.id.inventory_recycleview);
    }
    /*public void setProduct(){
        adapterInventory = new AdapterInventory(productList);
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(InventoryActivity.this,1);
        inventory_recycleview.setAdapter(adapterInventory);
        inventory_recycleview.setLayoutManager(linearLayoutManager);
    }*/
}