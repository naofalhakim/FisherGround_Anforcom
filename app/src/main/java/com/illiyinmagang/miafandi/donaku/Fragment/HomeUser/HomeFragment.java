package com.illiyinmagang.miafandi.donaku.Fragment.HomeUser;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.illiyinmagang.miafandi.donaku.Fragment.adapter.GridAdapter;
import com.illiyinmagang.miafandi.donaku.R;
import com.illiyinmagang.miafandi.donaku.Slider.ViewPagerAdapter;

import java.util.Timer;
import java.util.TimerTask;

public class HomeFragment extends Fragment {
    ViewPager viewPager;
    LinearLayout sliderDotsPanel;
    private int dotsCount;
    private ImageView[] dots;

    AppBarLayout Appbar;
    CollapsingToolbarLayout CoolToolbar;
    Boolean ExpandedActionBar = true;
    private Toolbar toolbar;

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        toolbar = (Toolbar) rootView.findViewById(R.id.MyToolbarPelanggan);
        Appbar = (AppBarLayout)rootView.findViewById(R.id.MyAppbar);
        CoolToolbar = (CollapsingToolbarLayout) rootView.findViewById(R.id.MyCollapseToolbar);

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
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);


        //=========================Sider
        viewPager = (ViewPager) rootView.findViewById(R.id.viewPager);
        sliderDotsPanel = (LinearLayout) rootView.findViewById(R.id.sliderDots);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(rootView.getContext());
        viewPager.setAdapter(viewPagerAdapter);

        dotsCount = viewPagerAdapter.getCount();
        dots = new ImageView[dotsCount];

        for(int i= 0; i<dotsCount; i++){
            dots[i] = new ImageView(rootView.getContext());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.nonactive_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8,0,8,0);
            sliderDotsPanel.addView(dots[i], params);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i<dotsCount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(),R.drawable.nonactive_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(),R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new HomeFragment.MyTimerTask(),12000,8000);

        //Recycler View with greed
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(getActivity(),2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new GridAdapter(this.getContext());
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            if (getActivity() == null){

            }else{
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        if(viewPager.getCurrentItem() == 0){
                            viewPager.setCurrentItem(1);
                        } else if(viewPager.getCurrentItem() == 1){
                            viewPager.setCurrentItem(2);
                        }else{
                            viewPager.setCurrentItem(0);
                        }
                    }
                });
            }
        }
    }
}
