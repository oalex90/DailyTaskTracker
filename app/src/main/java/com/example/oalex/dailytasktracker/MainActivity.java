package com.example.oalex.dailytasktracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView scheduleListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scheduleListView = (ListView) findViewById(R.id.list_schedule);

        ArrayList <Task> scheduleTasks = new ArrayList<Task>();
        scheduleTasks.add(new Task("12:00am", "Sleep", "Mandatory"));
        scheduleTasks.add(new Task("1:00am", "Sleep", "Mandatory"));
        scheduleTasks.add(new Task("2:00am", "Sleep", "Mandatory"));
        scheduleTasks.add(new Task("3:00am", "Sleep", "Mandatory"));
        scheduleTasks.add(new Task("4:00am", "Sleep", "Mandatory"));
        scheduleTasks.add(new Task("5:00am", "Sleep", "Mandatory"));
        scheduleTasks.add(new Task("6:00am", "Reddit", "Entertainment"));
        scheduleTasks.add(new Task("7:00am", "Breakfast", "Mandatory"));
        scheduleTasks.add(new Task("8:00am", "Breakfast", "Mandatory"));
        scheduleTasks.add(new Task("9:00am", "Android Dev", "Learning"));
        scheduleTasks.add(new Task("10:00am", "Android Dev", "Learning"));
        scheduleTasks.add(new Task("11:00am", "Android Dev", "Learning"));
        scheduleTasks.add(new Task("12:00pm", "Schedule", "Productive"));
        scheduleTasks.add(new Task("1:00pm", "Sleep", "Mandatory"));
        scheduleTasks.add(new Task("2:00pm", "Sleep", "Mandatory"));
        scheduleTasks.add(new Task("3:00pm", "Sleep", "Mandatory"));
        scheduleTasks.add(new Task("4:00pm", "Sleep", "Mandatory"));
        scheduleTasks.add(new Task("5:00pm", "Sleep", "Mandatory"));
        scheduleTasks.add(new Task("6:00pm", "Reddit", "Entertainment"));
        scheduleTasks.add(new Task("7:00pm", "Breakfast", "Mandatory"));
        scheduleTasks.add(new Task("8:00pm", "Breakfast", "Mandatory"));
        scheduleTasks.add(new Task("9:00pm", "Android Dev", "Learning"));
        scheduleTasks.add(new Task("10:00pm", "Android Dev", "Learning"));
        scheduleTasks.add(new Task("11:00pm", "Android Dev", "Learning"));


        ListScheduleAdapter adapter = new ListScheduleAdapter(this, scheduleTasks);
        scheduleListView.setAdapter(adapter);

    }
}
