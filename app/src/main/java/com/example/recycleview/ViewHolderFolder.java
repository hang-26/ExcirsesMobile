package com.example.recycleview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_activity.R;

public class ViewHolderFolder extends RecyclerView.ViewHolder {
    public TextView nameFolder;
    public ImageView viewFolder;
    public ViewHolderFolder(@NonNull View itemView) {
        super(itemView);
        nameFolder=itemView.findViewById(R.id.tv_nameFolder);
        viewFolder = itemView.findViewById(R.id.imv_view_folder);
    }
}
