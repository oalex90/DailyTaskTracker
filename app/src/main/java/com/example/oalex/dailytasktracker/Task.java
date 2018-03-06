package com.example.oalex.dailytasktracker;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by oalex on 3/4/2018.
 */

public class Task {
    public String name;
    public String category;
    public Date startTime;
    public Date endTime;
    public String backgroundColor;
    public String textColor;
    public String duration;


    public Task(String name, String category, Date startTime, Date endTime){
        this.name = name;
        this.category = category;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = "2 hours 32 minutes";

        //set background color and text color based on category value
        switch (category){
            case "Mandatory":
                this.backgroundColor = "#ff0000";
                this.textColor = "#ffffff";
                break;
            case "Entertainment":
                this.backgroundColor = "#00ff00";
                this.textColor = "#000000";
                break;
            case "Learning":
                this.backgroundColor = "#0000ff";
                this.textColor = "#ffffff";
                break;
            case "Exercise":
                this.backgroundColor = "#b7b7b7";
                this.textColor = "#000000";
                break;
            case "Spanish":
                this.backgroundColor = "#ff9900";
                this.textColor = "#000000";
                break;
            case "Social":
                this.backgroundColor = "#00ffff";
                this.textColor = "#000000";
                break;
            case "Productive":
                this.backgroundColor = "#ff00ff";
                this.textColor = "#ffffff";
                break;
            default:
                this.backgroundColor = "#ffffff";
                this.textColor = "#000000";
        }

        //set duration based on start date and end date
        long durMilliseconds = endTime.getTime() - startTime.getTime();
        long durHours = durMilliseconds/1000/60/60;
        long durMinutes = durMilliseconds/1000/60 % 60;
        if(durHours <1){
            this.duration = String.format("%d minutes", durMinutes);
        }
        else{
            this.duration = String.format("%d hours %d minutes", durHours, durMinutes);
        }

    }
}
