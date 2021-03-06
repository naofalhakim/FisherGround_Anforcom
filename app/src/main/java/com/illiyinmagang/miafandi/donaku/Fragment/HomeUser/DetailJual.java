package com.illiyinmagang.miafandi.donaku.Fragment.HomeUser;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.illiyinmagang.miafandi.donaku.ChatActivity;
import com.illiyinmagang.miafandi.donaku.R;

public class DetailJual extends AppCompatActivity {
    public ImageView fishPict;
    public TextView fishName, add, count, minus,kurirTersedia, txtTotalIkan, txtOngkir, txtTotalBayar;
    public TextView fishPrice;
    public TextView fishStock;
    private ImageView btnMessage;
    private Button btnPesan;
    private RelativeLayout kurir;
    int jumlah = 1;
    int c = 0;
    int tot = 0;
    int ongkosKirim=0;
    RadioButton rb1,rb2,rb3,rb4;
    int checkedRadioButton = 0;
    String kurirDipilih,a1,a2,a3;

    private RadioGroup.OnCheckedChangeListener checkedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.rb1:
                    checkedRadioButton = 1;
                    break;
                case R.id.rb2:
                    checkedRadioButton = 2;
                    break;
                case R.id.rb3:
                    checkedRadioButton = 3;
                    break;
                case R.id.rb4:
                    checkedRadioButton = 4;
                    break;
            }
        }
    };
    private String getOption(){
        if(checkedRadioButton == 1){
            return "Cargo Kereta Api";
        }else if(checkedRadioButton == 2){
            return "Ekspedisi";
        }else if(checkedRadioButton == 3){
            return "Dikirim Nelayan";
        }else if(checkedRadioButton == 4){
            return "Ambil Sendiri";
        }else
            return "Option salah";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_jual_ikan);

        //back botton
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fishPict = (ImageView) findViewById(R.id.imageDetailIkan);
        fishName = (TextView) findViewById(R.id.txtDetailNama);
        fishPrice = (TextView) findViewById(R.id.detailHarga);
        fishStock = (TextView) findViewById(R.id.stock);
        btnMessage = (ImageView) findViewById(R.id.btnMessage);
        btnPesan = (Button) findViewById(R.id.btnBeli);
        txtTotalIkan = (TextView) findViewById(R.id.txtHargaIkan);
        txtOngkir = (TextView) findViewById(R.id.txtOngkos);
        txtTotalBayar = (TextView) findViewById(R.id.txtTotalBiaya);

        final Intent i = getIntent();
        final String nama = i.getStringExtra("namaIkan");
        final int gambar = i.getIntExtra("gambarIkan",0);
        final String harga = i.getStringExtra("hargaIkan");
        final String stock = i.getStringExtra("stockIkan");
        c = Integer.parseInt(harga)*1000;
        ongkosKirim = 0;
        a3 = Integer.toString(ongkosKirim);

        fishPict.setImageResource(gambar);
        fishName.setText(nama);
        fishStock.setText(stock);
        fishPrice.setText(Integer.toString(c));

        tot = c * jumlah;
        txtTotalIkan.setText(Integer.toString(tot));
        txtOngkir.setText(Integer.toString(ongkosKirim));
        txtTotalBayar.setText(Integer.toString(tot+ongkosKirim));

//        txtTotalBayar.setText(Integer.toString(c));
//        txtOngkir.setText(Integer.toString(ongkosKirim));
//        txtTotalBayar.setText(Integer.toString(c+ongkosKirim));

        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetailJual.this,ChatActivity.class));
            }
        });

        add = (TextView) findViewById(R.id.increment);
        count = (TextView) findViewById(R.id.count);
        minus = (TextView) findViewById(R.id.decrement);
        a1 = Integer.toString(tot*jumlah);
        a2 = Integer.toString(Integer.parseInt(harga)+ongkosKirim);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jumlah++;
                count.setText(String.valueOf(jumlah));
                txtTotalIkan.setText(Integer.toString(tot*jumlah));
                txtTotalBayar.setText(Integer.toString((tot*jumlah)+ongkosKirim));
                a1 = Integer.toString(tot*jumlah);
                a2 = Integer.toString((tot*jumlah)+ongkosKirim);
//                pesanTotalHarga.setText(String.valueOf(jumlah*hargaAsli));
//                pesanTotal.setText(String.valueOf(((jumlah*hargaAsli))+kirim));
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(jumlah>1) {
                    jumlah--;
                    count.setText(String.valueOf(jumlah));
                }
                txtTotalIkan.setText(Integer.toString(tot*jumlah));
                txtTotalBayar.setText(Integer.toString((tot*jumlah)+ongkosKirim));
                a1 = Integer.toString(tot*jumlah);
                a2 = Integer.toString((tot*jumlah)+ongkosKirim);
//                pesanTotalHarga.setText(String.valueOf(jumlah*hargaAsli));
//                pesanTotal.setText(String.valueOf(((jumlah*hargaAsli))+kirim));
            }
        });
        kurirTersedia = (TextView) findViewById(R.id.kurirTersedia);
        kurirTersedia.setText("Pilih Metode Pengiriman");

        kurir = (RelativeLayout) findViewById(R.id.kurir);
        kurir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(DetailJual.this);
                final View mView = getLayoutInflater().inflate(R.layout.activity_dialog_kurir, null);

                rb1 = (RadioButton) mView.findViewById(R.id.rb1);
                rb2 = (RadioButton) mView.findViewById(R.id.rb2);
                rb3 = (RadioButton) mView.findViewById(R.id.rb3);
                rb4 = (RadioButton) mView.findViewById(R.id.rb4);
                RadioGroup radioGroup = (RadioGroup) mView.findViewById(R.id.radioGroup);

                Button pilih = (Button)mView.findViewById(R.id.pilih);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();
                radioGroup.setOnCheckedChangeListener(checkedChangeListener);
                pilih.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (getOption().equals("Ambil Sendiri")){
                            ongkosKirim = 0;
                        }else if (getOption().equals("Dikirim Nelayan")){
                            ongkosKirim = 30000;
                        }else{
                            ongkosKirim = 50000;
                        }
                        kurirDipilih = getOption();
                        kurirTersedia.setText(kurirDipilih);
                        txtOngkir.setText(Integer.toString(ongkosKirim));
                        txtTotalIkan.setText(Integer.toString(tot*jumlah));
                        txtTotalBayar.setText(Integer.toString((tot*jumlah)+ongkosKirim));
                        a2 = Integer.toString((tot*jumlah)+ongkosKirim);
                        a3 = Integer.toString(ongkosKirim);
                        dialog.dismiss();
                    }
                });
            }
        });
        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailJual.this,BayarActivity.class);
                intent.putExtra("hargaIkan",a1);
                intent.putExtra("hargaPos",a3);
                intent.putExtra("hargaTotal",a2);
                startActivity(intent);
            }
        });
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
