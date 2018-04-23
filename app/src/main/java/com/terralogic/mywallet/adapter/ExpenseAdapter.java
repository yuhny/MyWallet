package com.terralogic.mywallet.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.terralogic.mywallet.R;
import com.terralogic.mywallet.adapter.viewHolder.ItemViewHolder;
import com.terralogic.mywallet.database.MySQLite;
import com.terralogic.mywallet.model.Expense;
import com.terralogic.mywallet.model.GroupItem;
import com.terralogic.mywallet.model.Item;

import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private Context context;
    private List<Item> itemList;
    private MySQLite mySQLite;

    public ExpenseAdapter(Context context, List<Item> expenseList) {
        this.context = context;
        this.itemList = expenseList;
        mySQLite = new MySQLite(context);
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
        holder.getmImageCate().setImageDrawable(context.getResources().getDrawable(getImageCate(item.getmIdGroup())));
        if (item.getmType().getValues() == 0) {
            holder.getmMoney().setTextColor(Color.parseColor("#40E0D0"));
        } else {
            holder.getmMoney().setTextColor(Color.parseColor("#FF4081"));
        }
    }

    private int getImageCate(int idGroup) {
        List<GroupItem> groupItems = mySQLite.getListCategory();
        int result = 0;
        for (GroupItem groupItem : groupItems) {
            if (groupItem.getcIdGroup() == idGroup) {
                result = groupItem.getcImage();
            }
        }
        return result;
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

    public void removeItem(int position) {
        mySQLite.deleteItem(itemList.remove(position));
    }
}
