package com.terralogic.mywallet.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.terralogic.mywallet.R;
import com.terralogic.mywallet.adapter.viewHolder.ItemViewHolder;
import com.terralogic.mywallet.model.Expense;
import com.terralogic.mywallet.model.Item;

import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private Context context;
    private List<Item> itemList;

    public ExpenseAdapter(Context context, List<Item> expenseList) {
        this.context = context;
        this.itemList = expenseList;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.item_expense, null);
        v.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        ItemViewHolder viewHolder = new ItemViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Item item = itemList.get(position);

        holder.getmContextExpense().setText(item.getmName());
        holder.getmDateCreate().setText(item.getmDate() + "");
        holder.getmMoney().setText(item.getmMoney() + ",000");
        holder.getmImageCate().setImageDrawable(context.getResources().getDrawable(R.drawable.icon_smile));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
}
