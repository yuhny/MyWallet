package com.terralogic.mywallet.model;

public class GroupItem {

        private  int Image;
        private String Name;
        private String Money;
      //  private String IdGroup;

    public GroupItem(int image, String name, String money) {
        Image = image;
        Name = name;
        Money = money;

    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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


