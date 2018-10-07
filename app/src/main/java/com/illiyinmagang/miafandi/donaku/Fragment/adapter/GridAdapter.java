package com.illiyinmagang.miafandi.donaku.Fragment.adapter;

/**
 * Created by MIAfandi on 28/08/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.illiyinmagang.miafandi.donaku.Fragment.HomeUser.DetailJual;
import com.illiyinmagang.miafandi.donaku.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ujang Wahyu on 24/01/2017.
 */

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {
    private Context context;
    List<DaftarIkan> listIkan;

    public GridAdapter(Context context) {
//        super();
        this.context = context;
        listIkan = new ArrayList<DaftarIkan>();
        listIkan.add(new DaftarIkan("Ikan Tongkol",R.drawable.itongkol,20,100));
        listIkan.add(new DaftarIkan("Cumi-Cumi",R.drawable.icumi,45,250));
        listIkan.add(new DaftarIkan("Gurita",R.drawable.igurita,35,300));
        listIkan.add(new DaftarIkan("Kakap Merah",R.drawable.ikakap,60,150));
        listIkan.add(new DaftarIkan("Ikan Kembung",R.drawable.ikembung,25,1000));
        listIkan.add(new DaftarIkan("Kepiting",R.drawable.ikepiting,55,500));
        listIkan.add(new DaftarIkan("Kerang",R.drawable.ikerang,15,1500));
        listIkan.add(new DaftarIkan("Patin",R.drawable.ipatin,35,700));
        listIkan.add(new DaftarIkan("Udang",R.drawable.iudang,35,2500));
        listIkan.add(new DaftarIkan("Gurami",R.drawable.igurame,45,700));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        DaftarIkan ikan = listIkan.get(i);
        viewHolder.fishName.setText(ikan.getNamaIkan());
        viewHolder.fishPict.setImageResource(ikan.getImgIkan());
        viewHolder.fishPrice.setText(Integer.toString(ikan.getHargaIkan()));
    }

    @Override
    public int getItemCount() {
        return listIkan.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView fishPict;
        public TextView fishName;
        public TextView fishPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            fishPict = (ImageView) itemView.findViewById(R.id.imgIkan);
            fishName = (TextView) itemView.findViewById(R.id.txtNamaIkan);
            fishPrice = (TextView) itemView.findViewById(R.id.txtHargaIkan);

            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            DaftarIkan ikanKu = listIkan.get(position);
            Intent intent = new Intent(context, DetailJual.class);
            intent.putExtra("namaIkan", ikanKu.getNamaIkan());
            intent.putExtra("gambarIkan",ikanKu.getImgIkan());
            intent.putExtra("hargaIkan",Integer.toString(ikanKu.getHargaIkan()));
            intent.putExtra("stockIkan",Integer.toString(ikanKu.getStock()));
            context.startActivity(intent);
        }
    }
}
