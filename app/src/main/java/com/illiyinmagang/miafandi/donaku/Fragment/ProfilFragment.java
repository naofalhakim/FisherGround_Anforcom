package com.illiyinmagang.miafandi.donaku.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.illiyinmagang.miafandi.donaku.R;

import java.util.ArrayList;
import java.util.List;


public class ProfilFragment extends Fragment {

    public ProfilFragment() {
        // Required empty public constructor
    }

    private RecyclerView recyclerView;
    private List<String> stringList;

    public static ProfilFragment newInstance() {
        ProfilFragment fragment = new ProfilFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profil, container, false);
        stringList = new ArrayList();
        stringList.add("Profil Saya");
        stringList.add("Bantuan");
        stringList.add("Kebijakan Privasi");
        stringList.add("Tentang");
        stringList.add("Keluar Aplikasi");

        recyclerView = (RecyclerView) v.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        recyclerView.setAdapter(new ListMenuViewAdapter(stringList,this.getContext()));

        return v;

    }

}
