package com.illiyinmagang.miafandi.donaku;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.design.widget.BottomNavigationView;
import android.widget.Toast;

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
                fragment = new DaftarHargaFragment("lol");
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.miMessage:
                Intent i = new Intent(HomeUserActivity.this,ContactListActivity.class);
                i.putExtra("chat","user");
                startActivity(i);
                return true;

            case R.id.miNotif:
                Toast.makeText(this.getApplicationContext(),"Tidak Ada Notifikasi Yang Baru", Toast.LENGTH_SHORT).show();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
