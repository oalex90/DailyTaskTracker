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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if exists
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASKS);

        // Create tables again
        onCreate(db);
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

    // Deleting all tasks
    public void deleteAllTasks(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TASKS, null, null);
        db.close();
    }

    // Add test tasks
    public void addTestTasks(){
        //Initial Add to db of tasks
        //Year is years after 1900, Month starts at 0
        ArrayList <Task> testTasks = new ArrayList<Task>();
        testTasks.add(new Task("Sleep", "Mandatory", new Date(118, 2, 4, 0, 0), new Date(118, 2, 4, 8, 4)));
        testTasks.add(new Task("Reddit", "Entertainment", new Date(118, 2, 4, 8, 4), new Date(118, 2, 4, 8, 35)));
        testTasks.add(new Task("Breakfast", "Mandatory", new Date(118, 2, 4, 8, 35), new Date(118, 2, 4, 9, 28)));
        testTasks.add(new Task("Android Dev", "Learning", new Date(118, 2, 4, 9, 28), new Date(118, 2, 4, 12, 1)));
        testTasks.add(new Task("Schedule", "Productive", new Date(118, 2, 4, 12, 01), new Date(118, 2, 4, 12, 21)));
        testTasks.add(new Task("Fun", "Entertainment", new Date(118, 2, 4, 12, 21), new Date(118, 2, 4, 12, 58)));
        testTasks.add(new Task("Spanish Movie", "Spanish", new Date(118, 2, 4, 12, 58), new Date(118, 2, 4, 14, 25)));
        testTasks.add(new Task("Spanish Game", "Spanish", new Date(118, 2, 4, 14, 25), new Date(118, 2, 4, 16, 11)));
        testTasks.add(new Task("Stair Master", "Exercise", new Date(118, 2, 4, 16, 11), new Date(118, 2, 4, 17, 40)));
        testTasks.add(new Task("Watch Soccer", "Entertainment", new Date(118, 2, 4, 17, 40), new Date(118, 2, 4, 18, 4)));
        testTasks.add(new Task("Shower", "Mandatory", new Date(118, 2, 4, 18, 4), new Date(118, 2, 4, 18, 35)));
        testTasks.add(new Task("Dinner", "Mandatory", new Date(118, 2, 4, 18, 35), new Date(118, 2, 4, 19, 2)));
        testTasks.add(new Task("Game of Thrones", "Social", new Date(118, 2, 4, 19, 2), new Date(118, 2, 4, 20, 47)));
        testTasks.add(new Task("Rocket League", "Entertainment", new Date(118, 2, 4, 20, 47), new Date(118, 2, 4, 22, 56)));
        testTasks.add(new Task("Twitch", "Entertainment", new Date(118, 2, 4, 22, 56), new Date(118, 2, 5, 0, 0)));
        testTasks.add(new Task("Sleep", "Mandatory", new Date(118, 2, 5, 0, 0), new Date(118, 2, 5, 8, 4)));
        testTasks.add(new Task("Reddit", "Entertainment", new Date(118, 2, 5, 8, 4), new Date(118, 2, 5, 8, 35)));
        testTasks.add(new Task("Breakfast", "Mandatory", new Date(118, 2, 5, 8, 35), new Date(118, 2, 5, 9, 28)));
        testTasks.add(new Task("Android Dev", "Learning", new Date(118, 2, 5, 9, 28), new Date(118, 2, 5, 12, 1)));
        testTasks.add(new Task("Schedule", "Productive", new Date(118, 2, 5, 12, 1), new Date(118, 2, 5, 12, 21)));
        testTasks.add(new Task("Fun", "Entertainment", new Date(118, 2, 5, 12, 21), new Date(118, 2, 5, 12, 58)));
        testTasks.add(new Task("Spanish Movie", "Spanish", new Date(118, 2, 5, 12, 58), new Date(118, 2, 5, 14, 25)));
        testTasks.add(new Task("Spanish Game", "Spanish", new Date(118, 2, 5, 14, 25), new Date(118, 2, 5, 16, 11)));
        testTasks.add(new Task("Stair Master", "Exercise", new Date(118, 2, 5, 16, 11), new Date(118, 2, 5, 17, 40)));
        testTasks.add(new Task("Watch Soccer", "Entertainment", new Date(118, 2, 5, 17, 40), new Date(118, 2, 5, 18, 4)));
        testTasks.add(new Task("Shower", "Mandatory", new Date(118, 2, 5, 18, 4), new Date(118, 2, 5, 18, 35)));
        testTasks.add(new Task("Dinner", "Mandatory", new Date(118, 2, 5, 18, 35), new Date(118, 2, 5, 19, 2)));
        testTasks.add(new Task("Game of Thrones", "Social", new Date(118, 2, 5, 19, 2), new Date(118, 2, 5, 20, 47)));
        testTasks.add(new Task("Rocket League", "Entertainment", new Date(118, 2, 5, 20, 47), new Date(118, 2, 5, 22, 56)));
        testTasks.add(new Task("Twitch", "Entertainment", new Date(118, 2, 5, 22, 56), new Date(118, 2, 6, 0, 0)));
        testTasks.add(new Task("Sleep", "Mandatory", new Date(118, 2, 6, 0, 0), new Date(118, 2, 6, 8, 4)));
        testTasks.add(new Task("Reddit", "Entertainment", new Date(118, 2, 6, 8, 4), new Date(118, 2, 6, 8, 35)));
        testTasks.add(new Task("Breakfast", "Mandatory", new Date(118, 2, 6, 8, 35), new Date(118, 2, 6, 9, 28)));
        testTasks.add(new Task("Android Dev", "Learning", new Date(118, 2, 6, 9, 28), new Date(118, 2, 6, 12, 1)));
        testTasks.add(new Task("Schedule", "Productive", new Date(118, 2, 6, 12, 1), new Date(118, 2, 6, 12, 21)));
        testTasks.add(new Task("Fun", "Entertainment", new Date(118, 2, 6, 12, 21), new Date(118, 2, 6, 12, 58)));
        testTasks.add(new Task("Spanish Movie", "Spanish", new Date(118, 2, 6, 12, 58), new Date(118, 2, 6, 14, 25)));
        testTasks.add(new Task("Spanish Game", "Spanish", new Date(118, 2, 6, 14, 25), new Date(118, 2, 6, 16, 11)));
        testTasks.add(new Task("Stair Master", "Exercise", new Date(118, 2, 6, 16, 11), new Date(118, 2, 6, 17, 40)));
        testTasks.add(new Task("Watch Soccer", "Entertainment", new Date(118, 2, 6, 17, 40), new Date(118, 2, 6, 18, 4)));
        testTasks.add(new Task("Shower", "Mandatory", new Date(118, 2, 6, 18, 4), new Date(118, 2, 6, 18, 35)));
        testTasks.add(new Task("Dinner", "Mandatory", new Date(118, 2, 6, 18, 35), new Date(118, 2, 6, 19, 2)));
        testTasks.add(new Task("Game of Thrones", "Social", new Date(118, 2, 6, 19, 2), new Date(118, 2, 6, 20, 47)));
        testTasks.add(new Task("Rocket League", "Entertainment", new Date(118, 2, 6, 20, 47), new Date(118, 2, 6, 22, 56)));
        testTasks.add(new Task("Twitch", "Entertainment", new Date(118, 2, 6, 22, 56), new Date(118, 2, 7, 0, 0)));

        for (Task t: testTasks){
            addTask(t);
        }
    }
}
