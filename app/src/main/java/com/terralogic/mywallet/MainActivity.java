package com.terralogic.mywallet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.terralogic.mywallet.activity.ManageActivity;
import com.terralogic.mywallet.activity.ReLogin;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnNum1, btnNum2, btnNum3, btnNum4, btnNum5, btnNum6, btnNum7, btnNum8, btnNum9, btnNum0;
    RadioButton radioBtn1, radioBtn2, radioBtn3, radioBtn4, radioBtn5;
    private String pwdLetters[] = new String[5];
    private String radioButtonArr[] = new String[5];
    private int mCountClick = 0;
    final String PREF_NAME = "com.terralogic.mywallet";
    String oldPassword;
    private Toolbar mToolBar;
    private TextView mTitle;
    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        


        btnNum1 = (Button) findViewById(R.id.buttonNum1);
        btnNum2 = (Button) findViewById(R.id.buttonNum2);
        btnNum3 = (Button) findViewById(R.id.buttonNum3);
        btnNum4 = (Button) findViewById(R.id.buttonNum4);
        btnNum5 = (Button) findViewById(R.id.buttonNum5);
        btnNum6 = (Button) findViewById(R.id.buttonNum6);
        btnNum7 = (Button) findViewById(R.id.buttonNum7);
        btnNum8 = (Button) findViewById(R.id.buttonNum8);
        btnNum9 = (Button) findViewById(R.id.buttonNum9);
        btnNum0 = (Button) findViewById(R.id.buttonNum0);

        radioBtn1 = (RadioButton) findViewById(R.id.radioNum1);
        radioBtn2 = (RadioButton) findViewById(R.id.radioNum2);
        radioBtn3 = (RadioButton) findViewById(R.id.radioNum3);
        radioBtn4 = (RadioButton) findViewById(R.id.radioNum4);
        radioBtn5 = (RadioButton) findViewById(R.id.radioNum5);



        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        mTitle = (TextView) findViewById(R.id.txtTitle);

        /*
         * author: trile
         * action: set title Toolbar for Activity Relogin
         */

        mTitle.setText("Password Lock");

        btnNum1.setOnClickListener(this);
        btnNum2.setOnClickListener(this);
        btnNum3.setOnClickListener(this);
        btnNum4.setOnClickListener(this);
        btnNum5.setOnClickListener(this);
        btnNum6.setOnClickListener(this);
        btnNum7.setOnClickListener(this);
        btnNum8.setOnClickListener(this);
        btnNum9.setOnClickListener(this);
        btnNum0.setOnClickListener(this);

        radioBtn1.setChecked(false);
        radioBtn2.setChecked( false);
        radioBtn3.setChecked( false );
        radioBtn4.setChecked( false );
        radioBtn5.setChecked( false );




        // Checking pwd exitence
        SharedPreferences sharePreferences = getSharedPreferences(PREF_NAME,
                Context.MODE_PRIVATE);
        oldPassword = sharePreferences.getString("PWD", null);

    }

    void preventRadioButtonOnClick(int countClickRadioButton)
    {
        switch (countClickRadioButton)
        {
            case 0:
                radioBtn1.setChecked( false );
                break;
            case 1:
                radioBtn2.setChecked( false );
                break;
            case 2:
                radioBtn3.setChecked( false );
                break;
            case 3:
                radioBtn4.setChecked( false );
                break;
        }
    }

    void fillPwdRadioBtn(int countClick) {
        switch (countClick) {
            case 0:
                radioBtn1.setChecked(true);
                break;
            case 1:
                radioBtn2.setChecked(true);
                break;
            case 2:
                radioBtn3.setChecked(true);
                break;
            case 3:
                radioBtn4.setChecked(true);
                break;
            case 4:
                radioBtn5.setChecked(true);
        }
    }

    @Override
    public void onClick(View view) {
        if(mCountClick>4){
            return;
        }
//        radioButtonArr[mCountClick] = ((RadioButton)view).getText().toString();
//        preventRadioButtonOnClick( mCountClick );
        pwdLetters[mCountClick] = ((Button) view).getText().toString();
        fillPwdRadioBtn(mCountClick);


        String pwd = "";
        for (int i = 0; i < pwdLetters.length; i++) {
            // 1 . accumulate letter to have final string of pwd
            String pwdLetter = pwdLetters[i];
            pwd += pwdLetter;
        }

        if (mCountClick == 4 && oldPassword==null) {
            Intent i = new Intent(this,ReLogin.class);
            i.putExtra( "first_pass",pwd );
            startActivity(i);
            finish();

        }else if(mCountClick==4 && oldPassword!=null){
            if(oldPassword.equals(pwd))
            {

                Intent i = new Intent(this,ManageActivity.class);
                startActivity(i);
                finish();
            }
            else
            {
               mCountClick = 0;
               radioBtn1.setChecked(false);
               radioBtn2.setChecked(false);
               radioBtn3.setChecked(false);
               radioBtn4.setChecked(false);
               radioBtn5.setChecked(false);
               return;
            }

        }
        mCountClick++;
    }


}
