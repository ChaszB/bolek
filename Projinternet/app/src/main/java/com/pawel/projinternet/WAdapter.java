package com.pawel.projinternet;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by uczen on 2017-10-08.
 */

public class WAdapter extends RecyclerView.Adapter<WeaderViuFolder> {
    private Context context;
    private List<forecast> forecasts;

    public WAdapter(Context context, List forecasts){
        this.context = context;
        this.forecasts = forecasts;

    }

    @Override
    public WeaderViuFolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viev = LayoutInflater.from(context)
                .inflate(R.layout.nowe, parent, false);

        return new WeaderViuFolder(viev, context);

    }

    @Override
    public void onBindViewHolder(WeaderViuFolder holder, int position) {
        holder.bindData(forecasts.get(position));

    }

    @Override
    public int getItemCount() {
        return forecasts.size();
    }

    public void podmienListe(List<forecast> list){
        forecasts.clear();
        for (int i=0; i< list.size();i++){
            forecasts.add(list.get(i));
            notifyItemInserted(forecasts.size()-1);
        }
    }

}
