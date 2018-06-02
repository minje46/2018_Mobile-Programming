package com.example.forlecture_networking;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by KWAK on 2018-05-29.
 */

// Lab 6 - 3
public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String sql = "create table stu ("
                + "_id integer, "
                + "Name text, "
                + "Num integer);";
        database.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        String sql = "drop table if exists student";
        database.execSQL(sql);
        onCreate(database);
    }
}


// SQLite database example.
/*
public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "Create table student (" +
                "_id integer, " +
                "name text, "+
                "age integer, "+
                "address text);";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "Drop table if exists students";
        db.execSQL(sql);
        onCreate(db);
    }
}
*/