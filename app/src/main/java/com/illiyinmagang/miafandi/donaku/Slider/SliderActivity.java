package com.illiyinmagang.miafandi.donaku.Slider;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.illiyinmagang.miafandi.donaku.LoginActivity;
import com.illiyinmagang.miafandi.donaku.R;

public class SliderActivity extends AppCompatActivity {
    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private SliderIntromanagerActivity introManager;
    private int [] layouts;
    private  TextView[] dots;
    private LinearLayout dotsLayout;
    private Button btnMasuk;
    private PreferenceIntro preferenceIntro;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferenceIntro = new PreferenceIntro(SliderActivity.this);

        introManager = new SliderIntromanagerActivity(this);
        if (!introManager.Check()) {
            introManager.setFirst(false);
            Intent intent = new Intent(SliderActivity.this, LoginActivity.class);

            preferenceIntro.createIntro();
            startActivity(intent);
            finish();
        }
        if(Build.VERSION.SDK_INT>=21){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        setContentView(R.layout.activity_slider);
        toolbar = (Toolbar) findViewById(R.id.MyToolbar);
        toolbar.setBackgroundColor(Color.parseColor("#0277BD"));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        viewPager =(ViewPager) findViewById(R.id.viewPager);
        dotsLayout=(LinearLayout)findViewById(R.id.layoutDots);
        btnMasuk = (Button) findViewById(R.id.btnMasuk);
        btnMasuk.setVisibility(View.INVISIBLE);

        layouts = new int[]{R.layout.actvity_slider1,R.layout.activity_slider2,R.layout.activity_slider3};
        addButtomDots(0);
        changeStatusBarColor();
        viewPagerAdapter = new ViewPagerAdapter();
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(viewListener);

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SliderActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }
    private void addButtomDots(int position){
        dots = new TextView[layouts.length];
        int [] colorActive = getResources().getIntArray(R.array.dot_active);
        int [] colorInactive = getResources().getIntArray(R.array.dot_inactive);
        dotsLayout.removeAllViews();
        for (int  i = 0; i<dots.length;i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(38);
            dots[i].setLetterSpacing((float) 0.7);
            dots[i].setTextColor(colorInactive[position]);
            dotsLayout.addView(dots[i]);
        }
        if (dots.length>0){
            dots[position].setTextColor(colorActive[position]);
        }
    }
    private int getItem(int i){
        return viewPager.getCurrentItem()+1;
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener(){

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addButtomDots(position);
            if(position==layouts.length-1){
                btnMasuk.setVisibility(View.VISIBLE);
            }else{
                btnMasuk.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    public void changeStatusBarColor(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
    public class ViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View v = layoutInflater.inflate(layouts[position],container,false);
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

}
