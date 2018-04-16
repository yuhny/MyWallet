package com.terralogic.mywallet.model;

import java.sql.Timestamp;
import java.util.Date;

public class Expense {
    private String context;
    private Date timestamp;
    private int totalMoney;
    private int image;

    public Expense(String context, Date timestamp, int totalMoney, int image) {
        this.context = context;
        this.timestamp = timestamp;
        this.totalMoney = totalMoney;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getTimestamp() {
        return DateUtil.getDate(timestamp.getTime());
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }
}
