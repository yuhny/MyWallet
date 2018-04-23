package com.terralogic.mywallet.model;

import com.terralogic.mywallet.activity.ManageActivity;
import com.terralogic.mywallet.database.MySQLite;

import java.util.List;

public class Item {

    private String mName;
    private String mDate;
    private int mIdItem;
    private String mMoney;
    private ItemType mType;
    private int mIdGroup;

    public Item() {
    }


    public Item(String name, String date, int idItem,
                String money, ItemType type, int idGroup) {
        mName = name;
        mDate = date;
        mIdItem = idItem;
        mMoney = money;
        mType = type;
        mIdGroup = idGroup;


    }

    public int getmIdGroup() {
        return mIdGroup;
    }

    public void setmIdGroup(int mIdGroup) {
        this.mIdGroup = mIdGroup;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }


    public int getmIdItem() {
        return mIdItem;
    }

    public void setmIdItem(int mIdItem) {
        this.mIdItem = mIdItem;
    }

    public String getmMoney() {
        return mMoney;
    }

    public void setmMoney(String mMoney) {
        this.mMoney = mMoney;
    }

    public ItemType getmType() {

        return mType;
    }

    public void setmType(ItemType mType) {
        this.mType = mType;
    }

//    public int getImageCate() {
//        int result = 0;
//        MySQLite mySQLite = new MySQLite()
//
//        for (GroupItem item : groupItems) {
//            if (mIdGroup == item.getcIdGroup()) {
//                result = item.getcImage();
//            }
//        }
//        return result;
//    }

    @Override
    public String toString() {
        return "Name :" + getmName() + "\n" + "Date :" + getmDate() + "\n" +
                "MoneyConsume" + getmMoney() + "\n" + "MoneyIncome" + getmType();

    }
}