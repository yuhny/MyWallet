package com.terralogic.mywallet.adapter.viewHolder;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.terralogic.mywallet.R;
import com.terralogic.mywallet.model.DateUtil;
import com.terralogic.mywallet.model.Item;
import com.terralogic.mywallet.model.ItemType;
import com.terralogic.mywallet.model.Utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class ChildViewHolder {
    private TextView textViewNameChild;
    private TextView textViewDateChild;
    private TextView textViewMoneyChild;

    public ChildViewHolder(View itemView) {


        textViewNameChild = itemView.findViewById(R.id.textNameItem);
        textViewDateChild = itemView.findViewById(R.id.textDate);
        textViewMoneyChild = itemView.findViewById(R.id.textMoneyItem);
    }


    public void setDataForItem(Item item) {
        String money;
        textViewNameChild.setText(item.getmName());
        textViewDateChild.setText(DateUtil.getDateStringFromDataObject(item.getmDate()));
        if (item.getmType() == ItemType.CONSUM) {


            money = Utils.seperate(item.getmMoney());
            textViewMoneyChild.setText(money);
            textViewMoneyChild.setText(Utils.parseToCash(Long.parseLong(money)) + " VND");//fixed format money

            textViewMoneyChild.setTextColor(Color.argb(255, 217, 45, 104)
            );

        } else if (item.getmType() == ItemType.INCOME) {

            money = Utils.seperate(item.getmMoney());
            textViewMoneyChild.setText(money);
            textViewMoneyChild.setText(Utils.parseToCash(Long.parseLong(money)) + " VND");//fixed format money


        }


    }
}