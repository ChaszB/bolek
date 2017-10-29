package com.pawel.projinternet;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by uczen on 2017-10-08.
 */

public class WeaderViuFolder extends RecyclerView.ViewHolder {
    private ImageView logo;
    private TextView city;
    private TextView date;
    private TextView temp;
    private TextView desc;

    private Context context;

    public WeaderViuFolder(View itemView, Context context) {
        super(itemView);
        this.context = context;

        logo = (ImageView) itemView.findViewById((R.id.logo));
        city = (TextView) itemView.findViewById(R.id.city_res);
        date = (TextView) itemView.findViewById(R.id.date_res);
        temp = (TextView) itemView.findViewById(R.id.temp_res);
        desc = (TextView) itemView.findViewById(R.id.group);

    }

    public void bindData (forecast f){
        city.setText(f.getCity());
        date.setText(f.getDate());
        temp.setText(f.getTemp()+"");
        desc.setText(f.getDesc());

        Glide.with(context)
                .load("http://openweathermap.org/img/w/"+f.getIcon()+".png")
                .into(logo);

    }
}
