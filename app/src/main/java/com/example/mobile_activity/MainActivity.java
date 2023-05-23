package com.example.mobile_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.room.Room;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.inventory.InventoryActivity;
import com.example.login_and_signup.fragment.AdapterViewPager;
import com.example.login_and_signup.fragment.FolderFragment;
import com.example.login_and_signup.fragment.HomeFragment;
import com.example.login_and_signup.fragment.MapFragment;
import com.example.romdatabase.Product;
import com.example.romdatabase.ProductDao;
import com.example.romdatabase.ProductDatabase;
import com.example.store.StoreActivity;

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
    ImageView ic_imvStore;
    ImageView imv_icG;
    List<Fragment> fragmentList = new ArrayList<>();
    ProductDatabase productDatabase;
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

        //RomData
        productDatabase = Room.databaseBuilder(getApplicationContext(),ProductDatabase.class,"data product").allowMainThreadQueries().build();
         ListProduct();
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
        ic_imvStore = findViewById(R.id.ic_imvStore);
        imv_icG = findViewById(R.id.imv_icG);
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

        ic_imvStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StoreActivity.class);
                startActivity(intent);
            }
        });

        ic_imvStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, StoreActivity.class);
                startActivity(myIntent);
            }
        });

        imv_icG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentView = new Intent(MainActivity.this, InventoryActivity.class);
                startActivity(intentView);
            }
        });
    }


    public void ListProduct(){
        ProductDao productDao = productDatabase.productDao();
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1,"Nước hoa hồng cân bằng da Simple",160000,"https://product.hstatic.net/200000617989/product/new_6ffe966fb0f1422495afa66aab268c20_large.png",2000,"Chăm sóc da"));
        productList.add(new Product(2,"Nước hoa hồng cân bằng da Klais",360000,"https://product.hstatic.net/200000617989/product/hinh_2_6c46206a40ff419c87780ceb4dfb75a6_grande.png",2000,"Chăm sóc da"));
        productList.add(new Product(3,"Nước Tẩy Trang L'Oréal Paris 3 In 1 Micellar Water Làm Tươi Mát Da 400Ml",159000,"https://product.hstatic.net/200000061028/product/thumnail_midmonth_2_64cf410e69f946b687b4055b1572a88d_grande.jpg",3000,"Trang điểm"));
        productList.add(new Product(4,"Nước Tẩy Trang Dành Cho Da Nhạy Cảm Bioderma Sensibio H2O 500Mll",429000,"https://product.hstatic.net/200000061028/product/thumnail_midmonth_3017868_12704da8c64141f1bde1d8ba1c792421_grande.jpg",3000,"Trang điểm"));
        productList.add(new Product(5,"Sữa Chống Nắng Dưỡng Da Kiềm Dầu Bảo Vệ Hoàn Hảo Anessa Perfect UV Sunscreen Skincare Milk SPF50+ PA++++ 60Ml",699000,"https://product.hstatic.net/200000061028/product/p64_thumb_3025301_c5772214757d48faad9360658118aba3_grande.jpg",3000,"Chăm sóc da"));
        productList.add(new Product(6,"Serum L'Oreal Paris Glycolic Bright sáng da tức thì 1.0% Glycolic Acid 30ml",309000,"https://product.hstatic.net/200000061028/product/thumnail_midmonth_3025119_66b00fd3e55649ccb35dcf6bf9ff1229_grande.jpg",3000,"Chăm sóc da"));
        productList.add(new Product(7,"Sữa Rửa Mặt CeraVe Foaming Cleanser Sạch Sâu Cho Da Thường Đến Da Dầu 236Ml",239000,"https://product.hstatic.net/200000061028/product/thumnail_midmonth_3026448_661e7a581c6245cc9d57fccda7b197ab_grande.jpg",3000,"Chăm sóc da"));
        productList.add(new Product(8,"Gel Rửa Mặt Low PH Good Morning Gel Cleanser COSRX 150Ml",159000,"https://product.hstatic.net/200000061028/product/thumbnail_1080-x-1080_3_79d5f566051c4521ba9be6304b5774f9_grande.jpg",3000,"Chăm sóc da"));
        productList.add(new Product(9,"Sữa Tắm Lux Botanicals Lan Tiên & Tràm Trà 570G",189000,"https://product.hstatic.net/200000061028/product/8934868173229_7547cee7da1d4eb9a5f6ab04630f4bb8_1024x1024.png",3000,"Chăm sóc body"));
        productList.add(new Product(10,"Sữa Tắm Hoa Sen Tesori d`Oriente 500Ml",229000,"https://product.hstatic.net/200000061028/product/3022861-1_d8a742a4ba29441383c6efdff2b4dac2_1024x1024.jpg",3000,"Chăm sóc body"));
        productList.add(new Product(11,"Dầu Gội TSUBAKI Phục Hồi Giảm Xơ Rối Ngăn Rụng Tóc 490ML",309000,"https://product.hstatic.net/200000061028/product/3021581-1_e33c0a1928d446d88bccb924d213fa15_grande.jpg",3000,"Chăm sóc tóc"));
        productList.add(new Product(12,"Dầu Gội Pantene Chăm Sóc Tóc Phục Hồi Hư Tổn 650ML",269000,"https://product.hstatic.net/200000061028/product/slide1_9f4f1ac74cda4575aedf6e8e1f4fb221_1024x1024.png",3000,"Chăm sóc tóc"));
        productList.add(new Product(13,"Sữa Dưỡng Thể Sáng Da Chuyên Sâu Vaseline Healthy Bright Gluta-Hya Dewy Radiance 330Ml",159000,"https://product.hstatic.net/200000061028/product/9556126670661_44df3a2c0b2d4c379b219a6ee7c960b1_grande.png",3000,"Chăm sóc cá nhân"));
        productList.add(new Product(14,"Kem Dưỡng Lotus Hoa Sen Tesori d'Oriente 300Ml",150000,"https://product.hstatic.net/200000061028/product/3023947-1_ed71db34878f4ef5812a9e0e1707fbfb_1024x1024.jpg",3000,"Chăm sóc cá nhân"));
        productList.add(new Product(15,"Sữa Dưỡng Thể Trắng Da Vaseline Nâng Tông Tức Thì Gấp 4 Lần Gluta-Hya Niacinamide Tone-up 300Ml",119000,"https://product.hstatic.net/200000061028/product/8851932439923__1__987a7e371e73486ca560d84da4279bc7_grande.png",3000,"Chăm sóc cá nhân"));
        productList.add(new Product(16,"Tẩy Tế Bào Chết Môi Cocoon Dak Lak Coffee Cà Phê Đắk Lắk 5Gr",79000,"https://product.hstatic.net/200000061028/product/3023696-4_732f10ba2d194009af03c40fd983277a_grande.jpg",3000,"Chăm sóc môi"));
        productList.add(new Product(17,"Son Dưỡng Mediheal Labocare Pantenolips Healbalm Hỗ Trợ Giảm Thâm Môi Dùng Ban Ngày 10ml",59000,"https://product.hstatic.net/200000061028/product/3023615-1_78237d668eaa435d9c85fa9bf36d8d89_grande.jpg",3000,"Chăm sóc môi"));
        productList.add(new Product(18,"Mặt Nạ Ngủ Môi Care:Nel Berry Lip Night Mask Hương Dâu 5Gr",89000,"https://product.hstatic.net/200000061028/product/3022766-_2__144d71f5c6d64219811594f5a15dc890_grande.jpg",3000,"Chăm sóc môi"));
        productDao.insertAll(productList);
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