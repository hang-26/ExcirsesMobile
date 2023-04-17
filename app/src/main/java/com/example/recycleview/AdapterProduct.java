package com.example.recycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mobile_activity.R;
import com.example.romdatabase.Product;

import java.util.List;

public class AdapterProduct extends  RecyclerView.Adapter<RecyclerView.ViewHolder>{
    public List<Product> products;
    public  AdapterProduct (List<Product> list){
        this.products = list;
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
        if(holder instanceof  ViewHolderHome){
            ViewHolderHome viewHolderHome = (ViewHolderHome) holder;
            Product listP = products.get(position);
            viewHolderHome.nameP.setText(listP.nameProduct);
            viewHolderHome.priceP.setText(String.valueOf(listP.priceProduct));
            //set image
           // Glide.with(listP.viewP.getContext()).load(unEscapeLink).into(listP.viewP);
            Glide.with(viewHolderHome.viewP.getContext()).load(listP.ui_image).into(viewHolderHome.viewP);

        }

    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
