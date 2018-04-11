package com.terralogic.mywallet.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.terralogic.mywallet.R;
import com.terralogic.mywallet.activity.ManageActivity;

/**
 * Created by trile on 4/10/2018.
 */

public class AddNewFragment extends Fragment {
    TextView txtTitle;
    LinearLayout layoutIncome, layoutExpense;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_new, container, false);
//
//        ManageActivity manageActivity = new ManageActivity();
//        manageActivity.setTitle("AddNew");
//        manageActivity.onCreate(savedInstanceState);
        txtTitle = ((ManageActivity) getActivity()).findViewById(R.id.txtTitle);
        txtTitle.setText("Add New");

        layoutIncome = (LinearLayout) view.findViewById(R.id.layoutIncome);
        layoutExpense = (LinearLayout) view.findViewById(R.id.layoutExpense);

        layoutIncome.setBackgroundResource(R.drawable.background_income);
        layoutIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutIncome.setBackgroundResource(R.drawable.background_income);
                layoutExpense.setBackgroundResource(R.drawable.background_null);
            }
        });
        layoutExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutExpense.setBackgroundResource(R.drawable.background_expense);
                layoutIncome.setBackgroundResource(R.drawable.background_null);
            }
        });

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
