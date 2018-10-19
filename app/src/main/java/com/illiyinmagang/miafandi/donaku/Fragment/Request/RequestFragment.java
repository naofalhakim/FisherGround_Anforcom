package com.illiyinmagang.miafandi.donaku.Fragment.Request;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.illiyinmagang.miafandi.donaku.R;

public class RequestFragment extends Fragment {

    public RequestFragment() {
        // Required empty public constructor
    }
    private Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_request, container, false);
        // Inflate the layout for this fragment
        toolbar = (Toolbar) v.findViewById(R.id.MyToolbar);
        toolbar.setTitle("");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        //toolbar.setBackgroundColor(Color.parseColor("#0277BD"));
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        return v;
    }
}
