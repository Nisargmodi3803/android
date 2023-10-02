package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDbHandler extends SQLiteOpenHelper
{
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "Contacts";
    public static final String TABLE_NAME = "contact";
    public static  final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_PHONE_NO = "phone_no";

    public MyDbHandler(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //  CREATE TABLE CONTACT (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,PHONE_NO TEXT )

        db.execSQL("Create table "+TABLE_NAME+"("+KEY_ID+" Integer primary key autoincrement "+","+KEY_NAME+" text "+","+KEY_PHONE_NO+" text"+")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);
    }

    public void addContact(String name,String phone_no) //Insert...
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cvalue = new ContentValues();
        cvalue.put(KEY_NAME,name);
        cvalue.put(KEY_PHONE_NO,phone_no);

        db.insert(TABLE_NAME,null,cvalue);
    }

    public ArrayList<ContactModel> getContact()//Select...
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "Select * from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);

        ArrayList<ContactModel> arr = new ArrayList<>();

        while(cursor.moveToNext())
        {
            ContactModel cm = new ContactModel();
            cm.id = cursor.getInt(0);
            cm.name = cursor.getString(1);
            cm.Phone_no = cursor.getString(2);

            arr.add(cm);
        }

        return arr;
    }

    public void updateContact(ContactModel cm) //Update...
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(KEY_PHONE_NO,"9178547854");

        db.update(TABLE_NAME,cv,KEY_ID+" = "+cm.id,null);
//        db.update(TABLE_NAME,cv,KEY_ID+" = ? ",new String[]{String.valueOf(cm.id)});
    }

    public void deleteContact(int id) //Delete...
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_NAME,KEY_ID+" = ? ",new String[]{String.valueOf(id)});
    }

}
