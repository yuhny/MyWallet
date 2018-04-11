package com.terralogic.mywallet.fragment;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import com.terralogic.mywallet.R;
import com.terralogic.mywallet.fragment.dialog.BalanceDialog;
import com.terralogic.mywallet.model.DateUtil;

public class WalletManageFragment extends Fragment {
    private CalendarView mCalendarView;
    //    private  mListView;
    private FloatingActionButton mFabBalance, mFabAddNew;
    private AlertDialog.Builder mDialog;
    //    FragmentManager manager;
//    FragmentTransaction transaction;
    private long day;
    private int month, year;
    private String text, result;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_wallet_manager, container, false);

        mCalendarView = (CalendarView) view.findViewById(R.id.calendar);
        mFabBalance = (FloatingActionButton) view.findViewById(R.id.fabBalance);
        mFabAddNew = (FloatingActionButton) view.findViewById(R.id.fabAddNew);

        clickCalendarView();
        clickBalance();
        clickAddNew();

        return view;
    }

    private void clickCalendarView() {
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, final int i1, final int i2) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                if (i2 == 12) {
                    transaction.replace(R.id.frameWallet, ListExpenseFragment.newInstance());
                    transaction.commit();
                } else {
                    transaction.replace(R.id.frameWallet, NodataFragment.newInstance());
                    transaction.commit();
                }
            }
        });
    }

    private void clickAddNew() {
        mFabAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                transaction.replace(R.id.frameManage, new AddNewFragment());
                transaction.commit();
            }
        });

    }

    private void clickBalance() {
        text = DateUtil.getMonthFromLong(mCalendarView.getDate());

        mFabBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BalanceDialog dialog = new BalanceDialog(getContext(), text);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setCancelable(true);
                dialog.show();
                dialog.getWindow().setLayout(450, 500);
            }
        });

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

}
