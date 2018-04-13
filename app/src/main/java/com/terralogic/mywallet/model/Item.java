package com.terralogic.mywallet.model;

public class Item {

    private String Name;
    private String Date;
    private String Money;
   // private String IdGroup;

    public Item(String name, String date, String money) {
        Name = name;
        Date = date;
        Money = money;
        //IdGroup = idGroup;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getMoney() {
        return Money;
    }

    public void setMoney(String money) {
        Money = money;
    }

//    public String getIdGroup() {
//        return IdGroup;
//    }
//
//    public void setIdGroup(String idGroup) {
//        IdGroup = idGroup;
//    }
}