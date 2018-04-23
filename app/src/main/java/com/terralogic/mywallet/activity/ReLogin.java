package com.terralogic.mywallet.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.terralogic.mywallet.R;
import butterknife.BindView;
import butterknife.OnClick;
import butterknife.ButterKnife;

public class ReLogin extends AppCompatActivity {


    @BindView(R.id.buttonNum1)
    Button btnNum1;
    @BindView(R.id.buttonNum2)
    Button btnNum2;
    @BindView(R.id.buttonNum3)
    Button btnNum3;
    @BindView(R.id.buttonNum4)
    Button btnNum4;
    @BindView(R.id.buttonNum5)
    Button btnNum5;
    @BindView(R.id.buttonNum6)
    Button btnNum6;
    @BindView(R.id.buttonNum7)
    Button btnNum7;
    @BindView(R.id.buttonNum8)
    Button btnNum8;
    @BindView(R.id.buttonNum9)
    Button btnNum9;
    @BindView(R.id.buttonNum0)
    Button btnNum0;


    @BindView(R.id.radioNum1)

    RadioButton radioBtn1;
    @BindView(R.id.radioNum2)
    RadioButton radioBtn2;
    @BindView(R.id.radioNum3)
    RadioButton radioBtn3;
    @BindView(R.id.radioNum4)
    RadioButton radioBtn4;
    @BindView(R.id.radioNum5)
    RadioButton radioBtn5;


    @BindView(R.id.text1)
    TextView textView;

    @BindView(R.id.txtTitle)
    TextView mTitle;

    private String pwdLetters[] = new String[5];
    private int mCountClick = 0;
    final String PREF_NAME = "com.terralogic.mywallet";

    String firstPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        /*
         * author: trile
         * action: set title Toolbar for Activity Relogin
         */
        textView.setText( "Reenter your pass" );
        mTitle.setText("Password Lock");

        firstPass = getIntent().getStringExtra("first_pass");

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

    @OnClick({R.id.buttonNum1,
     R.id.buttonNum2,R.id.buttonNum3, R.id.buttonNum4,R.id.buttonNum5})

    public void onClick(Button button) {

        pwdLetters[mCountClick] = button.getText().toString();
        fillPwdRadioBtn(mCountClick);

        String pwd = "";
        for (int i = 0; i < pwdLetters.length; i++) {
            // 1 . accumulate letter to have final string of pwd
            String pwdLetter = pwdLetters[i];
            pwd += pwdLetter;

        }
        if(mCountClick == 4 && firstPass.equals( pwd ))
        {
            SharedPreferences sharePreferences = getSharedPreferences(PREF_NAME,
               Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharePreferences.edit();
            editor.putString("PWD",firstPass);
            editor.commit();
            Intent intent = new Intent( this,ManageActivity.class );
            startActivity( intent );
            finish();
        }
        else if(mCountClick == 4 && !firstPass.equals(pwd ))
        {
            Toast.makeText( getApplicationContext(), "FAIL PASS", Toast.LENGTH_LONG ).show();
            radioBtn1.setChecked( false );
            radioBtn2.setChecked( false );
            radioBtn3.setChecked( false );
            radioBtn4.setChecked( false );
            radioBtn5.setChecked( false );
            mCountClick = 0;
            return ;
        }
            mCountClick++;
    }

}