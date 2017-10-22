package com.pawel.pierwszal;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by uczen on 2017-10-01.
 */

class IntAdapter extends RecyclerView.Adapter<InViewHolder> {
    private List<Integer> data;
    private Context context;

    public IntAdapter(Context context, List data) {
        this.data = data;
        this.context = context;
    }

    @Override
    public InViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context)
                .inflate(R.layout.zad309,parent,false);

        return new InViewHolder(view);

    }

    @Override
    public void onBindViewHolder(InViewHolder holder, int position) {
        int dat = data.get(position);
        holder.bindata(dat);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
