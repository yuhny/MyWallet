package com.terralogic.mywallet.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.terralogic.mywallet.R;
import com.terralogic.mywallet.adapter.viewHolder.ItemViewHolder;
import com.terralogic.mywallet.model.Expense;

import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private Context context;
    private List<Expense> expenseList;

    public ExpenseAdapter(Context context, List<Expense> expenseList) {
        this.context = context;
        this.expenseList = expenseList;
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
        Expense expense = expenseList.get(position);

        holder.getmContextExpense().setText(expense.getContext());
        holder.getmDateCreate().setText(expense.getTimestamp() + "");
        holder.getmMoney().setText(expense.getTotalMoney() + "");
        holder.getmImageCate().setImageDrawable(context.getResources().getDrawable(expense.getImage()));
    }

    @Override
    public int getItemCount() {
        return expenseList.size();
    }
}
