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

import com.illiyinmagang.miafandi.donaku.IkanJual;
import com.illiyinmagang.miafandi.donaku.R;

import java.util.ArrayList;
import java.util.List;

public class DaftarHargaFragment extends Fragment {

    public DaftarHargaFragment() {
        // Required empty public constructor
    }


    public static DaftarHargaFragment newInstance() {
        DaftarHargaFragment fragment = new DaftarHargaFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    private RecyclerView recyclerView;
    private List<IkanJual> ikanJuals;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_daftar_harga, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.list_hargaIkan);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        ikanJuals = new ArrayList();
        for (int i = 0; i < 7; i++) {
            ikanJuals.add(new IkanJual(i, "Ikan Tuna", 45000, 39000, 100000, R.drawable.ikan1));
        }

        recyclerView.setAdapter(new DaftarHargaViewAdapter(ikanJuals,getContext()));

        return rootView;
    }

}
