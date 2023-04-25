package com.example.romdatabase;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StoreDao {
    @Query("SELECT * FROM store")
    List<Store> getAll();
}
