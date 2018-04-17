package com.terralogic.mywallet.adapter.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.terralogic.mywallet.R;

/**
 * Created by trile on 4/16/2018.
 */

public class ItemDialogHolder extends RecyclerView.ViewHolder {
    private ImageView imgCate;
    private TextView txtCate;

    public ItemDialogHolder(View itemView) {
        super(itemView);

        imgCate = (ImageView) itemView.findViewById(R.id.imgDialogCate);
        txtCate = (TextView) itemView.findViewById(R.id.txtDialogCate);
    }

    public ImageView getImgCate() {
        return imgCate;
    }

    public TextView getTxtCate() {
        return txtCate;
    }
}
