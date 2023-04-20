package com.example.login_and_signup.fragment;

import android.content.Intent;
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
import android.widget.ImageView;

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
        myFolderList.add(new MyFolder("Chăm sóc da","https://file.hstatic.net/200000376267/file/skincare_khoa_hoc_la_gi_7d6db0371d584bff81cdb9ff01e5c175_grande.jpg"));
        myFolderList.add(new MyFolder("Trang điểm","https://images.ctfassets.net/szez98lehkfm/7JGC5JhPfA2iP9k1lOyp0d/8a737d72724dc458ac62410ef9f2d294/MyIC_Article_95801?fm=webp"));
        myFolderList.add(new MyFolder("Chăm sóc tóc","https://media.istockphoto.com/id/1198885908/vi/vec-to/ng%C6%B0%E1%BB%9Di-ph%E1%BB%A5-n%E1%BB%AF-ho%E1%BA%A1t-h%C3%ACnh-g%E1%BB%99i-%C4%91%E1%BA%A7u-b%E1%BA%B1ng-d%E1%BA%A7u-g%E1%BB%99i-%C4%91%E1%BA%A7u-h%C3%ACnh-minh-h%E1%BB%8Da-vect%C6%A1-ph%E1%BA%B3ng-b%E1%BB%8B-c%C3%B4-l%E1%BA%ADp.jpg?s=1024x1024&w=is&k=20&c=sksPLAg3OH59Hl4_llBrxPTuF0ZYHZVlWwHKJC0_V3o="));
        myFolderList.add(new MyFolder("Chăm sóc môi","https://salt.tikicdn.com/cache/w1200/ts/product/32/37/72/b32bfa4e1d5b13408b82560556184641.jpg"));
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(getContext(),3);
        folder_recyclerview.setAdapter(adapterFolder);
        folder_recyclerview.setLayoutManager(linearLayoutManager);
    }
}