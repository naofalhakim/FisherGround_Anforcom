package com.illiyinmagang.miafandi.donaku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.illiyinmagang.miafandi.donaku.model.Pesan;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button btnSend;
    private EditText etNamaBi;
    private List<Pesan> pesans;
    private Toolbar toolbar;
    private Date currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        currentTime = Calendar.getInstance().getTime();

        pesans = new ArrayList();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        btnSend = (Button) findViewById(R.id.btn_send);
        etNamaBi = (EditText) findViewById(R.id.et_pesan);

        recyclerView.setLayoutManager(new LinearLayoutManager(ChatActivity.this));
        recyclerView.setAdapter(new MyChatRecyclerViewAdapter(pesans,ChatActivity.this));

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNamaBi.setText("");
                pesans.add(new Pesan(1,etNamaBi.getText().toString(),currentTime.toString()));
                recyclerView.setAdapter(new MyChatRecyclerViewAdapter(pesans,ChatActivity.this));
            }
        });

    }
}
