package com.terralogic.mywallet.activity;


import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.terralogic.mywallet.R;
import com.terralogic.mywallet.fragment.WalletManageFragment;

public class ManageActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private TextView mTitle;
    private FrameLayout mFrame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTitle = (TextView) findViewById(R.id.txtTitle);

        mTitle.setText("Wallet Manage");

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameManage, WalletManageFragment.newInstance());
        transaction.commit();
    }
}
