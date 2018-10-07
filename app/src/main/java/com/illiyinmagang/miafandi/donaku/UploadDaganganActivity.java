package com.illiyinmagang.miafandi.donaku;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UploadDaganganActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbarMain;
    private Button btn_jualMasakan, btn_tambahGambar;
    private TextView txtNamaFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_dagangan);

        toolbarMain = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbarMain);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbarMain.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        txtNamaFoto = (TextView) findViewById(R.id.txtNamaFoto);
        btn_jualMasakan = (Button) findViewById(R.id.btnJualMasakan2);
        btn_tambahGambar = (Button) findViewById(R.id.btnTambahGambar);

        btn_jualMasakan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(UploadDaganganActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.upload_berhasil, null);

                Button btn_ok = (Button) mView.findViewById(R.id.btnOk);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                btn_ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                            Toast.makeText(InputMasakanActivity.this, "I", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                        finish();
                    }
                });
            }
        });

        btn_tambahGambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(gallery,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri selectedImage = data.getData();
        String s= getRealPathFromURI(selectedImage);
        String name = s.substring(s.lastIndexOf("/") + 1);
        txtNamaFoto.setText(name);
    }

    public String getRealPathFromURI(Uri contentUri) {

        String [] proj={MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery( contentUri,
                proj, // Which columns to return
                null, // WHERE clause; which rows to return (all rows)
                null, // WHERE clause selection arguments (none)
                null); // Order-by clause (ascending by name)
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }
}
