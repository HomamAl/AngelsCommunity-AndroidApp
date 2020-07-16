package com.example.user;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public final class LocationDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "CharityLocation.db";
    public static final String TABLE_NAME = "location_table";
    public static final String COL_1 = "CHARITY_ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "LATITUDE";
    public static final String COL_4 = "LONGITUDE";

    public LocationDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(" CREATE TABLE " + TABLE_NAME + "(CHARITY_ID INTEGER PRIMARY KEY, NAME TEXT, LATITUDE DOUBLE, LONGITUDE DOUBLE)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" DROP TABLE IF EXISTS " +  TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String cId, String cName, Double dBlat, Double dBlong){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, cId);
        contentValues.put(COL_2, cName);
        contentValues.put(COL_3, dBlat);
        contentValues.put(COL_4, dBlong);

        long res = db.insert(TABLE_NAME, null, contentValues);

        if (res == -1){
                return false;

        }else {
                return true;
            }
    }

    public boolean updateData(String cId, String cName, Double dBlat, Double dBlong) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, cId);
        contentValues.put(COL_2, cName);
        contentValues.put(COL_3, dBlat);
        contentValues.put(COL_4, dBlong);

        db.update(TABLE_NAME, contentValues, "CHARITY_ID = ?",new String[] { cId });
        return true;
    }

    public Cursor getAllData() {

        // Cursor provides random read-write access to database.

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor res = db.rawQuery("select * from " + TABLE_NAME,null);

        return res;

    }


}


