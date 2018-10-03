package com.illiyinmagang.miafandi.donaku;

import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.illiyinmagang.miafandi.donaku.Fragment.DaftarHargaFragment;
import com.illiyinmagang.miafandi.donaku.Fragment.LihatDaganganFragment;
import com.illiyinmagang.miafandi.donaku.Fragment.ProfilFragment;
import com.illiyinmagang.miafandi.donaku.Slider.ViewPagerAdapter;

import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {
    private ViewPager viewPager,viewPagerisiMenu;
    LinearLayout sliderDotsPanel;
    AppBarLayout Appbar;
    CollapsingToolbarLayout CoolToolbar;
    Boolean ExpandedActionBar = true;

    private Toolbar toolbar;
    private int dotsCount;
    private ImageView[] dots;
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

        viewPagerAdapterMenu.addFragment(DaftarHargaFragment.newInstance(),"DAFTAR HARGA");
        viewPagerAdapterMenu.addFragment(LihatDaganganFragment.newInstance(),"LIHAT DAGANGAN");
        viewPagerAdapterMenu.addFragment(ProfilFragment.newInstance(),"PROFIL");
        viewPagerisiMenu.setAdapter(viewPagerAdapterMenu);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPagerisiMenu);

        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#0ABDE3"));
        tabLayout.setTabTextColors(Color.parseColor("#8692A5"), Color.parseColor("#727272"));

        Appbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if(Math.abs(verticalOffset) > 180){
                    ExpandedActionBar = false;
                    CoolToolbar.setTitle("Fisher Ground");
                    //CoolToolbar.setContentScrimColor(Color.parseColor("#ffffff"));
                }else{
                    ExpandedActionBar = true;
                    CoolToolbar.setTitle(" ");
                }
            }
        });

        toolbar.setTitle("FISHER GROUND");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        //toolbar.setBackgroundColor(Color.parseColor("#0277BD"));
        setSupportActionBar(toolbar);


        //Slider Header
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        sliderDotsPanel = (LinearLayout) findViewById(R.id.sliderDots);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

        dotsCount = viewPagerAdapter.getCount();
        dots = new ImageView[dotsCount];

        for(int i= 0; i<dotsCount; i++){
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8,0,8,0);
            sliderDotsPanel.addView(dots[i], params);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i<dotsCount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.nonactive_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(),10000,7000);
    }


    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if(viewPager.getCurrentItem() == 0){
                        viewPager.setCurrentItem(1);
                    } else if(viewPager.getCurrentItem() == 1){
                        viewPager.setCurrentItem(2);
                    } else{
                        viewPager.setCurrentItem(0);
                    }
                }
            });

        }
    }
}