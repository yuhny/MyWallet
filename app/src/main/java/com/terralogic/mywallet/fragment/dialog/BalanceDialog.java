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
import com.terralogic.mywallet.fragment.DetailScreenFragment;
import com.terralogic.mywallet.fragment.fragment;
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
    private ImageView imageView;

    public BalanceDialog(@NonNull Context context, String month) {
        super( context );
        this.mContext = context;
        this.month = month;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        setContentView( R.layout.dialog_balance );

        mTitle = (TextView) findViewById( R.id.txtDialogTitle );
        mIncome = (TextView) findViewById( R.id.txtDialogIncome );
        mExpense = (TextView) findViewById( R.id.txtDialogExpense );
        imageView = (ImageView) findViewById( R.id.imgDialog );
        imageView.setOnClickListener( this);
//        Toast.makeText(getContext(), map.get( month ).toString(), Toast.LENGTH_SHORT).show();
        mTitle.setText( "Summary for " + map.get( month ) );
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void callFragment(Fragment fragment)
    {
        if (!(mContext instanceof  FragmentActivity)) {
            return;
        }
        FragmentManager manager = ((FragmentActivity)mContext).getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace( R.id.frameManage,fragment );
        transaction.addToBackStack(fragment.getClass().getSimpleName());
        transaction.commit();
        dismiss();


    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.imgDialog) {
            callFragment( new DetailScreenFragment());
        }

    }
}
