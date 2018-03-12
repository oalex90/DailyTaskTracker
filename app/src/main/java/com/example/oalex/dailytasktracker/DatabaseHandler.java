package com.example.oalex.dailytasktracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.Date;

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
                + KEY_CATEGORY + " TEXT," + KEY_STARTTIME + " INTEGER,"
                + KEY_ENDTIME + " INTEGER" + ")";
        db.execSQL(CREATE_TASKS_TABLE);
        //db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASKS);

        // Create tables again
        onCreate(db);
        //db.close();
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new task
    public void addTask(Task task) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, task.getName());
        values.put(KEY_CATEGORY, task.getCategory());
        values.put(KEY_STARTTIME, task.getStartTime().getTime());
        values.put(KEY_ENDTIME, task.getEndTime().getTime());

        // Inserting Row
        db.insert(TABLE_TASKS, null, values);
        db.close(); //Closing database connection
    }

    // Getting single task
    public Task getTask(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_TASKS, new String[] {KEY_ID,
                KEY_NAME, KEY_CATEGORY, KEY_STARTTIME, KEY_STARTTIME }, KEY_ID + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
        }

        Task task = new Task(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2),
                new Date(Long.parseLong(cursor.getString(3))),
                new Date(Long.parseLong(cursor.getString(4))));

        cursor.close();
        db.close();

        return task;
    }

    // Getting all Tasks
    public ArrayList<Task> getAllTasks(){
        ArrayList<Task> taskList = new ArrayList<Task>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_TASKS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()){
            do {
                Task task = new Task(Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1), cursor.getString(2),
                        new Date(Long.parseLong(cursor.getString(3))),
                        new Date(Long.parseLong(cursor.getString(4))));
                taskList.add(task);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return task list
        return taskList;
    }


    // Getting tasks Count
    public int getTasksCount(){
        String countQuery = "SELECT * FROM " + TABLE_TASKS;
        SQLiteDatabase db  = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();
        db.close();
        return count;
    }

    // Updating single task
    public int updateTask(Task task){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, task.getName());
        values.put(KEY_CATEGORY, task.getCategory());
        values.put(KEY_STARTTIME, task.getStartTime().getTime());
        values.put(KEY_ENDTIME, task.getEndTime().getTime());

        // updating row
        int result = db.update(TABLE_TASKS, values, KEY_ID + " =?",
                new String[] {String.valueOf(task.getId())});
        db.close();
        return result;
    }

    // Deleting single task
    public void deleteTask(Task task){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TASKS, KEY_ID + " = ?",
                new String[] {String.valueOf(task.getId())});
        db.close();
    }
}
