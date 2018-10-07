package com.illiyinmagang.miafandi.donaku.Fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.illiyinmagang.miafandi.donaku.R;
import com.illiyinmagang.miafandi.donaku.model.IkanJual;
import com.illiyinmagang.miafandi.donaku.model.Penjualan;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by user on 07/10/2018.
 */

public class DaftarPenjualanViewAdapter extends RecyclerView.Adapter<DaftarPenjualanViewAdapter.ViewHolder>{
    private List<Penjualan> penjualans;
    private Context context;

    public DaftarPenjualanViewAdapter(List<Penjualan> penjualans, Context context) {
        this.penjualans = penjualans;
        this.context = context;
    }

    @NonNull
    @Override
    public DaftarPenjualanViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_list_penjualan,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DaftarPenjualanViewAdapter.ViewHolder viewHolder, int i) {
        viewHolder.penjualan = penjualans.get(i);
        viewHolder.imageView.setImageResource(R.drawable.ic_profil);
        viewHolder.txtNama.setText(viewHolder.penjualan.getNama());
        viewHolder.txtPesanan.setText(viewHolder.penjualan.getPesanan());
        viewHolder.txtDeail.setText("Lihat Detail");
    }

    @Override
    public int getItemCount() {
        return penjualans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNama, txtPesanan,txtDeail;
        private ImageView imageView;
        private Penjualan penjualan;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNama = (TextView) itemView.findViewById(R.id.txt_nama);
            txtPesanan = (TextView) itemView.findViewById(R.id.txt_jenis_ikan);
            txtDeail = (TextView) itemView.findViewById(R.id.txt_detail);
            imageView = (ImageView) itemView.findViewById(R.id.img_orang);
        }
    }
}
