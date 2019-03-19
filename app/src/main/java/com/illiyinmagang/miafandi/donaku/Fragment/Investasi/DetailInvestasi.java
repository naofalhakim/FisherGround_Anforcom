package com.illiyinmagang.miafandi.donaku.Fragment.Investasi;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.illiyinmagang.miafandi.donaku.Fragment.HomeUser.BayarActivity;
import com.illiyinmagang.miafandi.donaku.HomeUserActivity;
import com.illiyinmagang.miafandi.donaku.R;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class DetailInvestasi extends AppCompatActivity {
    ImageView imgInvest;
    Button btnInvest;
    TextView title, content, detailHarga,detailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_investasi);
        imgInvest = (ImageView) findViewById(R.id.imageDetailInvestasi);
        btnInvest = (Button) findViewById(R.id.btnInvest);
        detailHarga = (TextView) findViewById(R.id.detailHarga);

        final Intent i = getIntent();
        final int gambar = i.getIntExtra("gambarInvest",0);
        final int biayaInvest = i.getIntExtra("biayaInvest",0);

        imgInvest.setImageResource(gambar);
        detailHarga.setText(Integer.toString(biayaInvest));
        btnInvest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(DetailInvestasi.this);
                final View mView = getLayoutInflater().inflate(R.layout.dialogberhasil, null);

                Button btnLanjutkan = (Button)mView.findViewById(R.id.btnLanjutkan);
                title = (TextView) mView.findViewById(R.id.titleDialog);
                content = (TextView) mView.findViewById(R.id.contentDialog);

                title.setText("Proses Investasi Berhasil");
                content.setText("Segera kirim uang anda untuk segera diproses dan diberikan surat perjanjian investasi");

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                btnLanjutkan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                        startActivity(new Intent(DetailInvestasi.this, HomeUserActivity.class));
                        Toast.makeText(DetailInvestasi.this,"Proses Investasi Berhasil",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
