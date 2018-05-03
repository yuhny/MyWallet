package com.terralogic.mywallet.activity;


import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
    private ImageView mIconUser;
    DetailScreenFragment detailScreenFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTitle = (TextView) findViewById(R.id.txtTitle);
        mIconUser = (ImageView) findViewById(R.id.iconUser);

        mTitle.setText("Wallet Manage");
        checkForTableCategory();
        addFragment(new WalletManageFragment());
        mIconUser.setVisibility(View.VISIBLE);
        mIconUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogUser();
            }
        });

        MySQLite mySQLite = new MySQLite(getApplicationContext());
        List<Item> items = mySQLite.getListItem();


    }

    private void showDialogUser() {
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(R.string.app_version);
        alert.setMessage(R.string.app_info);
        alert.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alert.show();
    }


    private void addFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frameManage, fragment);
        transaction.commit();
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


       }
//       else {
//            Toast.makeText(getApplicationContext(), "not empty", Toast.LENGTH_SHORT).show();
//
//        }
        return list;

    }


}
