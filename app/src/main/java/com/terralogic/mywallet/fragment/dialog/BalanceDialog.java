package com.terralogic.mywallet.fragment.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.terralogic.mywallet.R;
import com.terralogic.mywallet.database.MySQLite;
import com.terralogic.mywallet.fragment.DetailScreenFragment;
import com.terralogic.mywallet.fragment.fragment;
import com.terralogic.mywallet.model.DateUtil;
import com.terralogic.mywallet.model.Item;
import com.terralogic.mywallet.model.ItemType;

import java.util.List;
import java.util.Map;

/**
 * Created by trile on 4/9/2018.
 */

public class BalanceDialog extends Dialog implements View.OnClickListener {
    private Context mContext;
    private Dialog mDialog;
    private TextView mTitle, mIncome, mExpense, mBalance;
    private String month;
    private int moneyIncome, moneyExpense, moneyBalance;
    private Map<String, String> map = DateUtil.MONTH_OF_YEAR;
    private ImageView imageView;
    private MySQLite mySQLite;

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
        mBalance = (TextView) findViewById(R.id.txtDialogBalance);
        mExpense = (TextView) findViewById(R.id.txtDialogExpense);
        imageView = (ImageView) findViewById(R.id.imgDialog);
        imageView.setOnClickListener(this);
        mySQLite = new MySQLite(getContext());

        List<Item> items = mySQLite.getListItem();
        //Toast.makeText(getContext(), items.size() + "", Toast.LENGTH_SHORT).show();
        for (Item item : items) {
            int thisMonth = (item.getmDate().getMonth() + 1);
            if (item.getmType() == ItemType.INCOME) {
                if (thisMonth == Integer.parseInt(month)) {
                    moneyIncome += Integer.parseInt(item.getmMoney());
                }
            } else if (item.getmType() == ItemType.CONSUM) {
                if (thisMonth == Integer.parseInt(month)) {
                    moneyExpense += Integer.parseInt(item.getmMoney());
                }
            }
        }
        moneyBalance = moneyIncome - moneyExpense;

        mTitle.setText("Summary for " + map.get(month));
        mIncome.setText(String.format("%,d", moneyIncome) + " VNĐ");
        mExpense.setText(String.format("%,d", moneyExpense) + " VNĐ");
        mBalance.setText(String.format("%,d", moneyBalance) + " VNĐ");
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    /*
     * author: trile
     * action: add fragment to back stack and set animation
     */
    public void callFragment(Fragment fragment) {
        if (!(mContext instanceof FragmentActivity)) {
            return;
        }
        FragmentManager manager = ((FragmentActivity) mContext).getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.setCustomAnimations(R.anim.anim_in_right, R.anim.anim_out_left, R.anim.anim_in_left, R.anim.anim_to_right);
        transaction.replace(R.id.frameManage, fragment);
        transaction.addToBackStack(fragment.getClass().getSimpleName());
        transaction.commit();
        dismiss();


    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.imgDialog) {
            DetailScreenFragment detailScreenFragment = new DetailScreenFragment();
            detailScreenFragment.setMonth( map.get(month) );
            callFragment(detailScreenFragment);
        }

    }
}
