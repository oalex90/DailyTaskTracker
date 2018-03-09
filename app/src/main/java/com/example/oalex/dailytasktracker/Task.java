package com.example.oalex.dailytasktracker;

import java.util.Date;

/**
 * Created by oalex on 3/4/2018.
 */

public class Task {
    private int id;
    private String name;
    private String category;
    private Date startTime;
    private Date endTime;

    public Task(){
    }

    public Task(int id, String name, String category, Date startTime, Date endTime){
        this.id = id;
        this.name = name;
        this.category = category;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Task(String name, String category, Date startTime, Date endTime){
        this.name = name;
        this.category = category;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String calcTextColor(){
        switch (this.category){
            case "Mandatory":
                return "#ffffff";
            case "Entertainment":
                return "#000000";
            case "Learning":
                return "#ffffff";
            case "Exercise":
                return "#000000";
            case "Spanish":
                return "#000000";
            case "Social":
                return "#000000";
            case "Productive":
                return "#ffffff";
            default:
                return "#000000";
        }
    }

    public String calcBackgroundColor(){
        switch (this.category){
            case "Mandatory":
                return "#ff0000";
            case "Entertainment":
                return "#00ff00";
            case "Learning":
                return "#0000ff";
            case "Exercise":
                return "#b7b7b7";
            case "Spanish":
                return "#ff9900";
            case "Social":
                return "#00ffff";
            case "Productive":
                return "#ff00ff";
            default:
                return "#ffffff";
        }
    }

    public String calcDuration(){
        //set duration based on start date and end date
        long durMilliseconds = this.endTime.getTime() - this.startTime.getTime();
        long durHours = durMilliseconds/1000/60/60;
        long durMinutes = durMilliseconds/1000/60 % 60;
        if(durHours <1){
            return String.format("%d minutes", durMinutes);
        }
        else{
            return String.format("%d hours %d minutes", durHours, durMinutes);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
