package com.terralogic.mywallet.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.terralogic.mywallet.R;
import com.terralogic.mywallet.fragment.DetailScreenFragment;

public class ManageActivity extends AppCompatActivity {
    Toolbar mToolbar;
    final int frame = R.id.frameContent;
    DetailScreenFragment detailScreenFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

//        mToolbar.;
        detailScreenFragment = new DetailScreenFragment();
        getSupportFragmentManager().beginTransaction().add( frame,detailScreenFragment,
                "DetailScreen" ).commit();
    }

}
