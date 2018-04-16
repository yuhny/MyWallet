package com.terralogic.mywallet.adapter.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.terralogic.mywallet.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    private ImageView mImageCate;
    private TextView mContextExpense;
    private TextView mDateCreate;
    private TextView mMoney;

    public ItemViewHolder(View itemView) {
        super(itemView);

        mImageCate = (ImageView) itemView.findViewById(R.id.imgCate);
        mContextExpense = (TextView) itemView.findViewById(R.id.txtExpense);
        mDateCreate = (TextView) itemView.findViewById(R.id.txtDate);
        mMoney = (TextView) itemView.findViewById(R.id.txtMoney);
    }

    public ImageView getmImageCate() {
        return mImageCate;
    }

    public TextView getmContextExpense() {
        return mContextExpense;
    }

    public TextView getmDateCreate() {
        return mDateCreate;
    }

    public TextView getmMoney() {
        return mMoney;
    }
}
