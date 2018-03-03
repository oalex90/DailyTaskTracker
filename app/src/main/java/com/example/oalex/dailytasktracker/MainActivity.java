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

        ArrayList <String[]> scheduleTasks = new ArrayList<String[]>();
        String[] taskOne = {"12:00am", "Sleep - Mandatory"};
        String[] taskTwo = {"12:30am", "Sleep - Mandatory"};
        String[] taskThree = {"1:00am", "Sleep - Mandatory"};
        String[] taskFour = {"1:30am", "Sleep - Mandatory"};
        String[] taskFive = {"2:00am", "Reddit - Entertainment"};
        String[] taskSix = {"2:30am", "Breakfast - Mandatory"};
        String[] taskSeven = {"3:00am", "Breakfast - Mandatory"};
        String[] taskEight = {"3:30am", "Android Dev - Learning"};
        String[] taskNine = {"4:00am", "Android Dev - Learning"};
        String[] taskTen = {"4:30am", "Android Dev - Learning"};
        scheduleTasks.add(taskOne);
        scheduleTasks.add(taskTwo);
        scheduleTasks.add(taskThree);
        scheduleTasks.add(taskFour);
        scheduleTasks.add(taskFive);
        scheduleTasks.add(taskSix);
        scheduleTasks.add(taskSeven);
        scheduleTasks.add(taskEight);
        scheduleTasks.add(taskNine);
        scheduleTasks.add(taskTen);

        String[] taskList = {"12:00am", "1:00am", "2:00am", "3:00am", "4:00am", "5:00am", "6:00am", "7:00am", "8:00am", "9:00am", "10:00am", "11:00am", "12:00pm", "1:00pm", "2:00pm", "3:00pm", "4:00pm", "5:00pm", "6:00pm", "7:00pm", "8:00pm", "9:00pm", "10:00pm", "11:00pm"};

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, taskList);
        scheduleListView.setAdapter(adapter);

    }
}
