package com.example.recycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_activity.R;

import java.util.List;

public class AdapterProduct extends  RecyclerView.Adapter<RecyclerView.ViewHolder>{
    public List<InforProduct> inforProductList;
    public  AdapterProduct (List<InforProduct> list){
        this.inforProductList = list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.home_list_fragment,parent, false);
        ViewHolderHome viewHolder = new ViewHolderHome(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
