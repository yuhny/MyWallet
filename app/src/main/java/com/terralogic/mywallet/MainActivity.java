package com.terralogic.mywallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnSo1, btnSo2, btnSo3, btnSo4, btnSo5, btnSo6, btnSo7, btnSo8, btnSo9, btnSo0;
    RadioButton radioBtn1, radioBtn2,radioBtn3,radioBtn4,radioBtn5;
    private String pwdLetters[] = new String[5];
    int countClick = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSo1 = (Button) findViewById(R.id.buttonSo1);
        btnSo2 = (Button) findViewById(R.id.buttonSo2);
        btnSo3 = (Button) findViewById(R.id.buttonSo3);
        btnSo4 = (Button) findViewById(R.id.buttonSo4);
        btnSo5 = (Button) findViewById(R.id.buttonSo5);
        btnSo6 = (Button) findViewById(R.id.buttonSo6);
        btnSo7 = (Button) findViewById(R.id.buttonSo7);
        btnSo8 = (Button) findViewById(R.id.buttonSo8);
        btnSo9 = (Button) findViewById(R.id.buttonSo9);
        btnSo0 = (Button) findViewById(R.id.buttonSo0);

        radioBtn1 = (RadioButton)findViewById(R.id.radioSo1);
        radioBtn2 = (RadioButton)findViewById(R.id.radioSo2);
        radioBtn3 = (RadioButton)findViewById(R.id.radioSo3);
        radioBtn4 = (RadioButton)findViewById(R.id.radioSo4);
        radioBtn5 = (RadioButton)findViewById(R.id.radioSo5);

        btnSo1.setOnClickListener(this);
        btnSo2.setOnClickListener(this);
        btnSo3.setOnClickListener(this);
        btnSo4.setOnClickListener(this);
        btnSo5.setOnClickListener(this);
        btnSo6.setOnClickListener(this);
        btnSo7.setOnClickListener(this);
        btnSo8.setOnClickListener(this);
        btnSo9.setOnClickListener(this);
        btnSo0.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        pwdLetters[countClick] = ((Button)view).getText().toString();
        switch (countClick) {
            case 0: radioBtn1.setChecked(true);
            break;
            case 1: radioBtn2.setChecked(true);
            break;
            case 2: radioBtn3.setChecked(true);
            break;
            case 3: radioBtn4.setChecked(true);
            break;
            case 4: radioBtn5.setChecked(true);
        }
        countClick++;
    }




}
