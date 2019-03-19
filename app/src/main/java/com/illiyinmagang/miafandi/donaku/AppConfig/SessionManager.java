package com.illiyinmagang.miafandi.donaku.AppConfig;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private SharedPreferences sharedPreferences;

    public final String KEY_EMAIL = "User@gmail.com";
    public final String KEY_PASS = "PASS";
    public final String KEY_TELP = "TELP";
    public final String KEY_STATUS = "STATUS";
    public final String KEY_CONNECTION = "CONNECTION";
    public final String POSITION = "MY_SESSION";
    private SharedPreferences.Editor editor;

    private Context context;

    public SessionManager(Context context) {
        this.context = context;
        this.sharedPreferences = context.getSharedPreferences(POSITION, Context.MODE_PRIVATE);
        this.editor = sharedPreferences.edit();
    }

    public void setLogin(String email, String pass, String telp, String status, String connection){
        editor.putString(KEY_EMAIL,email);
        editor.putString(KEY_PASS,pass);
        editor.putString(KEY_TELP,telp);
        editor.putString(KEY_STATUS,status);
        editor.putString(KEY_CONNECTION,connection);
        editor.commit();
    }

    public String getEmail(){
        return sharedPreferences.getString(KEY_EMAIL,"");
    }

    public String getStatus(){
        return sharedPreferences.getString(KEY_STATUS,"");
    }

    public String getPass(){
        return sharedPreferences.getString(KEY_PASS,"");
    }

    public String getConnection(){
        return sharedPreferences.getString(KEY_CONNECTION,"");
    }

    public void doLogout(){
        editor.clear();
        editor.commit();
    }
}
