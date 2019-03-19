package com.illiyinmagang.miafandi.donaku.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.illiyinmagang.miafandi.donaku.AppConfig.SessionManager;
import com.illiyinmagang.miafandi.donaku.R;
import com.illiyinmagang.miafandi.donaku.RetrofitConfig.APIInterface;
import com.illiyinmagang.miafandi.donaku.RetrofitConfig.ApiClient;
import com.illiyinmagang.miafandi.donaku.model.IkanJual;
import com.illiyinmagang.miafandi.donaku.model.Penjualan;
import com.illiyinmagang.miafandi.donaku.model.TempModel.TempPermintaan;
import com.illiyinmagang.miafandi.donaku.model.TempModel.TempUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaftarPenjualanFragment extends Fragment {

    private String page;
    private LinearLayout linearLayout;

    public DaftarPenjualanFragment() {
        // Required empty public constructor
    }

    public static DaftarPenjualanFragment newInstance(String page) {
        DaftarPenjualanFragment fragment = new DaftarPenjualanFragment();
        Bundle args = new Bundle();
        fragment.page = page;
        fragment.setArguments(args);
        return fragment;
    }

    private RecyclerView recyclerView;
    private List<Penjualan> penjualans;
    private SessionManager sessionManager;
    private String[] myFish, myKonsumen, myTlp, myAdress;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_daftar_penjualan, container, false);
        linearLayout = (LinearLayout) rootView.findViewById(R.id.form_search);

        sessionManager = new SessionManager(getContext());

        myFish = getResources().getStringArray(R.array.IkanQu);
        myKonsumen = getResources().getStringArray(R.array.Konsumen);
        myTlp = getResources().getStringArray(R.array.TlpQu);
        myAdress = getResources().getStringArray(R.array.Address);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.list_hargaIkan);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        penjualans = new ArrayList();
        if (page.equals("Penjualan")) {
            for (int i = 0; i < 3; i++) {
                penjualans.add(new Penjualan(i, myKonsumen[i], myFish[i], myTlp[i], R.drawable.mask));
                penjualans.get(i).setWeight(new Random().nextInt(80) + 10);
            }
            recyclerView.setAdapter(new DaftarPenjualanViewAdapter(penjualans, getContext()));
            linearLayout.setVisibility(View.VISIBLE);
        }else{
            getDataPermintaan();
                   }

            return rootView;
        }

        private void getDataPermintaan(){
            APIInterface apiInterface = ApiClient.getApiClient().create(APIInterface.class);
            Call<TempPermintaan> call = apiInterface.getPermintaan();
            call.enqueue(new Callback<TempPermintaan>() {
                @Override
                public void onResponse(Call<TempPermintaan> call, Response<TempPermintaan> response) {
                    Log.e("permintaan",response.body().getUsers().get(0).getNotelp());

                    penjualans = response.body().getUsers();
                    recyclerView.setAdapter(new DaftarPermintaanViewAdapter(penjualans,getContext()));
                    linearLayout.setVisibility(View.INVISIBLE);
                }

                @Override
                public void onFailure(Call<TempPermintaan> call, Throwable t) {
                    Log.e("permintaan_eror",t.getMessage());
                    for (int i = 0; i < 3; i++) {
                        penjualans.add(new Penjualan(i, myKonsumen[i],myAdress[i],myFish[i],myTlp[i], R.drawable.mask, new Random().nextInt(80)+10));
                        recyclerView.setAdapter(new DaftarPermintaanViewAdapter(penjualans,getContext()));
                        linearLayout.setVisibility(View.INVISIBLE);
                    }
                }
            });
        }

}
