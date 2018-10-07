package com.illiyinmagang.miafandi.donaku;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.illiyinmagang.miafandi.donaku.model.Pesan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 07/10/2018.
 */

public class MyChatRecyclerViewAdapter extends RecyclerView.Adapter<MyChatRecyclerViewAdapter.ViewHolder> {

    private final List<Pesan> mValues;
    private Context context;

    public MyChatRecyclerViewAdapter(List<Pesan> items, Context context) {
        this.mValues = items;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item_pesan, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(holder.mItem.getMsg());
        holder.mContenTime.setText(holder.mItem.getTime());

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    private String getDateNow() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = mdformat.format(calendar.getTime());
        return strDate;
    }

    private Date convertStringToDate(String date){
        SimpleDateFormat mdformat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return mdformat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContentView;
        public final TextView mContenTime;
        public Pesan mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mContentView = (TextView) view.findViewById(R.id.txt_content);
            mContenTime = (TextView) view.findViewById(R.id.txt_time);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
