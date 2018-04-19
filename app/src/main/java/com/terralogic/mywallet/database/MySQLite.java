package com.terralogic.mywallet.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.terralogic.mywallet.model.GroupItem;
import com.terralogic.mywallet.model.Item;
import com.terralogic.mywallet.model.ItemType;

import java.util.ArrayList;
import java.util.List;


public class MySQLite extends SQLiteOpenHelper {

    private Context context;

    public MySQLite(Context context) {
        super(context, MyDatabase.MY_DATA_BASE, null, 1);
        Log.d("MySQLite", "MySQLite:");
        this.context = context;
    }


    public void QueryData(String sql) {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }


    public Cursor GetData(String sql) {
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(MyDatabase.createTableCategory());
        sqLiteDatabase.execSQL(MyDatabase.createTableItem());

    }


    public List<GroupItem> getListCategory() {
        List<GroupItem> listGroupItem = new ArrayList<>();
        String selectQueryCategory = "SELECT * FROM " + MyDatabase.TABLE_CATEGORY;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQueryCategory, null);

        if (cursor.moveToFirst()) {
            do {

                GroupItem category = new GroupItem();

                category.setcImage(cursor.getInt(0));
                category.setcName(cursor.getString(1));
                category.setcMoney(cursor.getString(2));
                category.setcIdGroup(cursor.getInt(3));
                listGroupItem.add(category);

            } while (cursor.moveToNext());

        }
        cursor.close();
        sqLiteDatabase.close();
        return listGroupItem;

    }


    public List<Item> getListItem() {
        List<Item> listItem = new ArrayList<>();
        String selectQueryItem = "SELECT * FROM " + MyDatabase.TABLE_ITEM;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQueryItem, null);
        if (cursor.moveToFirst()) {
            do {
                Item item = new Item();
                item.setmIdItem(cursor.getInt(0));
                item.setmName(cursor.getString(1));
                item.setmDate(cursor.getString(2));
                item.setmMoney(cursor.getString(3));
                item.setmType(cursor.getInt(4) == ItemType.INCOME.getValues() ? ItemType.INCOME :
                        ItemType.CONSUM);
                item.setmIdGroup(cursor.getInt(5));
                listItem.add(item);

            } while (cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();
        return listItem;
    }


    public void addCategory(GroupItem groupItem) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MyDatabase.IMAGE_CATEGORY, groupItem.getcImage());
        values.put(MyDatabase.NAME_CATEGORY, groupItem.getcName());
        values.put(MyDatabase.MONEY_CATEGORY, groupItem.getcMoney());
        values.put(MyDatabase.ID_TABLE_CATEGORY, groupItem.getcIdGroup());
        long check = sqLiteDatabase.insert(MyDatabase.TABLE_CATEGORY, null, values);
        Toast.makeText(context, check + " ", Toast.LENGTH_SHORT).show();
        sqLiteDatabase.close();
    }

    public void updateCategory(GroupItem groupItem) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MyDatabase.IMAGE_CATEGORY, groupItem.getcImage());
        long check = sqLiteDatabase.update(MyDatabase.TABLE_CATEGORY, values, MyDatabase.ID_TABLE_CATEGORY + "=" + groupItem.getcIdGroup(), null);
    }

    public void addItem(Item item) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(MyDatabase.ID_TABLE_ITEM, item.getmIdItem());
        values.put(MyDatabase.NAME_ITEM, item.getmName());
        values.put(MyDatabase.DATE_COMSUME, item.getmDate());
        values.put(MyDatabase.MONEY_ITEM, item.getmMoney());
        values.put(MyDatabase.MONEY_TYPE, item.getmType().getValues());
        values.put(MyDatabase.ID_GROUP_IEAM, item.getmIdGroup());

        long check = sqLiteDatabase.insert(MyDatabase.TABLE_ITEM, null, values);

        sqLiteDatabase.close();
//        Toast.makeText(context, check + " ", Toast.LENGTH_SHORT).show();

    }

    public void deleteItem(Item item) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(MyDatabase.TABLE_ITEM,
                MyDatabase.ID_TABLE_ITEM + "=?",
                new String[]
                        {
                                String.valueOf(item.getmIdItem())
                        });
        sqLiteDatabase.close();
    }

    public int updateItem(Item item) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDatabase.NAME_ITEM, item.getmName());
        contentValues.put(MyDatabase.DATE_COMSUME, item.getmDate());
        contentValues.put(MyDatabase.ID_TABLE_ITEM, item.getmIdItem());
        contentValues.put(MyDatabase.MONEY_ITEM, item.getmMoney());
        contentValues.put(MyDatabase.MONEY_TYPE, item.getmType().getValues());
        contentValues.put(MyDatabase.ID_GROUP_IEAM, item.getmIdGroup());
        return sqLiteDatabase.update(MyDatabase.TABLE_ITEM, contentValues,
                MyDatabase.ID_TABLE_ITEM + "=?", new String[]
                        {
                                String.valueOf(item.getmIdItem())
                        });
    }

    /*
     * author: trile
     * action: correctly function getListItemWithDate
     */
    public List<Item> getListItemWithDate(String date) {
        List<Item> listItemWithDate = new ArrayList<>();
        String selectQueryItem = "SELECT * FROM " + MyDatabase.TABLE_ITEM;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQueryItem, null);

        if (cursor.moveToFirst()) {
            do {
                Item item = new Item();
                item.setmIdItem(cursor.getInt(0));
                item.setmName(cursor.getString(1));
                item.setmDate(cursor.getString(2));
                item.setmMoney(cursor.getString(3));
                item.setmType(cursor.getInt(4) == ItemType.INCOME.getValues() ? ItemType.INCOME :
                        ItemType.CONSUM);
                item.setmIdGroup(cursor.getInt(5));
                if (item.getmDate().equals(date)) {
                    listItemWithDate.add(item);
                }


            } while (cursor.moveToNext());
        }

        cursor.close();
        sqLiteDatabase.close();

        return listItemWithDate;
    }

//    public int getImageCate(int idCate) {
//        int result = 0;
//        String sql = "SELECT " + MyDatabase.IMAGE_CATEGORY
//                + " FROM " + MyDatabase.TABLE_CATEGORY
//                + " WHERE " + MyDatabase.ID_TABLE_CATEGORY + "=" + idCate;
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                result = cursor.getInt(0);
//            } while (cursor.moveToNext());
//        }
//
//        cursor.close();
//        sqLiteDatabase.close();
//
//        return result;
//    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
    }


//
//
//
}
