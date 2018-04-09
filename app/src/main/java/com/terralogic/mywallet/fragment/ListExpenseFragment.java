package com.terralogic.mywallet.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.terralogic.mywallet.R;
import com.terralogic.mywallet.adapter.ExpenseAdapter;
import com.terralogic.mywallet.model.Expense;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ListExpenseFragment extends Fragment {
    RecyclerView recyclerView;
    List<Expense> expenseList;
    ExpenseAdapter adapter;

    public static ListExpenseFragment newInstance() {
        ListExpenseFragment fragment = new ListExpenseFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_expense, container, false);

        expenseList = new ArrayList<>();

        recyclerView = (RecyclerView) view.findViewById(R.id.listExpenses);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        expenseList.add(new Expense("Em chưa 18+", new Timestamp(System.currentTimeMillis()), 250000, R.drawable.icon_smile));
        expenseList.add(new Expense("Em chưa 19+", new Timestamp(System.currentTimeMillis()), 250000, R.drawable.icon_smile));
        expenseList.add(new Expense("Em chưa 20+", new Timestamp(System.currentTimeMillis()), 250000, R.drawable.icon_smile));
        expenseList.add(new Expense("Em chưa 21+", new Timestamp(System.currentTimeMillis()), 250000, R.drawable.icon_smile));
        expenseList.add(new Expense("Em chưa 22+", new Timestamp(System.currentTimeMillis()), 250000, R.drawable.icon_smile));
        expenseList.add(new Expense("Em chưa 23+", new Timestamp(System.currentTimeMillis()), 250000, R.drawable.icon_smile));
        expenseList.add(new Expense("Em chưa 24+", new Timestamp(System.currentTimeMillis()), 250000, R.drawable.icon_smile));

        adapter = new ExpenseAdapter(this.getContext(), expenseList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
