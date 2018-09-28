package com.illiyinmagang.miafandi.donaku.Slider;

import android.content.Context;
import android.content.SharedPreferences;

public class SliderIntromanagerActivity {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;

    public SliderIntromanagerActivity(Context context){
        this.context = context;
        this.pref = context.getSharedPreferences("first", 0);
        this.editor = pref.edit();
    }

    public void setFirst(boolean isFirst){
        editor.putBoolean("check",isFirst);
        editor.commit();
    }

    public boolean Check(){
        return pref.getBoolean("check",true);
    }
}
