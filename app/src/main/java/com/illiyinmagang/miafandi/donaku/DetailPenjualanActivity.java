package com.illiyinmagang.miafandi.donaku;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class DetailPenjualanActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbarMain;
    private Button btnKonfirmasi;
    private TextView txtTitle,txtNamaDangan,txtBeratDagangan,txtTotalDagangan, txtTotalBayar,txtPenerima, txtNotelp,txtAlamatPenerima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_penjualan);

        String nama = getIntent().getStringExtra("nama");
        String pesanan = getIntent().getStringExtra("pesanan");
        String bobot = getIntent().getStringExtra("bobot");
        String telp = getIntent().getStringExtra("telp");
        String alamat = getIntent().getStringExtra("alamat");

        txtTitle = (TextView) findViewById(R.id.toolbar_title);
        txtNamaDangan = (TextView) findViewById(R.id.txt_nama_dagangan);
        txtBeratDagangan = (TextView) findViewById(R.id.txt_berat_dagangan);
        txtTotalDagangan = (TextView) findViewById(R.id.txt_total_dagangan);
        txtTotalBayar = (TextView) findViewById(R.id.txt_total_pembayaran);
        txtPenerima = (TextView) findViewById(R.id.txt_nama_penerima);
        txtNotelp = (TextView) findViewById(R.id.txt_notelp_penerima);
        txtAlamatPenerima = (TextView) findViewById(R.id.txt_tempat_penerima);
        btnKonfirmasi = (Button) findViewById(R.id.btn_konfirmasi);

        toolbarMain = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbarMain);

        String sign = getIntent().getStringExtra("sign");
        if(sign.equals("Lihat Detail")) {
            txtTitle.setText("Detail Penjualan");
            btnKonfirmasi.setVisibility(View.GONE);
        }else{
            txtTitle.setText("Detail Permintaan");
            txtPenerima.setText(nama);
            txtNamaDangan.setText(pesanan);
            txtBeratDagangan.setText(bobot);
            txtNotelp.setText(telp);
            txtAlamatPenerima.setText(alamat);
        }

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbarMain.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnKonfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void showDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);
        alertDialogBuilder.setTitle("Ambil Permintaan");
        alertDialogBuilder
                .setMessage("Apakah anda ingin mengambil permintaan ini ?")
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(false)
                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        startActivity(new Intent(DetailPenjualanActivity.this,LogTransaksiActivity.class));
                        Toast.makeText(DetailPenjualanActivity.this,"Pengambilan Permintaan Berhasil dilakukan",Toast.LENGTH_SHORT).show();
                        DetailPenjualanActivity.this.finish();

                    }
                })
                .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
