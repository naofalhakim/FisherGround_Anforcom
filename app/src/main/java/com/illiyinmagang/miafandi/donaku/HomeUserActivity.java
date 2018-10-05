package com.illiyinmagang.miafandi.donaku;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.support.design.widget.BottomNavigationView;

import com.illiyinmagang.miafandi.donaku.Fragment.DaftarHargaFragment;
import com.illiyinmagang.miafandi.donaku.Fragment.HomeUser.HomeFragment;
import com.illiyinmagang.miafandi.donaku.Fragment.Investasi.InvestasiFragment;
import com.illiyinmagang.miafandi.donaku.Fragment.Request.RequestFragment;
import com.illiyinmagang.miafandi.donaku.Fragment.profile.ProfileFragment;
import com.illiyinmagang.miafandi.donaku.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class HomeUserActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    BottomNavigationViewEx bnv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_user);

        BottomNavigationView bnv = (BottomNavigationView) findViewById(R.id.bottomNavViewBar);
        bnv.setOnNavigationItemSelectedListener(this);
        loadFragment(new HomeFragment());

        setupBottomNavigationView();
    }

    private void setupBottomNavigationView(){
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
    }

    private boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.btmNavHome:
                fragment = new HomeFragment();
                break;
            case R.id.btmNavDaftarHarga:
                fragment = new DaftarHargaFragment();
                break;
            case R.id.btmNavRequest:
                fragment = new RequestFragment();
                break;
            case R.id.btmNavInvestasi:
                fragment = new InvestasiFragment();
                break;
            case R.id.btmNavProfile:
                fragment = new ProfileFragment();
                break;
        }
        return loadFragment(fragment);
    }
}
