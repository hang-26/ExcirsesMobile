package com.example.login_and_signup.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobile_activity.R;
import com.example.recycleview.AdapterProduct;
import com.example.romdatabase.Product;
import com.example.romdatabase.ProductDao;
import com.example.romdatabase.ProductDao_Impl;
import com.example.romdatabase.ProductDatabase;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    RecyclerView home_recyclerview;
    AdapterProduct adapterProduct;
    ProductDatabase productDatabase;
    List<Product> productList ;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        productDatabase = Room.databaseBuilder(getContext(),ProductDatabase.class,"data product").allowMainThreadQueries().build();
        ProductDao productDao = productDatabase.productDao();
        productList = productDao.getAll();
        setProduct();
    }

    private void initView(View view){
        home_recyclerview = view.findViewById(R.id.home_recyclerview);
    }

    public void setProduct(){
        adapterProduct = new AdapterProduct(productList);
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(getContext(),2);
        home_recyclerview.setAdapter(adapterProduct);
        home_recyclerview.setLayoutManager(linearLayoutManager);
    }
}