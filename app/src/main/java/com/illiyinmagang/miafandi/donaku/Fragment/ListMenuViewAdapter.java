package com.illiyinmagang.miafandi.donaku.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.illiyinmagang.miafandi.donaku.LoginActivity;
import com.illiyinmagang.miafandi.donaku.ProfileActivity;
import com.illiyinmagang.miafandi.donaku.R;
import com.illiyinmagang.miafandi.donaku.model.IkanJual;

import java.util.List;

/**
 * Created by user on 02/10/2018.
 */

public class ListMenuViewAdapter extends RecyclerView.Adapter<ListMenuViewAdapter.ViewHolder> {

    private List<String> stringList;
    private Context context;
    private int icon[] = {R.drawable.ic_profil,R.drawable.ic_question,R.drawable.ic_seru,R.drawable.ic_seru,R.drawable.ic_shut};

    public ListMenuViewAdapter(List<String> ikanJuals, Context context) {
        this.stringList = ikanJuals;
        this.context = context;
    }

    @NonNull
    @Override
    public ListMenuViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_profile, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListMenuViewAdapter.ViewHolder holder, int position) {
        holder.ikanJual = stringList.get(position);
        holder.txtNamaIkan.setText(holder.ikanJual);
        holder.imgProfil.setImageResource(icon[position]);
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView txtNamaIkan;
        ImageView imgProfil;
        String ikanJual;

        public ViewHolder(View itemView) {
            super(itemView);
            txtNamaIkan = (TextView) itemView.findViewById(R.id.txt_nama);
            imgProfil = (ImageView) itemView.findViewById(R.id.img_icon);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(txtNamaIkan.getText().toString().equals("Profil Saya")){
                context.startActivity(new Intent(context, ProfileActivity.class));
            }else if(txtNamaIkan.getText().toString().equals("Bantuan")){
                Toast.makeText(context,"2",Toast.LENGTH_SHORT).show();
            }else if(txtNamaIkan.getText().toString().equals("Kebijakan Privasi")){
                Toast.makeText(context,"3",Toast.LENGTH_SHORT).show();
            }else if(txtNamaIkan.getText().toString().equals("Tentang")){
                Toast.makeText(context,"4",Toast.LENGTH_SHORT).show();
            }else if(txtNamaIkan.getText().toString().equals("Keluar Aplikasi")){
                Activity activity = (Activity) context;
                activity.finish();
                activity.startActivity(new Intent(context, LoginActivity.class));
            }
        }
    }
}
