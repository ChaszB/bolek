package com.pawel.mplay;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.pawel.mplay.R;
import com.pawel.mplay.VideoPlay;

/**
 * Created by uczen on 2017-10-22.
 */

public class FileViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    private TextView path;
    private Context context;

    public FileViewHolder(Context context,View itemView) {
        super(itemView);
        this.context = context;
        path = (TextView) itemView.findViewById(R.id.file_path);
        itemView.setOnClickListener(this);

    }
    public void bindDate (String pathString){
        path.setText(pathString);
    }

    @Override
    public void onClick(View view) {
        Intent intent =new Intent(context, VideoPlay.class);
        intent.putExtra("video_to_play",path.getText().toString());
        context.startActivity(intent);
    }
}
