package com.illiyinmagang.miafandi.donaku.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.illiyinmagang.miafandi.donaku.ChatActivity;
import com.illiyinmagang.miafandi.donaku.model.IkanJual;
import com.illiyinmagang.miafandi.donaku.R;

import java.util.ArrayList;
import java.util.List;

public class DaftarHargaFragment extends Fragment {

    private String lol;

    @SuppressLint("ValidFragment")
    public DaftarHargaFragment(String lol) {
        // Required empty public constructor
        this.lol = lol;
    }

    public DaftarHargaFragment() {
        this.lol = "pool";
    }

    public static DaftarHargaFragment newInstance() {
        DaftarHargaFragment fragment = new DaftarHargaFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    private RecyclerView recyclerView;
    private List<IkanJual> ikanJuals;
    private Toolbar toolbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_daftar_harga, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.list_hargaIkan);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        toolbar = (Toolbar) rootView.findViewById(R.id.MyToolbar);

        if(lol.equals("lol")){
            toolbar.setTitle("");
            toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
            //toolbar.setBackgroundColor(Color.parseColor("#0277BD"));
            ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        }else{
            toolbar.setVisibility(View.GONE);
        }


        ikanJuals = new ArrayList();
        ikanJuals.add(new IkanJual(1, "Ikan Tongkol", 22000, 20000, 21000, R.drawable.itongkol));
        ikanJuals.add(new IkanJual(2, "Cumi-Cumi", 45000, 20000, 43000, R.drawable.icumi));
        ikanJuals.add(new IkanJual(2, "Gurita", 35000, 20000, 32000, R.drawable.igurita));
        ikanJuals.add(new IkanJual(2, "Kakap Merah", 60000, 20000, 57000, R.drawable.ikakap));
        ikanJuals.add(new IkanJual(2, "Ikan Kembung", 25000, 20000, 22000, R.drawable.ikembung));
        ikanJuals.add(new IkanJual(2, "Kepiting", 55000, 20000, 50000, R.drawable.ikepiting));
        ikanJuals.add(new IkanJual(2, "Kerang", 15000, 20000, 12000, R.drawable.ikerang));
        ikanJuals.add(new IkanJual(2, "Patin", 35000, 20000, 34000, R.drawable.ipatin));
        ikanJuals.add(new IkanJual(2, "Udang", 35000, 20000, 33000, R.drawable.iudang));
        ikanJuals.add(new IkanJual(2, "Gurami", 45000, 20000, 40000, R.drawable.igurame));
        ikanJuals.add(new IkanJual(2, "Kerang Hijau", 20000, 20000, 18000, R.drawable.ikeranghijau));
        ikanJuals.add(new IkanJual(2, "Lobster", 85000, 20000, 80000, R.drawable.ilobster));



        recyclerView.setAdapter(new DaftarHargaViewAdapter(ikanJuals,getContext()));

        return rootView;
    }

}
