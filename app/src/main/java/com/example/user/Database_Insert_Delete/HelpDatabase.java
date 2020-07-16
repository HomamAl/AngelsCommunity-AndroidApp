package com.example.user.Database_Insert_Delete;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.ContentValues;
        import android.os.Bundle;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.util.Log;


public class HelpDatabase extends SQLiteOpenHelper {

    private static final String TAG = "HelpDatabase";

    private static final String TABLE_NAME = "suggestion_table";
    private static final String COLMN1 = "ID";
    private static final String COLMN2 = "name";


    public HelpDatabase(Context context) {
        super(context, TABLE_NAME, null, 1); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLMN2 +" TEXT)";
        db.execSQL(createTable); }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
        onCreate(db); }


    public boolean dataAdd(String item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLMN2, item);

        Log.d(TAG, "addData: Adding " + item + " to " + TABLE_NAME);

        long result = db.insert(TABLE_NAME, null, contentValues);

        //if the date is inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true; }
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data; }

    public Cursor itemIDget(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + COLMN1 + " FROM " + TABLE_NAME +
                " WHERE " + COLMN2 + " = '" + name + "'";
        Cursor data = db.rawQuery(query, null);
        return data; }

    public void nameUpdate(String newName, int id, String oldName){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE " + TABLE_NAME + " SET " + COLMN2 +
                " = '" + newName + "' WHERE " + COLMN1 + " = '" + id + "'" +
                " AND " + COLMN2 + " = '" + oldName + "'";
        Log.d(TAG, "updateName: query: " + query);
        Log.d(TAG, "updateName: Setting name to " + newName);
        db.execSQL(query); }

    public void nameDelete(int id, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + TABLE_NAME + " WHERE "
                + COLMN1 + " = '" + id + "'" +
                " AND " + COLMN2 + " = '" + name + "'";
        Log.d(TAG, "deleteName: query: " + query);
        Log.d(TAG, "deleteName: Deleting " + name + " from database.");
        db.execSQL(query); }
}
