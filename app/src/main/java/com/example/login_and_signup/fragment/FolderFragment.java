package com.example.login_and_signup.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobile_activity.R;
import com.example.recycleview.AdapterFolder;
import com.example.recycleview.AdapterProduct;
import com.example.recycleview.MyFolder;

import java.util.ArrayList;
import java.util.List;


public class FolderFragment extends Fragment {
    RecyclerView folder_recyclerview;
    AdapterFolder adapterFolder ;
    List<MyFolder> myFolderList = new ArrayList<>() ;
    public FolderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_folder, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        setProduct();
    }
    private void  initView(View view){
        folder_recyclerview = view.findViewById(R.id.folder_recyclerview);
    }

    public void setProduct(){
        adapterFolder = new AdapterFolder(myFolderList);
        myFolderList.add(new MyFolder("Chăm sóc da","https://24hlamdep.com/wp-content/uploads/2021/08/Cac-buoc-cham-soc-da-hang-ngay-1L.jpg"));
        myFolderList.add(new MyFolder("Trang điểm","https://24hlamdep.com/wp-content/uploads/2021/08/Cac-buoc-cham-soc-da-hang-ngay-1L.jpg"));
        myFolderList.add(new MyFolder("Chăm sóc tóc","https://24hlamdep.com/wp-content/uploads/2021/08/Cac-buoc-cham-soc-da-hang-ngay-1L.jpg"));
        myFolderList.add(new MyFolder("Chăm sóc môi","https://24hlamdep.com/wp-content/uploads/2021/08/Cac-buoc-cham-soc-da-hang-ngay-1L.jpg"));
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(getContext(),3);
        folder_recyclerview.setAdapter(adapterFolder);
        folder_recyclerview.setLayoutManager(linearLayoutManager);
    }
}