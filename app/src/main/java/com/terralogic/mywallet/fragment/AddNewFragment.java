package com.terralogic.mywallet.fragment;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.terralogic.mywallet.R;
import com.terralogic.mywallet.activity.ManageActivity;
import com.terralogic.mywallet.adapter.CategoryAdapter;
import com.terralogic.mywallet.model.Category;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by trile on 4/10/2018.
 */

public class AddNewFragment extends Fragment implements View.OnClickListener {
    private TextView mTxtTitle, mTxtAddIncome, mTxtAddExpense, mTxtAddMoney, mTxtUnit;
    private LinearLayout mLayoutIncome, mLayoutExpense;
    private ImageView mImgAddDate, mImgAddCate;
    private EditText mEditAddDate, mEditAddNote;
    private Spinner mSpinnerCate;
    private List<Category> mListCate;
    private CategoryAdapter adapter;
    private boolean isIncome = true;
    private int day, month, year;
    private Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;
    private Button btnOkay;
    private ImageButton btnDel;
    private String resultMoney = "0";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_new, container, false);

        initToolbar();

        initContent(view);
        initButtons(view);

        clickLayoutIncome();
        clickLayoutExpense();
        clickCalendarImage();

        initListCate();
//
//        mImgAddCate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
        adapter = new CategoryAdapter(getContext(), mListCate);
        mSpinnerCate.setAdapter(adapter);

        return view;
    }

    private void initButtons(View view) {
        btnZero = view.findViewById(R.id.buttonZero);
        btnZero.setOnClickListener(this);

        btnOne = view.findViewById(R.id.btnOne);
        btnOne.setOnClickListener(this);

        btnTwo = view.findViewById(R.id.btnTwo);
        btnTwo.setOnClickListener(this);

        btnThree = view.findViewById(R.id.btnThree);
        btnThree.setOnClickListener(this);

        btnFour = view.findViewById(R.id.btnFour);
        btnFour.setOnClickListener(this);

        btnFive = view.findViewById(R.id.btnFive);
        btnFive.setOnClickListener(this);

        btnSix = view.findViewById(R.id.btnSix);
        btnSix.setOnClickListener(this);

        btnSeven = view.findViewById(R.id.btnSeven);
        btnSeven.setOnClickListener(this);

        btnEight = view.findViewById(R.id.btnEight);
        btnEight.setOnClickListener(this);

        btnNine = view.findViewById(R.id.btnNine);
        btnNine.setOnClickListener(this);

        btnDel = view.findViewById(R.id.btnDelete);
        btnDel.setOnClickListener(this);

        btnOkay = view.findViewById(R.id.btnOk);
        btnOkay.setOnClickListener(this);
    }

    private void initContent(View view) {
        mLayoutIncome = view.findViewById(R.id.layoutIncome);
        mLayoutExpense = view.findViewById(R.id.layoutExpense);

        mTxtAddIncome = view.findViewById(R.id.txtAddIncome);
        mTxtAddExpense = view.findViewById(R.id.txtAddExpense);
        mTxtAddMoney = view.findViewById(R.id.txtAddMoney);
        mTxtUnit = view.findViewById(R.id.txtUnit);

        mImgAddDate = view.findViewById(R.id.imgAddDate);
        mImgAddCate = view.findViewById(R.id.imageAddCate);

        mEditAddDate = view.findViewById(R.id.editDate);
        mEditAddNote = view.findViewById(R.id.editNote);

        mSpinnerCate = view.findViewById(R.id.spinnerCate);

        mLayoutIncome.setBackgroundResource(R.drawable.background_income);
        mTxtAddIncome.setTextColor(Color.parseColor("#FFFFFF"));
        mTxtAddMoney.setTextColor(Color.parseColor("#40E0D0"));
        mTxtUnit.setTextColor(Color.parseColor("#40E0D0"));

    }

    private void initToolbar() {
        mTxtTitle = ((ManageActivity) getActivity()).findViewById(R.id.txtTitle);
        mTxtTitle.setText("Add New");

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

    private void initListCate() {
        mListCate = new ArrayList<>();
        mListCate.add(new Category(R.drawable.icon_smile, "Cinema"));
        mListCate.add(new Category(R.drawable.icon_smile, "Baby"));
        mListCate.add(new Category(R.drawable.icon_smile, "Home"));
        mListCate.add(new Category(R.drawable.icon_smile, "Market"));
        mListCate.add(new Category(R.drawable.icon_smile, "Restaurant"));
        mListCate.add(new Category(R.drawable.icon_smile, "Travel"));
        mListCate.add(new Category(R.drawable.icon_smile, "Others"));
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

    @Override
    public void onClick(View view) {
        if (view == btnOne) {
            limitResult(btnOne.getText().toString());
        }
        if (view == btnTwo) {
            limitResult(btnTwo.getText().toString());
        }
        if (view == btnThree) {
            limitResult(btnThree.getText().toString());
        }
        if (view == btnFour) {
            limitResult(btnFour.getText().toString());
        }
        if (view == btnFive) {
            limitResult(btnFive.getText().toString());
        }
        if (view == btnSix) {
            limitResult(btnSix.getText().toString());
        }
        if (view == btnSeven) {
            limitResult(btnSeven.getText().toString());
        }
        if (view == btnEight) {
            limitResult(btnEight.getText().toString());
        }
        if (view == btnNine) {
            limitResult(btnNine.getText().toString());
        }
        if (view == btnZero) {
            limitResult(btnZero.getText().toString());
        }
        if (view == btnDel) {
            deleteNumber();
        }
        if (view == btnOkay) {
            if (mEditAddNote.getText().toString() == null || mEditAddNote.getText().toString().length() == 0) {
                Toast.makeText(getContext(), "Please enter the note!", Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(getContext(), "Clear to go!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void limitResult(String num) {
        if (resultMoney.length() > 9) {
            mTxtAddMoney.setText(String.format("%,d", Long.parseLong(resultMoney)));
        } else {
            resultMoney += num;
            mTxtAddMoney.setText(String.format("%,d", Long.parseLong(resultMoney)));
        }
    }

    private void deleteNumber() {
        if (resultMoney.length() <= 1) {
            mTxtAddMoney.setText("0");
        } else {
            StringBuilder builder = new StringBuilder(resultMoney);
            builder.deleteCharAt(resultMoney.length() - 1);
            resultMoney = builder.toString();
            mTxtAddMoney.setText(String.format("%,d", Long.parseLong(resultMoney)));
        }
    }

}
