package com.terralogic.mywallet.model;

/**
 * Created by trile on 4/16/2018.
 */

public class Category {
    private int imageCate;
    private String nameCate;

    public Category(int imageCate, String nameCate) {
        this.imageCate = imageCate;
        this.nameCate = nameCate;
    }

    public int getImageCate() {
        return imageCate;
    }

    public void setImageCate(int imageCate) {
        this.imageCate = imageCate;
    }

    public String getNameCate() {
        return nameCate;
    }

    public void setNameCate(String nameCate) {
        this.nameCate = nameCate;
    }


    @Override
    public String toString() {
        return "Category{" +
                "imageCate=" + imageCate +
                ", nameCate='" + nameCate + '\'' +
                '}';
    }
}
