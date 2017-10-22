package com.pawel.pierwszal;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by uczen on 2017-10-01.
 */

public class InViewHolder extends RecyclerView.ViewHolder {
    private TextView text;


    public InViewHolder(View itemView) {
        super(itemView);
        text = (TextView) itemView.findViewById(R.id.text);

    }

    public void bindata(int i) {
        text.setText(i + " - element RecyclerView ");
    }
}
