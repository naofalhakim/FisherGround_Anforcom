package com.illiyinmagang.miafandi.donaku;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        String[] myNames = getResources().getStringArray(R.array.Konsumen);
        String[] myLastChat = getResources().getStringArray(R.array.MyLastChat);

        conversations = new ArrayList();
        for (int i = 0; i < 4; i++) {
            conversations.add(new Conversation(myNames[i], myLastChat[i], "00:00", R.drawable.ic_profile));
        }

        recyclerView = (RecyclerView) findViewById(R.id.listContact);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ConversationAdapter(conversations,ContactListActivity.this));
    }
}
