package com.terralogic.mywallet.model;

public class Item {

    private String mName;
    private String mDate;
    private int mIdItem;
    private String mMoney;
    private ItemType mType;
    private Integer mImage;

    public Item() {
    }


    public Item(Integer image, String name, String date, int idItem,
                String money, ItemType type) {
        mName = name;
        mDate = date;
        mIdItem = idItem;
        mMoney = money;
        mType = type;

        mImage = image;

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

    public Integer getmImage() {
        return mImage;
    }

    public void setmImage(Integer mImage) {
        this.mImage = mImage;
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

    @Override
    public String toString() {

        return "Image :" + getmImage() + "Name :" + getmName() + "\n" + "Date :" + getmDate() + "\n" +
                "MoneyConsume" + getmMoney() + "\n" + "MoneyIncome" + getmType();

    }
}