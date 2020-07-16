package com.example.user;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
    private static final String TAB = "DBHelper";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Test.db";
    private static final String TABLE_NAME = "Donations";
    private static final String COL1 = "TIME";
    private static final String COL2 = "MONEY";

    SQLiteDatabase database;

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        database = getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = ("CREATE TABLE " + TABLE_NAME + "( "
                +COL1+" INTERGER PRIMARY KEY, "
                + COL2 + "TEXT)");
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int ii) {
        db.execSQL("DROP IF TABLE EXIST "+ TABLE_NAME);
        onCreate(db);
    }
}
