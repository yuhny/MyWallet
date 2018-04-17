package com.terralogic.mywallet.activity;


import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.terralogic.mywallet.R;
import com.terralogic.mywallet.fragment.DetailScreenFragment;
import com.terralogic.mywallet.fragment.WalletManageFragment;

public class ManageActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private TextView mTitle;
    private FrameLayout mFrame;
    DetailScreenFragment detailScreenFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTitle = (TextView) findViewById(R.id.txtTitle);
        mTitle.setText("Wallet Manage");
//        setTitle("Wallet Manage");
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameManage, new WalletManageFragment());
        transaction.commit();
    }
//
//    public void setTitle(String text){
//        mTitle.setText(text.toString());
//    }


}
