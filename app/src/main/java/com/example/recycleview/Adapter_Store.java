package com.example.recycleview;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.bumptech.glide.Glide;
import com.example.mobile_activity.R;
import com.example.romdatabase.ProductDao;
import com.example.romdatabase.ProductDatabase;
import com.example.romdatabase.Store;
import com.example.romdatabase.StoreDao;
import com.example.romdatabase.StoreDatabase;
import com.example.store.StoreActivity;

import java.util.List;

public class Adapter_Store extends RecyclerView.Adapter<ViewHolderStore> {
    public List<Store> storeProduct;
    public StoreDatabase storeDatabase ;
    public StoreDao storeDao ;
    public  Adapter_Store(List<Store> listStore, StoreDao storeDao){
        this.storeProduct = listStore;
        this.storeDao = storeDao;
    }

    @NonNull
    @Override
    public ViewHolderStore onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.store_rcv,parent, false);
        ViewHolderStore viewHolderStore = new ViewHolderStore(view);
        return viewHolderStore;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderStore holder, int position) {
        if(holder instanceof ViewHolderStore){
            ViewHolderStore viewHolderStore = (ViewHolderStore) holder;
            Store store = storeProduct.get(position);
            viewHolderStore.nameP_store.setText(store.product.nameProduct);
            viewHolderStore.priceP_store.setText(Double.toString(store.product.priceProduct));
            viewHolderStore.tv_numberStore.setText(Integer.toString(store.numStore));
            Glide.with(viewHolderStore.imv_storeP.getContext()).load(store.product.ui_image).into(viewHolderStore.imv_storeP);

            viewHolderStore.tv_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int numP = store.product.numProduct;
                    store.numStore =  store.numStore +1;
                    if(store.numStore <numP){
                        storeDao.updateStore(store.uid, store.numStore );
                        notifyDataSetChanged();
                    }
                    else {

                    }
                }
            });

            viewHolderStore.tv_sub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(store.numStore >0){
                        store.numStore = store.numStore -1;
                        storeDao.updateStore(store.uid, store.numStore);
                        notifyDataSetChanged();
                    }
                    if(store.numStore==0) {
                        storeDao.updateStore(store.uid, store.numStore);
                        storeDao.deleteById(store.uid);
                        notifyDataSetChanged();
                    }
                }
            });

            viewHolderStore.btn_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    storeDao.deleteById(store.uid);
                    notifyDataSetChanged();
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return storeProduct.size();
    }
}
