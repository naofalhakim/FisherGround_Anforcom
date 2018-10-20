package com.illiyinmagang.miafandi.donaku.Fragment.HomeUser;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.illiyinmagang.miafandi.donaku.HomeUserActivity;
import com.illiyinmagang.miafandi.donaku.R;

public class BayarActivity extends AppCompatActivity {
    Button btnSubmit;
    TextView title, content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayar);

        //back botton
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnSubmit = (Button) findViewById(R.id.btnBayar);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(BayarActivity.this);
                final View mView = getLayoutInflater().inflate(R.layout.dialogberhasil, null);

                Button btnLanjutkan = (Button)mView.findViewById(R.id.btnLanjutkan);
                title = (TextView) mView.findViewById(R.id.titleDialog);
                content = (TextView) mView.findViewById(R.id.contentDialog);

                title.setText("Pemesanan Ikan Berhasil");
                content.setText("Segera lakukan pembayaran dan konfirmasi pesanan anda agar segera diproses");

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                btnLanjutkan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                        startActivity(new Intent(BayarActivity.this, HomeUserActivity.class));
                        Toast.makeText(BayarActivity.this,"Proses Pemesanan Berhasil",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
