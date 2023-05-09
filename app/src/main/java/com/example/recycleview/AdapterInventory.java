package com.example.recycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mobile_activity.R;
import com.example.romdatabase.Product;
import com.example.romdatabase.Store;

import java.util.List;

public class AdapterInventory extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<Product> products;
    public  AdapterInventory (List<Product> list){
        this.products = list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.num_inventory,parent, false);
        ViewHolderInventory viewHolderInventory = new ViewHolderInventory(view);
        return viewHolderInventory;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof  ViewHolderInventory){
            ViewHolderInventory viewHolderInventory = (ViewHolderInventory) holder;
            Product listP = products.get(position);
            viewHolderInventory.txt_productName.setText(listP.nameProduct);
            if(listP.store == null){
                viewHolderInventory.txt_num_inventory.setText(String.valueOf(listP.numProduct));
            }
            else {
                viewHolderInventory.txt_num_inventory.setText(String.valueOf(listP.numProduct - listP.store.numStore));

            }
            Glide.with(viewHolderInventory.imv_productInventory.getContext()).load(listP.ui_image).into(viewHolderInventory.imv_productInventory);
        }

    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
