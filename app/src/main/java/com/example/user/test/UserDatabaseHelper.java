package com.example.user.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;

public class UserDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "ProfilePage.db";
    public static final String TABLE_NAME = "user_info_table";
    public static final String COL_1 = "USER_ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SURNAME";
    public static final String COL_4 = "EMAIL";
    public static final String COL_5 = "PASSWORD";
    public static final String COL_6 = "LEVEL";
    public static final String COL_7 = "POINTS";
    public static final String COL_8 = "BADGES";
    public static final String COL_9 = "NUMBER";
    public static final String[] COLS = new String[]{
            COL_1, COL_2, COL_3, COL_4, COL_5, COL_6, COL_7, COL_8, COL_9
    };

    public UserDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
//        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME
                + " (user_ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, SURNAME TEXT, EMAIL TEXT, PASSWORD TEXT, LEVEL INTEGER, POINTS INTEGER, BADGES INTEGER, NUMBER TEXT) ");
        if (insertData(db, "Julia", "Dlugosz", "julia.dlugosz@gmail.com", "123456", 1, 1, 0, "0123456789")) {
            System.out.println("Julia inserted into DB");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int newVersion, int oldVersion) {
        onCreate(db);
    }


    public boolean insertData(SQLiteDatabase db, String Name, String Surname, String Email, String Password, int level, int points, int badges, String number ) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, Name);
        contentValues.put(COL_3, Surname);
        contentValues.put(COL_4, Email);
        contentValues.put(COL_5, Password);
        contentValues.put(COL_6, level);
        contentValues.put(COL_7, points);
        contentValues.put(COL_8, badges);
        contentValues.put(COL_9, number);
        long res = db.insert(TABLE_NAME, null, contentValues);
        if (res == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Map<String, String> getDataById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Map<String, String> user = new HashMap<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE USER_ID = ?", new String[]{String.valueOf(id)});
        int columnCount = cursor.getColumnCount();
        System.out.println("Column count: " + columnCount);
        if (cursor.moveToFirst()) {
            for (int i = 0; i < Math.min(COLS.length, columnCount); i++) {
                user.put(COLS[i], cursor.getString(i));
            }
        } else {
            return null;
        }
        return user;
    }


    public int updateData(int id, ContentValues values) {
        SQLiteDatabase db = this.getWritableDatabase();
        int results = db.update(TABLE_NAME, values, "USER_ID = ?", new String[]{String.valueOf(id)});
        return results;
    }

}




