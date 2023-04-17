package com.example.recycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mobile_activity.R;
import com.example.romdatabase.Product;

import java.util.List;

public class AdapterFolder extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public List<MyFolder> myFolders;
    public  AdapterFolder (List<MyFolder> list){
        this.myFolders = list;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.folder_list_fragment,parent, false);
        ViewHolderFolder viewHolderFolder = new ViewHolderFolder(view);
        return viewHolderFolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ViewHolderFolder){
            ViewHolderFolder view = (ViewHolderFolder) holder;
            MyFolder mylist = myFolders.get(position);
            view.nameFolder.setText(mylist.getNamSP());
            Glide.with(view.viewFolder.getContext()).load(mylist.getImageFolder()).into(view.viewFolder);

        }

    }

    @Override
    public int getItemCount() {
        return myFolders.size();
    }



}
