package com.illiyinmagang.miafandi.donaku.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.illiyinmagang.miafandi.donaku.AppConfig.SessionManager;
import com.illiyinmagang.miafandi.donaku.RetrofitConfig.APIInterface;
import com.illiyinmagang.miafandi.donaku.RetrofitConfig.ApiClient;
import com.illiyinmagang.miafandi.donaku.UploadDaganganActivity;
import com.illiyinmagang.miafandi.donaku.model.IkanJual;
import com.illiyinmagang.miafandi.donaku.R;
import com.illiyinmagang.miafandi.donaku.model.TempModel.TempDagangan;
import com.illiyinmagang.miafandi.donaku.model.TempModel.TempUser;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LihatDaganganFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<IkanJual> ikanJuals;
    private FloatingActionButton floatingActionButton;
    private SessionManager sessionManager;

    public LihatDaganganFragment() {
        // Required empty public constructor
    }

    public static LihatDaganganFragment newInstance() {
        LihatDaganganFragment fragment = new LihatDaganganFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_lihat_dagangan, container, false);
        sessionManager = new SessionManager(getContext());

        recyclerView = (RecyclerView) rootView.findViewById(R.id.list_hargaIkan);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        floatingActionButton = (FloatingActionButton) rootView.findViewById(R.id.fab);

        ikanJuals = new ArrayList();
//        initData();
        ikanJuals.add(new IkanJual(0, "Ikan Tuna", 45000, 45000, 39000, R.drawable.ikan1,40));
        ikanJuals.add(new IkanJual(1, "Ikan Tongkol", 22000, 20000, 21000, R.drawable.itongkol,20));
        ikanJuals.add(new IkanJual(2, "Kakap Merah", 60000, 57000, 57000, R.drawable.ikakap,38));
        ikanJuals.add(new IkanJual(3, "Kepiting", 55000, 50000, 50000, R.drawable.ikepiting,19));
        ikanJuals.add(new IkanJual(4, "Kerang Hijau", 20000, 18000, 18000, R.drawable.ikeranghijau,30));
        ikanJuals.add(new IkanJual(5, "Cumi-Cumi", 45000, 43000, 43000, R.drawable.icumi,22));

        recyclerView.setAdapter(new ListHargaViewAdapter(ikanJuals,getContext()));
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), UploadDaganganActivity.class));
            }
        });

        return rootView;

    }

    private void initData(){
        if(sessionManager.getStatus().equals("offline")){
            ikanJuals.add(new IkanJual(0, "Ikan Tuna", 45000, 45000, 39000, R.drawable.ikan1,40));
            ikanJuals.add(new IkanJual(1, "Ikan Tongkol", 22000, 20000, 21000, R.drawable.itongkol,20));
            ikanJuals.add(new IkanJual(2, "Kakap Merah", 60000, 57000, 57000, R.drawable.ikakap,38));
            ikanJuals.add(new IkanJual(3, "Kepiting", 55000, 50000, 50000, R.drawable.ikepiting,19));
            ikanJuals.add(new IkanJual(4, "Kerang Hijau", 20000, 18000, 18000, R.drawable.ikeranghijau,30));
            ikanJuals.add(new IkanJual(5, "Cumi-Cumi", 45000, 43000, 43000, R.drawable.icumi,22));
        }else{
            getDataDagang(sessionManager.getEmail());
        }
    }

    private void getDataDagang(String email){
        APIInterface apiInterface = ApiClient.getApiClient().create(APIInterface.class);
        Call<TempDagangan> call = apiInterface.getDagangan(email);
//        Call<TempDagangan> call = apiInterface.getDagangan(email);
        call.enqueue(new Callback<TempDagangan>() {
            @Override
            public void onResponse(Call<TempDagangan> call, Response<TempDagangan> response) {
                Log.e("dagangan",response.body().toString());
            }

            @Override
            public void onFailure(Call<TempDagangan> call, Throwable t) {
                Log.e("dagangan",t.getMessage());
            }
        });

    }
}
