package com.example.recycleview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_activity.R;

public class ViewHolderInventory extends RecyclerView.ViewHolder {
    public TextView txt_productName;
    public  TextView txt_num_inventory;
    public ImageView imv_productInventory;

    public ViewHolderInventory(@NonNull View itemView) {
        super(itemView);
        txt_productName = itemView.findViewById(R.id.txt_productName);
        txt_num_inventory = itemView.findViewById(R.id.txt_num_inventory);
        imv_productInventory = itemView.findViewById(R.id.imv_productInventory);
    }
}
