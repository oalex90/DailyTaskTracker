package com.example.oalex.dailytasktracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by oalex on 3/9/2018.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "taskManager";

    // Tasks table name
    private static final String TABLE_TASKS = "tasks";

    // Tasks Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_STARTTIME = "startDate";
    private static final String KEY_ENDTIME = "endDate";

    public DatabaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TASKS_TABLE = "CREATE TABLE " + TABLE_TASKS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_CATEGORY + " TEXT," + KEY_STARTTIME + " TEXT,"
                + KEY_ENDTIME + " TEXT" + ")";
        db.execSQL(CREATE_TASKS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASKS);

        // Create tables again
        onCreate(db);
    }
}
