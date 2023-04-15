package com.example.mobile_activity;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.login_and_signup.fragment.AdapterViewPager;
import com.example.login_and_signup.fragment.FolderFragment;
import com.example.login_and_signup.fragment.HomeFragment;
import com.example.login_and_signup.fragment.MapFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager2 vw_main;
    LinearLayout linear_home_tab;
    LinearLayout linear_folder_tap;
    LinearLayout linear_map;
    TextView tv_home;
    TextView tv_folder;
    TextView tv_map;
    ImageView imv_home;
    ImageView imv_folder;
    ImageView imv_map;
    List<Fragment> fragmentList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        addListener();
        //list fragment
        HomeFragment homeFragment = new HomeFragment();
        FolderFragment folderFragment = new FolderFragment();
        MapFragment mapFragment = new MapFragment();
        fragmentList.add(homeFragment);
        fragmentList.add(folderFragment);
        fragmentList.add(mapFragment);
        //set Viewpager2
        AdapterViewPager adapterViewPager = new AdapterViewPager(getSupportFragmentManager(),getLifecycle(),fragmentList);
        vw_main.setAdapter(adapterViewPager);

    }

    private void initView(){
        vw_main = findViewById(R.id.vw_main);
        linear_home_tab = findViewById(R.id.linear_home_tab);
        linear_folder_tap = findViewById(R.id.linear_folder_tap);
        linear_map = findViewById(R.id.linear_map);
        tv_home = findViewById(R.id.tv_home);
        tv_folder = findViewById(R.id.tv_folder);
        tv_map = findViewById(R.id.tv_map);
        imv_home =findViewById(R.id.imv_home);
        imv_folder = findViewById(R.id.imv_folder);
        imv_map = findViewById(R.id.imv_map);
    }

    private void addListener(){
        linear_home_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vw_main.setCurrentItem(0);
                imv_home.setImageResource(R.drawable.home_click);
                imv_folder.setImageResource(R.drawable.ic_folder);
                imv_map.setImageResource(R.drawable.ic_map);
                tv_home.setTextColor(Color.parseColor("#E8830E"));
                tv_folder.setTextColor(Color.parseColor("#FF000000"));
                tv_map.setTextColor(Color.parseColor("#FF000000"));
            }
        });

        linear_folder_tap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vw_main.setCurrentItem(1);
                imv_folder.setImageResource(R.drawable.apps_click);
                imv_home.setImageResource(R.drawable.ic_home);
                imv_map.setImageResource(R.drawable.ic_map);
                tv_folder.setTextColor(Color.parseColor("#E8830E"));
                tv_home.setTextColor(Color.parseColor("#FF000000"));
                tv_map.setTextColor(Color.parseColor("#FF000000"));
            }
        });

        linear_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vw_main.setCurrentItem(2);
                imv_map.setImageResource(R.drawable.pin);
                imv_folder.setImageResource(R.drawable.ic_folder);
                imv_home.setImageResource(R.drawable.ic_home);
                tv_map.setTextColor(Color.parseColor("#E8830E"));
                tv_home.setTextColor(Color.parseColor("#FF000000"));
                tv_folder.setTextColor(Color.parseColor("#FF000000"));

            }
        });
    }

    /*private void checkPermissionStorage(){
        if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            Log.v(TAG,"Permission is granted");
            //File write logic here
        }else {
            Log.v(TAG,"Permission is revoked");
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
    }*/
}