package com.example.romdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
@Dao
public interface ProductDao {
    @Query("SELECT * FROM product")
    List<Product> getAll();
    @Query("SELECT * FROM product WHERE uid IN (:userIds)")
    List<Product> loadAllByIds(int[] userIds);

    @Insert
    void insertAll(Product... products);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Product> products);

    @Delete
    void delete(Product product);
}
