package com.terralogic.mywallet.adapter.viewHolder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.terralogic.mywallet.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    private ImageView mImageCate;
    private TextView mContextExpense;
    private TextView mDateCreate;
    private TextView mMoney;
    private LinearLayout mInside, mOutside;
    private ImageView mImgEdit, mImgDelete;
    private CardView mCardView;

    public ItemViewHolder(View itemView) {
        super(itemView);

        mImageCate = itemView.findViewById(R.id.imgCate);
        mContextExpense = itemView.findViewById(R.id.txtExpense);
        mDateCreate = itemView.findViewById(R.id.txtDate);
        mMoney = itemView.findViewById(R.id.txtMoney);
        mInside = itemView.findViewById(R.id.layoutInside);
        mOutside = itemView.findViewById(R.id.layoutOutside);
        mCardView = itemView.findViewById(R.id.cardView);
        mImgEdit = itemView.findViewById(R.id.imageEdit);
        mImgDelete = itemView.findViewById(R.id.imageDelete);
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

    public LinearLayout getmInside() {
        return mInside;
    }

    public LinearLayout getmOutside() {
        return mOutside;
    }

    public CardView getmCardView() {
        return mCardView;
    }

    public ImageView getmImgEdit() {
        return mImgEdit;
    }

    public ImageView getmImgDelete() {
        return mImgDelete;
    }
}
