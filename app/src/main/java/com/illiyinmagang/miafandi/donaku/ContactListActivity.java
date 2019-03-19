package com.illiyinmagang.miafandi.donaku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.illiyinmagang.miafandi.donaku.Fragment.ConversationAdapter;
import com.illiyinmagang.miafandi.donaku.model.Conversation;

import java.util.ArrayList;

public class ContactListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Conversation> conversations;
    private String[] myNames;
    String[] myLastChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        String user = getIntent().getStringExtra("chat");
        if(!user.equals("")){
             myNames = getResources().getStringArray(R.array.Penjual);
             myLastChat = getResources().getStringArray(R.array.KonsumenLastChat);

        }else{
            myNames = getResources().getStringArray(R.array.Konsumen);
            myLastChat = getResources().getStringArray(R.array.MyLastChat);
        }

        conversations = new ArrayList();
        for (int i = 0; i < 4; i++) {
            conversations.add(new Conversation(myNames[i], myLastChat[i], "00:00", R.drawable.ic_profile));
        }

        recyclerView = (RecyclerView) findViewById(R.id.listContact);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ConversationAdapter(conversations,ContactListActivity.this));
    }
}
