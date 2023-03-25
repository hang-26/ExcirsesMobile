package com.example.login_and_signup;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharePreference {
    private static final String My_SharePreference = "My_SharePreference";
    private Context context;

    public MySharePreference(Context context) {
        this.context = context;
    }

    public void putStringValues(String key, String value ){
        SharedPreferences sharePreference = context.getSharedPreferences(My_SharePreference,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharePreference.edit();
        editor.putString(key,value);
        editor.apply();
    }

    public String getStringValues( String key){
        SharedPreferences sharedPref = context.getSharedPreferences(My_SharePreference,Context.MODE_PRIVATE);
        return sharedPref.getString(key,"@#");
    }
}
