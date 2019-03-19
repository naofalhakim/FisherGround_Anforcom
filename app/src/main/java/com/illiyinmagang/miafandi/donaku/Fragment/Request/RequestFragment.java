package com.illiyinmagang.miafandi.donaku.Fragment.Request;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.illiyinmagang.miafandi.donaku.AppConfig.SessionManager;
import com.illiyinmagang.miafandi.donaku.Fragment.HomeUser.DetailJual;
import com.illiyinmagang.miafandi.donaku.Fragment.HomeUser.HomeFragment;
import com.illiyinmagang.miafandi.donaku.HomeUserActivity;
import com.illiyinmagang.miafandi.donaku.R;
import com.illiyinmagang.miafandi.donaku.RetrofitConfig.APIInterface;
import com.illiyinmagang.miafandi.donaku.RetrofitConfig.ApiClient;
import com.illiyinmagang.miafandi.donaku.model.TempModel.TempPermintaan;

import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestFragment extends Fragment {

    public RequestFragment() {
        // Required empty public constructor
    }
    private Toolbar toolbar;
    private Button btnRequest;
    private EditText etNamaIkan, etBerat, etProvinsi;
    private RadioButton rdKargo, rdAmbilSendiri, rdLain;
    private SessionManager sessionManager;
    private String rbText;
    private String[] Telp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_request, container, false);
        // Inflate the layout for this fragment
        sessionManager = new SessionManager(getContext());
        Telp = getResources().getStringArray(R.array.TlpQu);

        etNamaIkan = (EditText) v.findViewById(R.id.etNamaIkan);
        etBerat = (EditText) v.findViewById(R.id.etBerat);
        etProvinsi = (EditText) v.findViewById(R.id.etProvinsi);
        rdKargo = (RadioButton) v.findViewById(R.id.rb1);
        rdAmbilSendiri = (RadioButton) v.findViewById(R.id.rb2);
        rdLain = (RadioButton) v.findViewById(R.id.rb3);

        if(rdAmbilSendiri.isChecked()){
            rbText = rdAmbilSendiri.getText().toString();
        }else if(rdKargo.isChecked()){
            rbText = rdKargo.getText().toString();
        }else{
            rbText = rdLain.getText().toString();
        }

        toolbar = (Toolbar) v.findViewById(R.id.MyToolbar);
        toolbar.setTitle("");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        btnRequest = (Button) v.findViewById(R.id.btnRequest);
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
                final View mView = getLayoutInflater().inflate(R.layout.dialogberhasil, null);
                Button btnLanjutkan = (Button)mView.findViewById(R.id.btnLanjutkan);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                btnLanjutkan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int i = new Random().nextInt(Telp.length-1);
                        addRequest(sessionManager.getEmail(),sessionManager.getPass(),
                                sessionManager.KEY_EMAIL,etProvinsi.getText().toString(),Telp[i],etNamaIkan.getText().toString(),
                                etBerat.getText().toString(),rbText,"19-05-2019");
                    }
                });
            }
        });

        return v;
    }

    private void addRequest(String email, String pass, String nama_pembeli,
                            String alamat, String telp, String nama_ikan,
                            String berat, String jasa_pengiriman,
                            String tanggal_kirim){
        Log.e("emailku",email);
        APIInterface apiInterface = ApiClient.getApiClient().create(APIInterface.class);
        Call<TempPermintaan> call = apiInterface.addPermintaan(email,pass,nama_pembeli,alamat,telp,nama_ikan,berat,jasa_pengiriman,tanggal_kirim);
        call.enqueue(new Callback<TempPermintaan>() {
            @Override
            public void onResponse(Call<TempPermintaan> call, Response<TempPermintaan> response) {
                Log.e("addPermintaan",response.body().getSukses());
                if(response.body().getSukses().equals("1")){
                    getActivity().finish();
                    startActivity(new Intent(getContext(), HomeUserActivity.class));
                    Toast.makeText(getContext(),"Proses Request Ikan Berhasil",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getContext(),"Proses Request Ikan Gagal Server Sibuk",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<TempPermintaan> call, Throwable t) {
                Log.e("addPermintaanGagal",t.getMessage());
                getActivity().finish();
                startActivity(new Intent(getContext(), HomeUserActivity.class));
                Toast.makeText(getContext(),"Proses Request Ikan Gagal Server Sibuk",Toast.LENGTH_LONG).show();
            }
        });
    }
}
