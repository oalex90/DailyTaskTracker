package com.example.oalex.dailytasktracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView scheduleListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scheduleListView = (ListView) findViewById(R.id.list_schedule);

        ArrayList <Task> scheduleTasks = new ArrayList<Task>();
        scheduleTasks.add(new Task("Sleep", "Mandatory", new Date(2018, 3, 4, 0, 0), new Date(2018, 3, 4, 8, 4)));
        scheduleTasks.add(new Task("Reddit", "Entertainment", new Date(2018, 3, 4, 8, 4), new Date(2018, 3, 4, 8, 35)));
        scheduleTasks.add(new Task("Breakfast", "Mandatory", new Date(2018, 3, 4, 8, 35), new Date(2018, 3, 4, 9, 28)));
        scheduleTasks.add(new Task("Android Dev", "Learning", new Date(2018, 3, 4, 9, 28), new Date(2018, 3, 4, 12, 1)));
        scheduleTasks.add(new Task("Schedule", "Productive", new Date(2018, 3, 4, 12, 01), new Date(2018, 3, 4, 12, 21)));
        scheduleTasks.add(new Task("Fun", "Entertainment", new Date(2018, 3, 4, 12, 21), new Date(2018, 3, 4, 12, 58)));
        scheduleTasks.add(new Task("Spanish Movie", "Spanish", new Date(2018, 3, 4, 12, 58), new Date(2018, 3, 4, 14, 25)));
        scheduleTasks.add(new Task("Spanish Game", "Spanish", new Date(2018, 3, 4, 14, 25), new Date(2018, 3, 4, 16, 11)));
        scheduleTasks.add(new Task("Stair Master", "Exercise", new Date(2018, 3, 4, 16, 11), new Date(2018, 3, 4, 17, 40)));
        scheduleTasks.add(new Task("Watch Soccer", "Entertainment", new Date(2018, 3, 4, 17, 40), new Date(2018, 3, 4, 18, 4)));
        scheduleTasks.add(new Task("Shower", "Mandatory", new Date(2018, 3, 4, 18, 4), new Date(2018, 3, 4, 18, 35)));
        scheduleTasks.add(new Task("Dinner", "Mandatory", new Date(2018, 3, 4, 18, 35), new Date(2018, 3, 4, 19, 2)));
        scheduleTasks.add(new Task("Game of Thrones", "Social Interaction", new Date(2018, 3, 4, 19, 2), new Date(2018, 3, 4, 20, 47)));
        scheduleTasks.add(new Task("Rocket League", "Entertainment", new Date(2018, 3, 4, 20, 47), new Date(2018, 3, 4, 22, 56)));
        scheduleTasks.add(new Task("Twitch", "Entertainment", new Date(2018, 3, 4, 22, 56), new Date(2018, 3, 5, 0, 0)));
        scheduleTasks.add(new Task("Sleep", "Mandatory", new Date(2018, 3, 5, 0, 0), new Date(2018, 3, 5, 8, 4)));
        scheduleTasks.add(new Task("Reddit", "Entertainment", new Date(2018, 3, 5, 8, 4), new Date(2018, 3, 5, 8, 35)));
        scheduleTasks.add(new Task("Breakfast", "Mandatory", new Date(2018, 3, 5, 8, 35), new Date(2018, 3, 5, 9, 28)));
        scheduleTasks.add(new Task("Android Dev", "Learning", new Date(2018, 3, 5, 9, 28), new Date(2018, 3, 5, 12, 1)));
        scheduleTasks.add(new Task("Schedule", "Productive", new Date(2018, 3, 5, 12, 1), new Date(2018, 3, 5, 12, 21)));
        scheduleTasks.add(new Task("Fun", "Entertainment", new Date(2018, 3, 5, 12, 21), new Date(2018, 3, 5, 12, 58)));
        scheduleTasks.add(new Task("Spanish Movie", "Spanish", new Date(2018, 3, 5, 12, 58), new Date(2018, 3, 5, 14, 25)));
        scheduleTasks.add(new Task("Spanish Game", "Spanish", new Date(2018, 3, 5, 14, 25), new Date(2018, 3, 5, 16, 11)));
        scheduleTasks.add(new Task("Stair Master", "Exercise", new Date(2018, 3, 5, 16, 11), new Date(2018, 3, 5, 17, 40)));
        scheduleTasks.add(new Task("Watch Soccer", "Entertainment", new Date(2018, 3, 5, 17, 40), new Date(2018, 3, 5, 18, 4)));
        scheduleTasks.add(new Task("Shower", "Mandatory", new Date(2018, 3, 5, 18, 4), new Date(2018, 3, 5, 18, 35)));
        scheduleTasks.add(new Task("Dinner", "Mandatory", new Date(2018, 3, 5, 18, 35), new Date(2018, 3, 5, 19, 2)));
        scheduleTasks.add(new Task("Game of Thrones", "Social Interaction", new Date(2018, 3, 5, 19, 2), new Date(2018, 3, 5, 20, 47)));
        scheduleTasks.add(new Task("Rocket League", "Entertainment", new Date(2018, 3, 5, 20, 47), new Date(2018, 3, 5, 22, 56)));
        scheduleTasks.add(new Task("Twitch", "Entertainment", new Date(2018, 3, 5, 22, 56), new Date(2018, 3, 6, 0, 0)));
        scheduleTasks.add(new Task("Sleep", "Mandatory", new Date(2018, 3, 6, 0, 0), new Date(2018, 3, 6, 8, 4)));
        scheduleTasks.add(new Task("Reddit", "Entertainment", new Date(2018, 3, 6, 8, 4), new Date(2018, 3, 6, 8, 35)));
        scheduleTasks.add(new Task("Breakfast", "Mandatory", new Date(2018, 3, 6, 8, 35), new Date(2018, 3, 6, 9, 28)));
        scheduleTasks.add(new Task("Android Dev", "Learning", new Date(2018, 3, 6, 9, 28), new Date(2018, 3, 6, 12, 1)));
        scheduleTasks.add(new Task("Schedule", "Productive", new Date(2018, 3, 6, 12, 1), new Date(2018, 3, 6, 12, 21)));
        scheduleTasks.add(new Task("Fun", "Entertainment", new Date(2018, 3, 6, 12, 21), new Date(2018, 3, 6, 12, 58)));
        scheduleTasks.add(new Task("Spanish Movie", "Spanish", new Date(2018, 3, 6, 12, 58), new Date(2018, 3, 6, 14, 25)));
        scheduleTasks.add(new Task("Spanish Game", "Spanish", new Date(2018, 3, 6, 14, 25), new Date(2018, 3, 6, 16, 11)));
        scheduleTasks.add(new Task("Stair Master", "Exercise", new Date(2018, 3, 6, 16, 11), new Date(2018, 3, 6, 17, 40)));
        scheduleTasks.add(new Task("Watch Soccer", "Entertainment", new Date(2018, 3, 6, 17, 40), new Date(2018, 3, 6, 18, 4)));
        scheduleTasks.add(new Task("Shower", "Mandatory", new Date(2018, 3, 6, 18, 4), new Date(2018, 3, 6, 18, 35)));
        scheduleTasks.add(new Task("Dinner", "Mandatory", new Date(2018, 3, 6, 18, 35), new Date(2018, 3, 6, 19, 2)));
        scheduleTasks.add(new Task("Game of Thrones", "Social Interaction", new Date(2018, 3, 6, 19, 2), new Date(2018, 3, 6, 20, 47)));
        scheduleTasks.add(new Task("Rocket League", "Entertainment", new Date(2018, 3, 6, 20, 47), new Date(2018, 3, 6, 22, 56)));
        scheduleTasks.add(new Task("Twitch", "Entertainment", new Date(2018, 3, 6, 22, 56), new Date(2018, 3, 7, 0, 0)));


        ListScheduleAdapter adapter = new ListScheduleAdapter(this, scheduleTasks);
        scheduleListView.setAdapter(adapter);

    }
}
