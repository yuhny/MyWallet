package com.terralogic.mywallet.model;

public class GroupItem {
    private Integer cImage;
    private String cName;
    private String cMoney;
    private int cIdGroup;



    public GroupItem() {
    }


    public GroupItem(Integer cImage, String cName, String cMoney, int cIdGroup) {
        this.cImage = cImage;
        this.cName = cName;
        this.cMoney = cMoney;
        this.cIdGroup = cIdGroup;
    }

    public Integer getcImage() {
        return cImage;
    }

    public void setcImage(Integer cImage) {
        this.cImage = cImage;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcMoney() {
        return cMoney;
    }

    public void setcMoney(String cMoney) {
        this.cMoney = cMoney;
    }

    public int getcIdGroup() {
        return cIdGroup;
    }

    public void setcIdGroup(int cIdGroup) {
        this.cIdGroup = cIdGroup;
    }

    @Override
    public String toString() {
        return "Image:" + getcImage() + "\n" + "Name:" + getcName() + "\n" + "Money" + getcMoney();
    }
}


