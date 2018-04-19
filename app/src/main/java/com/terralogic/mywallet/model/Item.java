package com.terralogic.mywallet.model;

public class Item {

    private String mName;
    private String mDate;
    private int mIdItem;
    private String mMoney;
    private ItemType mType;

    public Item() {
    }

    public Item(String name, String date, int idItem,
                String money, ItemType type) {
        mName = name;
        mDate = date;
        mIdItem = idItem;
        mMoney = money;
        mType = type;
    }

    public Item(String name, String date, String money, ItemType type) {
        mName = name;
        mDate = date;
        mMoney = money;
        mType = type;
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

//    public String getmMoney() {
//        return mMoney;
//    }
//
//    public void setmMoney(String mMoney) {
//        this.mMoney = mMoney;
//    }

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

    @Override
    public String toString() {
        return "Name :" + getmName() + "\n" + "Date :" + getmDate() + "\n" +
                "MoneyConsume" + getmMoney() + "\n" + "MoneyIncome" + getmType();
    }
}