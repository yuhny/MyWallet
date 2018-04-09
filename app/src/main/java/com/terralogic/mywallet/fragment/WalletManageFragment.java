package com.terralogic.mywallet.fragment;


import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import com.terralogic.mywallet.R;

public class WalletManageFragment extends Fragment {
    private CalendarView mCalendarView;
    //    private  mListView;
    private FloatingActionButton mFab;
    private Dialog mDialog;

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
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                Toast.makeText(view.getContext(), i2 + "", Toast.LENGTH_SHORT).show();
                if (i2 == 12) {
                    FragmentManager manager = getFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();

                    transaction.replace(R.id.frameManage, ListExpenseFragment.newInstance());
                    transaction.commit();
                }
            }
        });

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDialog();
            }
        });

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void customDialog() {
        mDialog = new Dialog(this.getContext());
        mDialog.setContentView(R.layout.dialog_balance);
    }
}
