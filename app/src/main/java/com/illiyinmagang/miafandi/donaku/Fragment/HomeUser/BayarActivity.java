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

import com.illiyinmagang.miafandi.donaku.Fragment.HomeUser.BankModel.Bank;
import com.illiyinmagang.miafandi.donaku.Fragment.HomeUser.BankModel.BankDetail;
import com.illiyinmagang.miafandi.donaku.HomeUserActivity;
import com.illiyinmagang.miafandi.donaku.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import iammert.com.expandablelib.ExpandableLayout;
import iammert.com.expandablelib.Section;

public class BayarActivity extends AppCompatActivity {
    Button btnSubmit;
    TextView title, content, ikanBayar, posBayar, totalBayar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayar);

        final Intent i = getIntent();
        final String hikan = i.getStringExtra("hargaIkan");
        final String hpos = i.getStringExtra("hargaPos");
        final String htotal = i.getStringExtra("hargaTotal");

        ikanBayar = (TextView)findViewById(R.id.txtHargaIkanBayar);
        posBayar = (TextView)findViewById(R.id.txtHargaKirimBayar);
        totalBayar = (TextView)findViewById(R.id.txtHargaTotalBayar);

        ikanBayar.setText(hikan);
        posBayar.setText(hpos);
        int sumHarga = Integer.parseInt(htotal);

        Random r = new Random();
        int i1 = r.nextInt(999 - 1) + 1;
        final int bayarkan = sumHarga+i1;
        totalBayar.setText(Integer.toString(bayarkan));

        //back botton
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //expand
        ExpandableLayout layout = (ExpandableLayout) findViewById(R.id.expandable_layout);

        layout.setRenderer(new ExpandableLayout.Renderer<Bank, BankDetail>() {
            @Override
            public void renderParent(View view, Bank bank, boolean isExpanded, int parentPosition) {
                ((TextView)view.findViewById(R.id.txtNamaBank)).setText(bank.nama);
                view.findViewById(R.id.imgArrow).setBackgroundResource(isExpanded?R.drawable.ic_right:R.drawable.ic_down);
                view.findViewById(R.id.imgBank).setBackgroundResource(bank.imgBank);
            }

            @Override
            public void renderChild(View view, BankDetail bankDetail, int parentPosition, int childPosition) {
                ((TextView)view.findViewById(R.id.txt1)).setText(bankDetail.detail);
            }
        });

        layout.addSection(getSection("Bang BCA",R.drawable.bca,"Pembayaran dapat dilakukan melalui transfer ke rekening virtual account  BCA (0221-455654-7321 FisherNets"));
        layout.addSection(getSection("Bang Mandiri",R.drawable.mandiri,"Pembayaran dapat dilakukan melalui transfer ke rekening virtual account  Mandiri (0331-9488-0012 FisherNets)"));

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
                content.setText("Segera lakukan pembayaran sebesar\nRp "+bayarkan+",00 Konfirmasi pesanan anda agar segera diproses");

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

    private Section<Bank, BankDetail> getSection(String namaBank, int fotoBaank, String detailBank) {
        Section<Bank, BankDetail> section = new Section<>();
        Bank bank = new Bank(namaBank, fotoBaank);
        BankDetail detail = new BankDetail(detailBank);
        section.parent = bank;
        section.children.add(detail);
        return section;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == android.R.id.home){
            this.finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
