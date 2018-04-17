package com.terralogic.mywallet.model;

import com.terralogic.mywallet.database.MyDatabase;

public enum ItemType{
    INCOME(0),
    CONSUM(1);
    private int values;

    ItemType(int i) {
        values = i;
    }

    public int getValues() {
        return values;
    }
}


