package com.example.recycleview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_activity.R;

public class ViewHolderHome extends RecyclerView.ViewHolder {
    public TextView nameP;
    public TextView priceP;
    public ImageView viewP;
    public TextView btn_buy;
    public ViewHolderHome(@NonNull View itemView) {
        super(itemView);
        nameP=itemView.findViewById(R.id.tv_name_product);
        priceP = itemView.findViewById(R.id.tv_price);
        viewP = itemView.findViewById(R.id.imv_product);
        btn_buy = itemView.findViewById(R.id.btn_buy);
    }

}
