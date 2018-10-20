package com.illiyinmagang.miafandi.donaku.Fragment.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.illiyinmagang.miafandi.donaku.Fragment.HomeUser.DetailJual;
import com.illiyinmagang.miafandi.donaku.Fragment.Investasi.DetailInvestasi;
import com.illiyinmagang.miafandi.donaku.R;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class InvestasiAdapter extends RecyclerView.Adapter<InvestasiAdapter.ViewHolder>  {
    private Context context;
    List<InvestasiUser> listInvestasi;

    public InvestasiAdapter(Context context) {
//        super();
        this.context = context;
        listInvestasi = new ArrayList<InvestasiUser>();
        listInvestasi.add(new InvestasiUser(R.drawable.iv2,"Peremajaan Kapal","Rudi Habibi","Banyuwangi",1,10,3000000));
        listInvestasi.add(new InvestasiUser(R.drawable.iv1,"Keramba Tuna","Bambang Hendrawan","Pengandaran",0,15,7500000));
        listInvestasi.add(new InvestasiUser(R.drawable.investtambak,"Tambak Udang","Irwan Suwardi","Bodowoso",1,20,20000000));
        listInvestasi.add(new InvestasiUser(R.drawable.unvestkapal,"Pembuatan Kapal 10GT","Naofal Perdana","Sendang Biru",0,12,8000000));
        listInvestasi.add(new InvestasiUser(R.drawable.iv2,"Peremajaan Kapal","Rudi Habibi","Banyuwangi",1,10,3000000));
        listInvestasi.add(new InvestasiUser(R.drawable.iv1,"Keramba Tuna","Bambang Hendrawan","Pengandaran",0,15,7500000));
        listInvestasi.add(new InvestasiUser(R.drawable.investtambak,"Tambak Udang","Irwan Suwardi","Bodowoso",1,20,20000000));
        listInvestasi.add(new InvestasiUser(R.drawable.unvestkapal,"Pembuatan Kapal 10GT","Naofal Perdana","Sendang Biru",0,12,8000000));
    }

    @Override
    public InvestasiAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.investasiview, viewGroup, false);
        InvestasiAdapter.ViewHolder viewHolder = new InvestasiAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(InvestasiAdapter.ViewHolder viewHolder, int i) {
        InvestasiUser investasi = listInvestasi.get(i);

        viewHolder.imgI.setImageResource(investasi.getImgInvestasi());
        viewHolder.judulI.setText(investasi.getNamaInvestasi());
        viewHolder.pembuatI.setText(investasi.getPembuatInvestasi());
        viewHolder.tempatI.setText(investasi.getLokasiInvestasi());
        viewHolder.donaturI.setText(Integer.toString(investasi.getDonaturInvestasi()));
        viewHolder.roiI.setText(Integer.toString(investasi.getRoiInvestasi()));
        viewHolder.biayaI.setText(Integer.toString(investasi.getBiayaInvestasi()));
    }

    @Override
    public int getItemCount() {
        return listInvestasi.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imgI;
        public TextView judulI;
        public TextView pembuatI;
        public TextView tempatI;
        public TextView donaturI;
        public TextView roiI;
        public TextView biayaI;

        public ViewHolder(View itemView) {
            super(itemView);
            imgI = (ImageView) itemView.findViewById(R.id.imgInvestasi);
            judulI = (TextView) itemView.findViewById(R.id.txtJudul);
            pembuatI = (TextView) itemView.findViewById(R.id.txtPencariDana);
            tempatI = (TextView) itemView.findViewById(R.id.txtTempat);
            donaturI = (TextView) itemView.findViewById(R.id.txtdonatur);
            roiI = (TextView) itemView.findViewById(R.id.txtBesarRoi);
            biayaI = (TextView) itemView.findViewById(R.id.txtInvestasi);

            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            InvestasiUser invest = listInvestasi.get(position);
            Intent intent = new Intent(context, DetailInvestasi.class);
            intent.putExtra("gambarInvest",invest.getImgInvestasi());
            intent.putExtra("judulInvest", invest.getNamaInvestasi());
            intent.putExtra("pembuatInvest",invest.getPembuatInvestasi());
            intent.putExtra("tempatInvest",invest.getLokasiInvestasi());
            intent.putExtra("donaturInvest",invest.getDonaturInvestasi());
            intent.putExtra("roiInvest",invest.getRoiInvestasi());
            intent.putExtra("biayaInvest",invest.getBiayaInvestasi());
            context.startActivity(intent);
        }
    }
}
