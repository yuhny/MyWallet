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
import com.terralogic.mywallet.model.Item;


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
        MySQLite mySQLite = new MySQLite(getApplicationContext());

        List<Item> items = mySQLite.getListItem();

        Toast.makeText(getApplicationContext(), items.size()+"", Toast.LENGTH_SHORT).show();


    }

    public List checkForTableCategory() {
        // boolean hasTableCategory = false;
        MySQLite mySQLite = new MySQLite(this.getApplicationContext());
        List list = mySQLite.getListCategory();
        List list3 = mySQLite.getListItem();
        if (list == null || list.size() == 0) {
            //change images categories
            mySQLite.addCategory(new GroupItem(R.drawable.ic_01, "Baby", "", 1));
            mySQLite.addCategory(new GroupItem(R.drawable.ic_02, "Cinema", "", 2));
            mySQLite.addCategory(new GroupItem(R.drawable.ic_03, "Home", "", 3));
            mySQLite.addCategory(new GroupItem(R.drawable.ic_04, "Market", "", 4));
            mySQLite.addCategory(new GroupItem(R.drawable.ic_06, "Restaurant", "", 5));
            mySQLite.addCategory(new GroupItem(R.drawable.ic_08, "Travel", "", 6));
            mySQLite.addCategory(new GroupItem(R.drawable.ic_07, "Others", "", 7));
            //* trile//

//            Toast.makeText(getApplicationContext(),"data was filled ",Toast.LENGTH_SHORT ).show();

            MySQLite mySQLite2 = new MySQLite(this.getApplicationContext());
            List list2 = mySQLite2.getListCategory();
            list2.size();


        } else {
            Toast.makeText( getApplicationContext(),"not empty",Toast.LENGTH_SHORT ).show();
        }
        return list;

    }


}
