package com.example.recycleview;

import com.example.romdatabase.Product;

import java.util.List;
import java.util.function.UnaryOperator;

public class MyFolder {
    public String namSP;
    public String imageFolder;

    public MyFolder(String nameFolder, String imgViewFolder){
        this.namSP = nameFolder;
        this.imageFolder = imgViewFolder;
    }
    public String getNamSP(){
        return this.namSP ;
    }
    public String getImageFolder(){
        return  this.imageFolder ;
    }

}
