package com.terralogic.mywallet.model;

import java.sql.Timestamp;

public class Expense {
    private String context;
    private Timestamp timestamp;
    private int totalMoney;
    private int image;

    public Expense(String context, Timestamp timestamp, int totalMoney, int image) {
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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }
}
