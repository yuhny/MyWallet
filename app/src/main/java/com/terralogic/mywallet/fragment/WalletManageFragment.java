package com.terralogic.mywallet.fragment;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.terralogic.mywallet.R;
import com.terralogic.mywallet.fragment.dialog.BalanceDialog;
import com.terralogic.mywallet.model.DateUtil;

public class WalletManageFragment extends Fragment {
    private CalendarView mCalendarView;
    private FloatingActionButton mFabAddNew;
    private ImageView mImgBalance;
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
//        mFabBalance = (FloatingActionButton) view.findViewById(R.id.fabBalance);
        mFabAddNew = (FloatingActionButton) view.findViewById(R.id.fabAddNew);

        mImgBalance = (ImageView) view.findViewById(R.id.imgBalance);

        clickCalendarView();
        clickBalance();
        clickAddNew();

        return view;
    }

    private void clickCalendarView() {
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, final int i1, final int i2) {
                if (i2 == 12) {
                    addFragment(new ListExpenseFragment());
                } else {
                    addFragment(new NodataFragment());
                }
            }
        });
    }

    private void clickAddNew() {
        mFabAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFragmentBackStack(new AddNewFragment());
            }
        });

    }

    private void clickBalance() {
        text = DateUtil.getMonthFromLong(mCalendarView.getDate());

        mImgBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BalanceDialog dialog = new BalanceDialog(getContext(), text);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setCancelable(true);
                dialog.getWindow().setGravity(Gravity.CENTER);
                dialog.show();
                dialog.getWindow().setLayout(480, Toolbar.LayoutParams.WRAP_CONTENT);
            }
        });

    }

    private void addFragmentBackStack(Fragment fragment) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.setCustomAnimations(R.anim.anim_in_right, R.anim.anim_out_left, R.anim.anim_in_left, R.anim.anim_out_right);
        transaction.replace(R.id.frameManage, fragment);
        transaction.addToBackStack(fragment.getClass().getSimpleName());
        transaction.commit();
    }

    private void addFragment(Fragment fragment) {
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.replace(R.id.frameWallet, fragment);
        transaction.commit();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
