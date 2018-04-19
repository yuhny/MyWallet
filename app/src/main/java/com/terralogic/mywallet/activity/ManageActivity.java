package com.terralogic.mywallet.activity;


import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.terralogic.mywallet.R;
import com.terralogic.mywallet.database.MySQLite;
import com.terralogic.mywallet.fragment.DetailScreenFragment;
import com.terralogic.mywallet.fragment.WalletManageFragment;
import com.terralogic.mywallet.model.GroupItem;



import java.util.List;

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
        checkForTableCategory();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameManage, new WalletManageFragment());
        transaction.commit();


    }

    public List checkForTableCategory()
    {
       // boolean hasTableCategory = false;
        MySQLite mySQLite = new MySQLite( this.getApplicationContext() );
        List list = mySQLite.getListCategory();
        if(list == null || list.size()==0)
        {

            mySQLite.addCategory(new GroupItem( 00077777,"Baby","",1 ));
            mySQLite.addCategory( new GroupItem( 222222,"Cinema","",2 ));
            mySQLite.addCategory( new GroupItem( 2452453,"Home","",3 ) );
            mySQLite.addCategory( new GroupItem( 33333,"Market","",4 ) );
            mySQLite.addCategory( new GroupItem( 4425,"Restaurant","",5 ) );
            mySQLite.addCategory( new GroupItem( 332,"Travel","",6 ) );
            mySQLite.addCategory( new GroupItem( 2323,"Others","",7 ) );
            Toast.makeText(getApplicationContext(),"data was filled ",Toast.LENGTH_SHORT ).show();


            MySQLite mySQLite2 = new MySQLite( this.getApplicationContext() );
            List list2 = mySQLite2.getListCategory();
            list2.size();

        }
        else
        {
            Toast.makeText( getApplicationContext(),"not empty",Toast.LENGTH_SHORT ).show();
        }
        return list;

    }






}
