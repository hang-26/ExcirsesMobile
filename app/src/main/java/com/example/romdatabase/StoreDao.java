package com.example.romdatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StoreDao {
    @Query("SELECT * FROM store")
    List<Store> getAll();
    @Query("UPDATE Store SET num = :number WHERE uid =:id")
    int updateStore(int id, int number);

    @Query("DELETE FROM Store WHERE uid = :id")
    void deleteById(int id);

    @Insert
    void insert(Store stores);
}
