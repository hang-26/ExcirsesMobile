package com.example.login_and_signup;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharePreference {
    private static final String My_SharePreference = "My_SharePreference";
    private Context context;

    public MySharePreference(Context context) {
        this.context = context;
    }

    public void putBoolenValues(boolean value ){
        SharedPreferences sharePreference = context.getSharedPreferences(My_SharePreference,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharePreference.edit();
    }
}
