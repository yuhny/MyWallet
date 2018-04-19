package com.terralogic.mywallet.database;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.terralogic.mywallet.model.GroupItem;

public class MyDatabase {

    public static final String MY_DATA_BASE = "MyDatabase";
    public static final String TABLE_CATEGORY = "TableCategory";
    public static final String TABLE_ITEM = "TableItem";
    public static final String ID_TABLE_CATEGORY = "IdTableCategory";
    public static final String ID_TABLE_ITEM = " IdTableItem";
    public static final String NAME_CATEGORY = "NameCategory";
    public static final String NAME_ITEM = "NameItem";
    public static final String IMAGE_CATEGORY = "ImageCategory";
    public static final String IMAGE_IEAM = "ImageItem";
    public static  final String MONEY_CATEGORY = "MoneyCategory";
    public static final String DATE_COMSUME = "Date";
    public static final String MONEY_ITEM = "MoneyItem";
    public static final String MONEY_TYPE = "Money Type";
    public Context context;


    public static String createTableCategory() {
        return "CREATE TABLE " + TABLE_CATEGORY + "("
                + IMAGE_CATEGORY + " text," + NAME_CATEGORY + " text,"+MONEY_CATEGORY+" text,"+
                ID_TABLE_CATEGORY + " integer primary key)";
//
    }


    public static String createTableItem() {
        return  " CREATE TABLE " + TABLE_ITEM + "(" + ID_TABLE_ITEM + " integer primary key,"
                +IMAGE_IEAM+" text,"+ NAME_ITEM + " text," + DATE_COMSUME + " text," + MONEY_ITEM + " text," +
                MONEY_TYPE + " text)";

//
    }


}
