package com.pawel.projinternet;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by uczen on 2017-10-08.
 */

public class Dekorator  extends RecyclerView.ItemDecoration {

    private final int verticalSpaceHeight;

    public Dekorator(int verticalSpaceHeight) {
        this.verticalSpaceHeight = verticalSpaceHeight;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                               RecyclerView.State state) {
        outRect.bottom = verticalSpaceHeight;
    }
}