package com.neeraj.csnotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class database extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;//Memory lording at class lording time therefore static variable.(DEFINE THE DATABASE VERSION)
    private static final String DATABASE_NAME = "user";//(DEFINE DATABASE NAME)
    private static final String TABLE = "user_details";//(DEFINE TABLE NAME)

    //DECLARE CLOUMN NAMES
    private static final String USERNAME = "username";//(DEFINE ID)
    private static final String PASSWORD = "password";//(DEFINE )
    private static final String MOBILE = "mobile_no";

    public database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE + "(" + USERNAME + " TEXT," + PASSWORD + " TEXT, " + MOBILE + " NUMBER(11));";//DECLARE QUERY TO STRING VARIABLE.
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }

    public long insertRecord(user record)//DEFINE A METHOD WITH LONG RETURN TYPE AND PASSING PARAMETER record
    {
        SQLiteDatabase db = getWritableDatabase();//TO WRITE DATA INTO DATABASE
        ContentValues values = new ContentValues();//TO CONTAIN VALUE INTO DATABASE COULMNS.
        values.put(USERNAME, record.getUsername());//PUTTING VALUE TO COULMNS
        values.put(PASSWORD, record.getPassword());
        values.put(MOBILE, record.getMobile_no());
        return db.insert(TABLE, null, values);//RETURNING THE PUT VALUES
    }

    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("Select * from user_details where username=? and password=?",new String[]{username,password});
        if(c.getCount()>0) return true;
        else return false;
    }


}