package com.example.store;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.mobile_activity.R;

public class StoreActivity extends AppCompatActivity {
    RecyclerView rcv_store;
    ImageView imv_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        initView();
        addListener();
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
}