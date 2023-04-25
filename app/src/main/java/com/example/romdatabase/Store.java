package com.example.romdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity

public class Store {
    public Store(){}
    public Store(int id, String nameProduct, int numStore) {
        this.uid = id;
        this.numStore = numStore;
    }
    @PrimaryKey()
    public int uid;
    @ColumnInfo(name ="num")
    public int numStore;

}
