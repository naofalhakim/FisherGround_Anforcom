package com.illiyinmagang.miafandi.donaku.Fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.illiyinmagang.miafandi.donaku.model.IkanJual;
import com.illiyinmagang.miafandi.donaku.R;

import java.util.List;

/**
 * Created by user on 02/10/2018.
 */

public class ListHargaViewAdapter extends RecyclerView.Adapter<ListHargaViewAdapter.ViewHolder> {

    private List<IkanJual> ikanJuals;
    private Context context;
    public ListHargaViewAdapter(List<IkanJual> ikanJuals, Context context) {
        this.ikanJuals = ikanJuals;
        this.context = context;
    }

    @NonNull
    @Override
    public ListHargaViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_ikanjual, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHargaViewAdapter.ViewHolder holder, int position) {
        holder.ikanJual = ikanJuals.get(position);
        if(holder.ikanJual.getImage() != 0){
            holder.imgIkan.setImageResource(holder.ikanJual.getImage());
        }else{
            holder.imgIkan.setImageResource(R.drawable.ikan1);
        }
        holder.txtNamaIkan.setText(holder.ikanJual.getNama());
        holder.txtHargaIkan.setText("Rp "+holder.ikanJual.getHarga()+" / kg");
        holder.txtQuota.setText("Jumlah Quota Tersisa : "+holder.ikanJual.getQuota()+" Kg");
    }

    @Override
    public int getItemCount() {
        return ikanJuals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgIkan, imgProceSign;
        TextView txtNamaIkan, txtHargaIkan, txtHargaNaik, txtQuota;
        IkanJual ikanJual;

        public ViewHolder(View itemView) {
            super(itemView);

            imgIkan = (ImageView) itemView.findViewById(R.id.img_ikan);
            imgProceSign = (ImageView) itemView.findViewById(R.id.img_sign_price);
            txtHargaIkan = (TextView) itemView.findViewById(R.id.txt_harga_ikan);
            txtNamaIkan = (TextView) itemView.findViewById(R.id.txt_nama_ikan);
            txtHargaNaik = (TextView) itemView.findViewById(R.id.txt_harganaik_ikan);
            txtQuota = (TextView) itemView.findViewById(R.id.txt_quota);

        }
    }
}
