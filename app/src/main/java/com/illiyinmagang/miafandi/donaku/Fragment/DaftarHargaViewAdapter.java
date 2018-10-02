package com.illiyinmagang.miafandi.donaku.Fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.illiyinmagang.miafandi.donaku.IkanJual;
import com.illiyinmagang.miafandi.donaku.R;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by user on 02/10/2018.
 */

public class DaftarHargaViewAdapter extends RecyclerView.Adapter<DaftarHargaViewAdapter.ViewHolder> {

    private List<IkanJual> ikanJuals;
    private Context context;
    public DaftarHargaViewAdapter(List<IkanJual> ikanJuals, Context context) {
        this.ikanJuals = ikanJuals;
        this.context = context;
    }

    @NonNull
    @Override
    public DaftarHargaViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_ikanjual, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DaftarHargaViewAdapter.ViewHolder holder, int position) {
        holder.ikanJual = ikanJuals.get(position);
        holder.txtNamaIkan.setText(holder.ikanJual.getNama());
        holder.txtHargaIkan.setText("Rp "+holder.ikanJual.getHarga()+" / kg");
        if(holder.ikanJual.getHarga() < holder.ikanJual.getHargasblm()){
            holder.txtHargaNaik.setText("Harga Turun Rp "+(holder.ikanJual.getHargasblm() - holder.ikanJual.getHarga())+ "/ kg");
            holder.imgProceSign.setImageResource(R.drawable.ic_pricing_down);
        }else{
            holder.txtHargaNaik.setText("Harga Naik Rp "+(holder.ikanJual.getHarga() - holder.ikanJual.getHargasblm())+ "/ kg");
            holder.imgProceSign.setImageResource(R.drawable.ic_pricing_up);
        }

    }

    @Override
    public int getItemCount() {
        return ikanJuals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgIkan, imgProceSign;
        TextView txtNamaIkan, txtHargaIkan, txtHargaNaik;
        IkanJual ikanJual;

        public ViewHolder(View itemView) {
            super(itemView);

            imgIkan = (ImageView) itemView.findViewById(R.id.img_ikan);
            imgProceSign = (ImageView) itemView.findViewById(R.id.img_sign_price);
            txtHargaIkan = (TextView) itemView.findViewById(R.id.txt_harga_ikan);
            txtNamaIkan = (TextView) itemView.findViewById(R.id.txt_nama_ikan);
            txtHargaNaik = (TextView) itemView.findViewById(R.id.txt_harganaik_ikan);

        }
    }
}
