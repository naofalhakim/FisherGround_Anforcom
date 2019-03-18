package com.illiyinmagang.miafandi.donaku.Fragment;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.illiyinmagang.miafandi.donaku.ChatActivity;
import com.illiyinmagang.miafandi.donaku.R;
import com.illiyinmagang.miafandi.donaku.model.Conversation;

import java.util.ArrayList;

/**
 * Created by user on 02/10/2018.
 */

public class ConversationAdapter extends RecyclerView.Adapter<ConversationAdapter.ViewHolder> {

    private ArrayList<Conversation> conversations;
    private Context context;

    public ConversationAdapter(ArrayList<Conversation> conversations, Context context) {
        this.conversations = conversations;
        this.context = context;
    }

    @NonNull
    @Override
    public ConversationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_conversation, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ConversationAdapter.ViewHolder holder, int position) {
        holder.conversation = conversations.get(position);
        holder.txtTime.setText(holder.conversation.getTime());
        holder.txtNama.setText(holder.conversation.getName());
        holder.txtLastChat.setText(holder.conversation.getLastChat());
    }

    @Override
    public int getItemCount() {
        return conversations.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtNama, txtLastChat, txtTime;
        Conversation conversation;

        public ViewHolder(View itemView) {
            super(itemView);
            txtNama = (TextView) itemView.findViewById(R.id.txt_nama);
            txtLastChat = (TextView) itemView.findViewById(R.id.txt_text);
            txtTime = (TextView) itemView.findViewById(R.id.txt_time);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent i = new Intent(context, ChatActivity.class);
            i.putExtra("nama",txtNama.getText().toString());
            context.startActivity(i);
        }
    }
}
