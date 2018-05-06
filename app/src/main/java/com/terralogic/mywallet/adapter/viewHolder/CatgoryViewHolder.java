package com.terralogic.mywallet.adapter.viewHolder;

import android.graphics.Color;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.terralogic.mywallet.R;

import com.terralogic.mywallet.model.GroupItem;

import com.terralogic.mywallet.model.Utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CatgoryViewHolder {
    private ImageView imGroup;
    private TextView grTextView1;
    private TextView grTextView2;

    NumberFormat format = new DecimalFormat("#,###");//fixed format money

    public CatgoryViewHolder(View itemView) {

        imGroup = itemView.findViewById(R.id.imgGroup);
        grTextView1 = itemView.findViewById(R.id.textNameGroup);
        grTextView2 = itemView.findViewById(R.id.textMoney);

    }

    public void setDataForGroup(GroupItem groupItem) {
        String money;
        imGroup.setImageResource(groupItem.getcImage());
        grTextView1.setText(groupItem.getcName());
        if (Long.parseLong(groupItem.getcMoney()) < 0) {

            money = Utils.seperate(groupItem.getcMoney());
            grTextView2.setText(money);
            grTextView2.setText(format.format(Math.abs(Long.parseLong(money)))+ " VND");//fixed format money

            grTextView2.setTextColor(Color.argb(255, 217, 45, 104));
        } else if (Long.parseLong(groupItem.getcMoney()) > 0) {


            money = Utils.seperate(groupItem.getcMoney());
            grTextView2.setText(money);
            grTextView2.setText(format.format(Long.parseLong(money)) + " VND");//fixed format money

            grTextView2.setTextColor(Color.argb(255, 0, 255, 251));
        }


    }


}
