package com.illiyinmagang.miafandi.donaku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.illiyinmagang.miafandi.donaku.Slider.SliderActivity;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_page);

        final Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    //for time in 3 second
                    for (int i =0; i<100;i++){
                        sleep(40);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(getApplicationContext(), SliderActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        };
        thread.start();
    }
}
