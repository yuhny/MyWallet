package com.terralogic.mywallet.fragment.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.terralogic.mywallet.R;
import com.terralogic.mywallet.model.DateUtil;

import java.util.Map;

/**
 * Created by trile on 4/9/2018.
 */

public class BalanceDialog extends Dialog implements View.OnClickListener {
    private Context mContext;
    private Dialog mDialog;
    private TextView mTitle, mIncome, mExpense;
    private String month;
    private Map<String, String> map = DateUtil.MONTH_OF_YEAR;

    public BalanceDialog(@NonNull Context context, String month) {
        super(context);
        this.mContext = context;
        this.month = month;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_balance);

        mTitle = (TextView) findViewById(R.id.txtDialogTitle);
        mIncome = (TextView) findViewById(R.id.txtDialogIncome);
        mExpense = (TextView) findViewById(R.id.txtDialogExpense);

        mTitle.setText("Summary for "+ map.get(month));
        //todo here
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public void onClick(View view) {

    }
}
