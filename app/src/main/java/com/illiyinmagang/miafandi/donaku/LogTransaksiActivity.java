package com.illiyinmagang.miafandi.donaku;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.illiyinmagang.miafandi.donaku.Fragment.DaftarHargaFragment;
import com.illiyinmagang.miafandi.donaku.Fragment.DaftarPenjualanFragment;
import com.illiyinmagang.miafandi.donaku.Fragment.LihatDaganganFragment;
import com.illiyinmagang.miafandi.donaku.Fragment.ProfilFragment;

public class LogTransaksiActivity extends AppCompatActivity {

    private ViewPager viewPagerisiMenu;
    private Toolbar toolbarMain;
    private TabLayout tabLayout;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_transaksi);

        toolbarMain = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbarMain);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbarMain.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        title = (TextView) toolbarMain.findViewById(R.id.toolbar_title);
        title.setText("Transaksi");

        viewPagerisiMenu = (ViewPager) findViewById(R.id.viewPagerMenu);
        ViewPagerMenuAdapter viewPagerAdapterMenu = new ViewPagerMenuAdapter(getSupportFragmentManager());

        viewPagerAdapterMenu.addFragment(DaftarPenjualanFragment.newInstance("Penjualan"),"Penjualan");
        viewPagerAdapterMenu.addFragment(DaftarPenjualanFragment.newInstance("Permintaan"),"Permintaan");
        viewPagerisiMenu.setAdapter(viewPagerAdapterMenu);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPagerisiMenu);

        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#0ABDE3"));
        tabLayout.setTabTextColors(Color.parseColor("#8692A5"), Color.parseColor("#727272"));

    }

}
