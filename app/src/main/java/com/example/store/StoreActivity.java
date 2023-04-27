package com.example.store;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.detail.DetailProduct;
import com.example.mobile_activity.R;
import com.example.recycleview.AdapterProduct;
import com.example.recycleview.Adapter_Store;
import com.example.romdatabase.Product;
import com.example.romdatabase.ProductDao;
import com.example.romdatabase.ProductDatabase;
import com.example.romdatabase.Store;
import com.example.romdatabase.StoreDao;
import com.example.romdatabase.StoreDatabase;

import java.util.ArrayList;
import java.util.List;

public class StoreActivity extends AppCompatActivity {
    RecyclerView rcv_store;
    ImageView imv_back;
    ProductDatabase productDatabase;
    ProductDao productDao;
    StoreDatabase storeDatabase;
    StoreDao storeDao;
    List<Store> listStore;
    Product product;

    Adapter_Store adapter_store;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        initView();
        productDatabase = Room.databaseBuilder(StoreActivity.this,ProductDatabase.class,"data product").allowMainThreadQueries().build();
        productDao = productDatabase.productDao();
        storeDatabase = Room.databaseBuilder(StoreActivity.this,StoreDatabase.class,"data store").allowMainThreadQueries().build();
        storeDao = storeDatabase.storeDao();
        listStore = storeDao.getAll();
        for(Store store: listStore){
            int id = store.uid;
            product = productDao.loadSingle(id);
            store.product = product;
        }
        addListener();
        setUpStore();
    }

    private void initView(){
        rcv_store = findViewById(R.id.rcv_store);
        imv_back = findViewById(R.id.imv_back);
    }

    private void addListener(){
        imv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void setUpStore(){
        adapter_store = new Adapter_Store(listStore, storeDao);
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(StoreActivity.this,1);
        rcv_store.setAdapter(adapter_store);
        rcv_store.setLayoutManager(linearLayoutManager);
    }


}