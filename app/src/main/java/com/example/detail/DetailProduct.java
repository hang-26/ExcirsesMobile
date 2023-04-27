package com.example.detail;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mobile_activity.R;
import com.example.recycleview.Adapter_Store;
import com.example.romdatabase.Product;
import com.example.romdatabase.ProductDao;
import com.example.romdatabase.ProductDatabase;
import com.example.romdatabase.Store;
import com.example.romdatabase.StoreDao;
import com.example.romdatabase.StoreDatabase;
import com.example.store.StoreActivity;

import java.util.ArrayList;
import java.util.List;

import kotlin.jvm.Throws;

public class DetailProduct extends AppCompatActivity {
    ImageView imv_view_product;
    TextView tv_name_Folder;
    TextView tv_nameP;
    TextView tv_numP;
    TextView id_product;
    TextView tv_priceP;
    TextView btn_priceP;
    ProductDatabase productDatabase;
    ProductDao productDao;
    Product product;
    StoreDatabase storeDatabase;
    StoreDao storeDao;
    Store store;
    List<Store> storeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);
        intitView();
        productDatabase = Room.databaseBuilder(DetailProduct.this,ProductDatabase.class,"data product").allowMainThreadQueries().build();
        productDao = productDatabase.productDao();
        setUpdetail();
        addListener();
        storeDatabase = Room.databaseBuilder(DetailProduct.this,StoreDatabase.class,"data store").allowMainThreadQueries().build();
        storeDao = storeDatabase.storeDao();
        storeList = storeDao.getAll();
    }

    public void intitView(){
        imv_view_product = findViewById(R.id.imv_view_product);
        tv_name_Folder = findViewById(R.id.tv_name_Folder);
        tv_nameP = findViewById(R.id.tv_nameP);
        tv_numP = findViewById(R.id.tv_numP);
        id_product = findViewById(R.id.id_product);
        tv_priceP = findViewById(R.id.tv_priceP);
        btn_priceP = findViewById(R.id.btn_priceP);
    }

    public void setUpdetail(){
        Intent intent = getIntent();
        int idValue = intent.getIntExtra("uid",-1 );
        product = productDao.loadSingle(idValue);
        tv_nameP.setText(product.nameProduct);
        tv_name_Folder.setText(product.storeProduct);
        tv_numP.setText(Integer.toString(product.numProduct));
        tv_priceP.setText(Double.toString(product.priceProduct));
        id_product.setText(Integer.toString(product.uid));
        Glide.with(imv_view_product.getContext()).load(product.ui_image).into(imv_view_product);
    }

    private void addListener(){
        btn_priceP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                int idValue = intent.getIntExtra("uid",-1 );
                Intent myIntent = new Intent(DetailProduct.this, StoreActivity.class);
                myIntent.putExtra("uid",idValue);
                startActivity(myIntent);


                try {
                    store = new Store(idValue,1);
                    storeDao.insert(store);
                    Toast.makeText(DetailProduct.this,"Success",Toast.LENGTH_SHORT).show();
                }catch (Exception exception){
                    throw exception;
                }


            }
        });
    }
}