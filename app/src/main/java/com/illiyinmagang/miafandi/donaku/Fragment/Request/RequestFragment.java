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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.illiyinmagang.miafandi.donaku.Fragment.HomeUser.DetailJual;
import com.illiyinmagang.miafandi.donaku.Fragment.HomeUser.HomeFragment;
import com.illiyinmagang.miafandi.donaku.HomeUserActivity;
import com.illiyinmagang.miafandi.donaku.R;

public class RequestFragment extends Fragment {

    public RequestFragment() {
        // Required empty public constructor
    }
    private Toolbar toolbar;
    private Button btnRequest;

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
                        getActivity().finish();
                        startActivity(new Intent(getContext(), HomeUserActivity.class));
                        Toast.makeText(getContext(),"Proses Request Ikan Berhasil",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        return v;
    }
}
