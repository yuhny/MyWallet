package com.terralogic.mywallet.fragment;

import android.graphics.Canvas;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.terralogic.mywallet.R;
import com.terralogic.mywallet.adapter.ExpenseAdapter;
import com.terralogic.mywallet.adapter.viewHolder.ItemViewHolder;
import com.terralogic.mywallet.database.MySQLite;
import com.terralogic.mywallet.model.Item;

import java.util.List;

public class ListExpenseFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Item> items;
    private ExpenseAdapter adapter;
    private String date;
    private MySQLite mySQLite;

    public ListExpenseFragment() {
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_expense, container, false);

        view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.MATCH_PARENT));

        recyclerView = (RecyclerView) view.findViewById(R.id.listExpenses);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));

        adapter = new ExpenseAdapter(this.getContext(), items);

        mySQLite = new MySQLite(getContext());
        recyclerView.setAdapter(adapter);

        return view;
    }

    private void addFragmentBackStack(Fragment fragment) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.setCustomAnimations(R.anim.anim_in_right, R.anim.anim_out_left, R.anim.anim_in_left, R.anim.anim_to_right);
        transaction.replace(R.id.frameManage, fragment);
        transaction.addToBackStack(fragment.getClass().getSimpleName());
        transaction.commit();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
