package com.illiyinmagang.miafandi.donaku.Fragment.Investasi;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.illiyinmagang.miafandi.donaku.Fragment.adapter.GridAdapter;
import com.illiyinmagang.miafandi.donaku.Fragment.adapter.InvestasiAdapter;
import com.illiyinmagang.miafandi.donaku.R;

public class InvestasiFragment extends Fragment {
    RecyclerView mRecyclerView;
    Toolbar toolbar;

    public InvestasiFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_investasi, container, false);

        toolbar = (Toolbar) rootView.findViewById(R.id.MyToolbar);
        toolbar.setTitle("");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        //toolbar.setBackgroundColor(Color.parseColor("#0277BD"));
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        //Recycler View with greed
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.listInvestasi);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        mRecyclerView.setAdapter(new InvestasiAdapter(this.getContext()));
        return rootView;
    }
}
