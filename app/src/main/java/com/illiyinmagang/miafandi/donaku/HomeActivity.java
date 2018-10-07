package com.illiyinmagang.miafandi.donaku;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.illiyinmagang.miafandi.donaku.Fragment.DaftarHargaFragment;
import com.illiyinmagang.miafandi.donaku.Fragment.LihatDaganganFragment;
import com.illiyinmagang.miafandi.donaku.Fragment.ProfilFragment;
import com.illiyinmagang.miafandi.donaku.Slider.SliderActivity;
import com.illiyinmagang.miafandi.donaku.Slider.ViewPagerAdapter;

import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private ViewPager viewPagerisiMenu;
//    LinearLayout sliderDotsPanel;
    AppBarLayout Appbar;
    CollapsingToolbarLayout CoolToolbar;

    private Toolbar toolbar;
    private int dotsCount;
    private ImageView[] dots;
    private int[] layouts;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = (Toolbar) findViewById(R.id.MyToolbar);
        Appbar = (AppBarLayout)findViewById(R.id.MyAppbar);
        CoolToolbar = (CollapsingToolbarLayout) findViewById(R.id.MyCollapseToolbar);

        //menu tab
        viewPagerisiMenu = (ViewPager) findViewById(R.id.viewPagerMenu);
        ViewPagerMenuAdapter viewPagerAdapterMenu = new ViewPagerMenuAdapter(getSupportFragmentManager());

        viewPagerAdapterMenu.addFragment(DaftarHargaFragment.newInstance(),"Daftar Harga");
        viewPagerAdapterMenu.addFragment(LihatDaganganFragment.newInstance(),"Lihat Dagangan");
        viewPagerAdapterMenu.addFragment(ProfilFragment.newInstance(),"Profil");
        viewPagerisiMenu.setAdapter(viewPagerAdapterMenu);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPagerisiMenu);

        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#0ABDE3"));
        tabLayout.setTabTextColors(Color.parseColor("#8692A5"), Color.parseColor("#727272"));

        setSupportActionBar(toolbar);

        //Slider Header
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        layouts = new int[]{R.layout.actvity_info};

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter();
        viewPager.setAdapter(viewPagerAdapter);

//        sliderDotsPanel = (LinearLayout) findViewById(R.id.sliderDots);

//        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
//        viewPager.setAdapter(viewPagerAdapter);

//        dotsCount = viewPagerAdapter.getCount();
//        dots = new ImageView[dotsCount];
//
//        for(int i= 0; i<dotsCount; i++){
//            dots[i] = new ImageView(this);
//            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
//
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
//            params.setMargins(8,0,8,0);
////            sliderDotsPanel.addView(dots[i], params);
//        }
//        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

////        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                for (int i = 0; i<dotsCount; i++){
//                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive_dot));
//                }
//                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//
//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new MyTimerTask(),10000,7000);
    }


//    public class MyTimerTask extends TimerTask {
//
//        @Override
//        public void run() {
//
//            HomeActivity.this.runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//
//                    if(viewPager.getCurrentItem() == 0){
//                        viewPager.setCurrentItem(1);
//                    } else if(viewPager.getCurrentItem() == 1){
//                        viewPager.setCurrentItem(2);
//                    } else{
//                        viewPager.setCurrentItem(0);
//                    }
//                }
//            });
//
//        }
//    }

    public class ViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = layoutInflater.inflate(layouts[position],container,false);
            Button btnTransaksi = (Button) v.findViewById(R.id.btn_transaksi);
            btnTransaksi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(HomeActivity.this, LogTransaksiActivity.class));
                }
            });
            container.addView(v);
            return v;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View v = (View) object;
            container.removeView(v);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

}