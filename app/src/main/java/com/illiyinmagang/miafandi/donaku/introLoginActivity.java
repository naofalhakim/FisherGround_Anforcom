package com.illiyinmagang.miafandi.donaku;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

public class introLoginActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnIntroLogin;
    private TextView btnBuatAkun;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_login);

        toolbar = (Toolbar) findViewById(R.id.MyToolbarIntro);
        toolbar.setBackgroundColor(Color.parseColor("#A6D8E2"));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        btnIntroLogin = (Button) findViewById(R.id.btnIntroLogin);
        btnBuatAkun = (TextView) findViewById(R.id.txtBuatAkun);
        btnIntroLogin.setOnClickListener(this);
        btnBuatAkun.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnBuatAkun){

        }else if (v == btnIntroLogin){
            Intent intent= new Intent(introLoginActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }
}
