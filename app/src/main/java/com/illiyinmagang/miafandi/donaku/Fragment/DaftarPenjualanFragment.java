package com.illiyinmagang.miafandi.donaku.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.illiyinmagang.miafandi.donaku.R;
import com.illiyinmagang.miafandi.donaku.model.IkanJual;
import com.illiyinmagang.miafandi.donaku.model.Penjualan;

import java.util.ArrayList;
import java.util.List;

public class DaftarPenjualanFragment extends Fragment {

    public DaftarPenjualanFragment() {
        // Required empty public constructor
    }


    public static DaftarPenjualanFragment newInstance() {
        DaftarPenjualanFragment fragment = new DaftarPenjualanFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    private RecyclerView recyclerView;
    private List<Penjualan> penjualans;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_daftar_penjualan, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.list_hargaIkan);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        penjualans = new ArrayList();
        for (int i = 0; i < 3; i++) {
            penjualans.add(new Penjualan(i, "Naofal","Ikan Kakap 10 Kg","0822", R.drawable.mask));
        }

        recyclerView.setAdapter(new DaftarPenjualanViewAdapter(penjualans,getContext()));

        return rootView;
    }

}
