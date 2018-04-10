package com.terralogic.mywallet.fragment;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
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

import java.util.Date;
import java.util.Map;

public class WalletManageFragment extends Fragment {
    private CalendarView mCalendarView;
    //    private  mListView;
    private FloatingActionButton mFab;
    private AlertDialog.Builder mDialog;
    FragmentManager manager;
    FragmentTransaction transaction;
    private long day;
    private int month, year;
    private String text, result;

    public static Fragment newInstance() {
        WalletManageFragment wallet = new WalletManageFragment();
        return wallet;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_wallet_manager, container, false);

        mCalendarView = (CalendarView) view.findViewById(R.id.calendar);
        mFab = (FloatingActionButton) view.findViewById(R.id.fabBalance);

        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, final int i1, final int i2) {
//                month = i1;
//                Toast.makeText(view.getContext(), i2 + "", Toast.LENGTH_SHORT).show();
                manager = getFragmentManager();
                transaction = manager.beginTransaction();

                day = mCalendarView.getDate();
                Log.d("Hello", day + "");

                if (i2 == 12) {
                    transaction.replace(R.id.frameWallet, ListExpenseFragment.newInstance());
                    transaction.commit();
                } else {
                    transaction.replace(R.id.frameWallet, NodataFragment.newInstance());
                    transaction.commit();
                }
            }
        });

        text = DateUtil.getMonthFromLong(mCalendarView.getDate());
//        result = map.get(text);
//        Toast.makeText(getContext(), result, Toast.LENGTH_SHORT).show();

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Im ", Toast.LENGTH_SHORT).show();

//                mDialog = new AlertDialog.Builder(getContext());
//
//                View v = getLayoutInflater().inflate(R.layout.dialog_balance, null);
                BalanceDialog dialog = new BalanceDialog(getContext(), text);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setCancelable(true);
                dialog.show();
                dialog.getWindow().setLayout(450, 500);
            }
        });

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


}
