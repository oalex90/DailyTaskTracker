package com.example.oalex.dailytasktracker;

import java.util.Date;

/**
 * Created by oalex on 3/4/2018.
 */

public class Task {
    public String name;
    public String category;
    public String time;


    public Task(String time, String name, String category){
        this.name = name;
        this.time = time;
        this.category = category;
    }
}
