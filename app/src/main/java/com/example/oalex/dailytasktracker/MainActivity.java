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

        DatabaseHandler db = new DatabaseHandler(this);
        if(db.getTasksCount()==0){
            db.addTestTasks();
        }

        ArrayList<Task> scheduleTasks = db.getAllTasks();

        ListScheduleAdapter adapter = new ListScheduleAdapter(this, scheduleTasks);
        scheduleListView.setAdapter(adapter);

        logReadAllTasks(db);
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
