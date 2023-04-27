package com.example.recycleview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.mobile_activity.R;
public class ViewHolderStore extends RecyclerView.ViewHolder {
    public ImageView imv_storeP;
    public TextView nameP_store;
    public TextView priceP_store;
    public TextView tv_numberStore;
    public ImageView tv_add;
    public ImageView tv_sub;
    public ViewHolderStore(@NonNull View itemView) {
        super(itemView);
        imv_storeP = itemView.findViewById(R.id.imv_storeP);
        nameP_store = itemView.findViewById(R.id.nameP_store);
        priceP_store = itemView.findViewById(R.id.priceP_store);
        tv_numberStore = itemView.findViewById(R.id.tv_numberStore);
        tv_add = itemView.findViewById(R.id.tv_add);
        tv_sub = itemView.findViewById(R.id.tv_sub);
    }
}
