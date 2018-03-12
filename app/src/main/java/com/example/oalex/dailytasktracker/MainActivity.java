package com.example.oalex.dailytasktracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private ListView scheduleListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scheduleListView = (ListView) findViewById(R.id.list_schedule);

        //Year is years after 1900, Month starts at 0
        ArrayList <Task> scheduleTasks = new ArrayList<Task>();
        scheduleTasks.add(new Task("Sleep", "Mandatory", new Date(118, 2, 4, 0, 0), new Date(118, 2, 4, 8, 4)));
        scheduleTasks.add(new Task("Reddit", "Entertainment", new Date(118, 2, 4, 8, 4), new Date(118, 2, 4, 8, 35)));
        scheduleTasks.add(new Task("Breakfast", "Mandatory", new Date(118, 2, 4, 8, 35), new Date(118, 2, 4, 9, 28)));
        scheduleTasks.add(new Task("Android Dev", "Learning", new Date(118, 2, 4, 9, 28), new Date(118, 2, 4, 12, 1)));
        scheduleTasks.add(new Task("Schedule", "Productive", new Date(118, 2, 4, 12, 01), new Date(118, 2, 4, 12, 21)));
        scheduleTasks.add(new Task("Fun", "Entertainment", new Date(118, 2, 4, 12, 21), new Date(118, 2, 4, 12, 58)));
        scheduleTasks.add(new Task("Spanish Movie", "Spanish", new Date(118, 2, 4, 12, 58), new Date(118, 2, 4, 14, 25)));
        scheduleTasks.add(new Task("Spanish Game", "Spanish", new Date(118, 2, 4, 14, 25), new Date(118, 2, 4, 16, 11)));
        scheduleTasks.add(new Task("Stair Master", "Exercise", new Date(118, 2, 4, 16, 11), new Date(118, 2, 4, 17, 40)));
        scheduleTasks.add(new Task("Watch Soccer", "Entertainment", new Date(118, 2, 4, 17, 40), new Date(118, 2, 4, 18, 4)));
        scheduleTasks.add(new Task("Shower", "Mandatory", new Date(118, 2, 4, 18, 4), new Date(118, 2, 4, 18, 35)));
        scheduleTasks.add(new Task("Dinner", "Mandatory", new Date(118, 2, 4, 18, 35), new Date(118, 2, 4, 19, 2)));
        scheduleTasks.add(new Task("Game of Thrones", "Social", new Date(118, 2, 4, 19, 2), new Date(118, 2, 4, 20, 47)));
        scheduleTasks.add(new Task("Rocket League", "Entertainment", new Date(118, 2, 4, 20, 47), new Date(118, 2, 4, 22, 56)));
        scheduleTasks.add(new Task("Twitch", "Entertainment", new Date(118, 2, 4, 22, 56), new Date(118, 2, 5, 0, 0)));
        scheduleTasks.add(new Task("Sleep", "Mandatory", new Date(118, 2, 5, 0, 0), new Date(118, 2, 5, 8, 4)));
        scheduleTasks.add(new Task("Reddit", "Entertainment", new Date(118, 2, 5, 8, 4), new Date(118, 2, 5, 8, 35)));
        scheduleTasks.add(new Task("Breakfast", "Mandatory", new Date(118, 2, 5, 8, 35), new Date(118, 2, 5, 9, 28)));
        scheduleTasks.add(new Task("Android Dev", "Learning", new Date(118, 2, 5, 9, 28), new Date(118, 2, 5, 12, 1)));
        scheduleTasks.add(new Task("Schedule", "Productive", new Date(118, 2, 5, 12, 1), new Date(118, 2, 5, 12, 21)));
        scheduleTasks.add(new Task("Fun", "Entertainment", new Date(118, 2, 5, 12, 21), new Date(118, 2, 5, 12, 58)));
        scheduleTasks.add(new Task("Spanish Movie", "Spanish", new Date(118, 2, 5, 12, 58), new Date(118, 2, 5, 14, 25)));
        scheduleTasks.add(new Task("Spanish Game", "Spanish", new Date(118, 2, 5, 14, 25), new Date(118, 2, 5, 16, 11)));
        scheduleTasks.add(new Task("Stair Master", "Exercise", new Date(118, 2, 5, 16, 11), new Date(118, 2, 5, 17, 40)));
        scheduleTasks.add(new Task("Watch Soccer", "Entertainment", new Date(118, 2, 5, 17, 40), new Date(118, 2, 5, 18, 4)));
        scheduleTasks.add(new Task("Shower", "Mandatory", new Date(118, 2, 5, 18, 4), new Date(118, 2, 5, 18, 35)));
        scheduleTasks.add(new Task("Dinner", "Mandatory", new Date(118, 2, 5, 18, 35), new Date(118, 2, 5, 19, 2)));
        scheduleTasks.add(new Task("Game of Thrones", "Social", new Date(118, 2, 5, 19, 2), new Date(118, 2, 5, 20, 47)));
        scheduleTasks.add(new Task("Rocket League", "Entertainment", new Date(118, 2, 5, 20, 47), new Date(118, 2, 5, 22, 56)));
        scheduleTasks.add(new Task("Twitch", "Entertainment", new Date(118, 2, 5, 22, 56), new Date(118, 2, 6, 0, 0)));
        scheduleTasks.add(new Task("Sleep", "Mandatory", new Date(118, 2, 6, 0, 0), new Date(118, 2, 6, 8, 4)));
        scheduleTasks.add(new Task("Reddit", "Entertainment", new Date(118, 2, 6, 8, 4), new Date(118, 2, 6, 8, 35)));
        scheduleTasks.add(new Task("Breakfast", "Mandatory", new Date(118, 2, 6, 8, 35), new Date(118, 2, 6, 9, 28)));
        scheduleTasks.add(new Task("Android Dev", "Learning", new Date(118, 2, 6, 9, 28), new Date(118, 2, 6, 12, 1)));
        scheduleTasks.add(new Task("Schedule", "Productive", new Date(118, 2, 6, 12, 1), new Date(118, 2, 6, 12, 21)));
        scheduleTasks.add(new Task("Fun", "Entertainment", new Date(118, 2, 6, 12, 21), new Date(118, 2, 6, 12, 58)));
        scheduleTasks.add(new Task("Spanish Movie", "Spanish", new Date(118, 2, 6, 12, 58), new Date(118, 2, 6, 14, 25)));
        scheduleTasks.add(new Task("Spanish Game", "Spanish", new Date(118, 2, 6, 14, 25), new Date(118, 2, 6, 16, 11)));
        scheduleTasks.add(new Task("Stair Master", "Exercise", new Date(118, 2, 6, 16, 11), new Date(118, 2, 6, 17, 40)));
        scheduleTasks.add(new Task("Watch Soccer", "Entertainment", new Date(118, 2, 6, 17, 40), new Date(118, 2, 6, 18, 4)));
        scheduleTasks.add(new Task("Shower", "Mandatory", new Date(118, 2, 6, 18, 4), new Date(118, 2, 6, 18, 35)));
        scheduleTasks.add(new Task("Dinner", "Mandatory", new Date(118, 2, 6, 18, 35), new Date(118, 2, 6, 19, 2)));
        scheduleTasks.add(new Task("Game of Thrones", "Social", new Date(118, 2, 6, 19, 2), new Date(118, 2, 6, 20, 47)));
        scheduleTasks.add(new Task("Rocket League", "Entertainment", new Date(118, 2, 6, 20, 47), new Date(118, 2, 6, 22, 56)));
        scheduleTasks.add(new Task("Twitch", "Entertainment", new Date(118, 2, 6, 22, 56), new Date(118, 2, 7, 0, 0)));


        ListScheduleAdapter adapter = new ListScheduleAdapter(this, scheduleTasks);
        scheduleListView.setAdapter(adapter);


        DatabaseHandler db = new DatabaseHandler(this);
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy/MM/dd", Locale.US);

        /**
         * CRUD Operations
         */
        /*for (Task t: scheduleTasks){
            db.addTask(t);
        }*/
        logReadAllTasks(db);


        // Reading all tasks
        /*Log.d("Reading: ", "Reading all tasks..");
        ArrayList<Task> tasks = db.getAllTasks();

        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy/MM/dd - hh:mm a", Locale.US);

        for (Task t :tasks){
            String log = "Id: " +t.getId()+", Name: " + t.getName() + ", Category: " + t.getCategory()
                    + ", Start Time: " + dateTimeFormat.format(t.getStartTime())
                    + ", End Time: " + dateTimeFormat.format(t.getEndTime());

            // Writing Tasks to log
            Log.d("Name: ", log);
        }

        Log.d("Deleting: ", "Deleting second task...");
        db.deleteTask(tasks.get(1));
        logReadAllTasks(db);

        Log.d("Updating: ", "Updating first task name...");
        tasks.get(0).setName("Changed Name");
        db.updateTask(tasks.get(0));
        logReadAllTasks(db);

        Log.d("Counting: ", db.getTasksCount() + "tasks found");

        Log.d("Deleting: ", "Deleting all tasks...");
        db.deleteTask(tasks.get(0));
        db.deleteTask(tasks.get(2));

        logReadAllTasks(db);*/



        db.close();


    }

    public void logReadAllTasks(DatabaseHandler db){
        // Reading all tasks
        Log.d("Reading: ", "Reading all tasks..");
        ArrayList<Task> tasks = db.getAllTasks();

        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy/MM/dd - hh:mm a", Locale.US);

        for (Task t :tasks){
            String log = "Id: " +t.getId()+", Name: " + t.getName() + ", Category: " + t.getCategory()
                    + ", Start Time: " + dateTimeFormat.format(t.getStartTime())
                    + ", End Time: " + dateTimeFormat.format(t.getEndTime());

            // Writing Tasks to log
            Log.d("Name: ", log);
        }
    }

}
