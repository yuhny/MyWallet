package com.terralogic.mywallet.fragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.terralogic.mywallet.R;
import com.terralogic.mywallet.activity.ManageActivity;

import java.util.Calendar;

/**
 * Created by trile on 4/10/2018.
 */

public class AddNewFragment extends Fragment {
    private TextView mTxtTitle, mTxtAddIncome, mTxtAddExpense, mTxtAddMoney, mTxtUnit;
    private LinearLayout mLayoutIncome, mLayoutExpense;
    private ImageView mImgAddDate;
    private EditText mEditAddDate;
    private boolean isIncome = true;
    private int day, month, year;

    @SuppressLint("ResourceAsColor")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_new, container, false);

        mTxtTitle = ((ManageActivity) getActivity()).findViewById(R.id.txtTitle);
        mTxtTitle.setText("Add New");

        mLayoutIncome = (LinearLayout) view.findViewById(R.id.layoutIncome);
        mLayoutExpense = (LinearLayout) view.findViewById(R.id.layoutExpense);

        mTxtAddIncome = (TextView) view.findViewById(R.id.txtAddIncome);
        mTxtAddExpense = (TextView) view.findViewById(R.id.txtAddExpense);
        mTxtAddMoney = (TextView) view.findViewById(R.id.txtAddMoney);
        mTxtUnit = (TextView) view.findViewById(R.id.txtUnit);

        mImgAddDate = (ImageView) view.findViewById(R.id.imgAddDate);

        mEditAddDate = (EditText) view.findViewById(R.id.editDate);

        mLayoutIncome.setBackgroundResource(R.drawable.background_income);
        mTxtAddIncome.setTextColor(Color.parseColor("#FFFFFF"));
        mTxtAddMoney.setTextColor(Color.parseColor("#40E0D0"));

        clickLayoutIncome();
        clickLayoutExpense();
        clickCalendarImage();

        return view;
    }

    private void clickCalendarImage() {
        Calendar mCalendar = Calendar.getInstance();

        day = mCalendar.get(Calendar.DAY_OF_MONTH);
        month = mCalendar.get(Calendar.MONTH);
        year = mCalendar.get(Calendar.YEAR);

        month = month + 1;

        mEditAddDate.setText(day + "-" + month + "-" + year);

        mImgAddDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month += 1;
                        mEditAddDate.setText(day + "-" + month + "-" + year);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
    }

    private void clickLayoutExpense() {
        mLayoutExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation a = AnimationUtils.loadAnimation(getContext(), R.anim.anim_moveleft);
                isIncome = false;
                mLayoutExpense.setBackgroundResource(R.drawable.background_expense);
                mLayoutExpense.startAnimation(a);
                mLayoutIncome.setBackgroundResource(R.drawable.background_null);
                mTxtAddExpense.setTextColor(Color.parseColor("#FFFFFF"));
                mTxtAddIncome.setTextColor(Color.parseColor("#000000"));
                switchColorMoney();
            }
        });
    }

    private void clickLayoutIncome() {
        mLayoutIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation a = AnimationUtils.loadAnimation(getContext(), R.anim.anim_moveright);
                isIncome = true;
                mLayoutIncome.setBackgroundResource(R.drawable.background_income);
                mLayoutIncome.startAnimation(a);
                mLayoutExpense.setBackgroundResource(R.drawable.background_null);
                mTxtAddIncome.setTextColor(Color.parseColor("#FFFFFF"));
                mTxtAddExpense.setTextColor(Color.parseColor("#000000"));
                switchColorMoney();

            }
        });
    }

    private void switchColorMoney() {
        if (isIncome) {
            mTxtAddMoney.setTextColor(Color.parseColor("#40E0D0"));
            mTxtUnit.setTextColor(Color.parseColor("#40E0D0"));
        }
        if (!isIncome) {
            mTxtAddMoney.setTextColor(Color.parseColor("#FF4081"));
            mTxtUnit.setTextColor(Color.parseColor("#FF4081"));
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
