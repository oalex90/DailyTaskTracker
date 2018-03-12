package com.example.oalex.dailytasktracker;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by oalex on 3/4/2018.
 */

public class ListScheduleAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Task> mDataSource;

    public ListScheduleAdapter(Context context, ArrayList<Task> items){
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    //@TargetApi(23)
    public View getView(int position, View convertView, ViewGroup parent) {
        //Get view for row item
        View rowView = mInflater.inflate(R.layout.schedule_list_row, parent, false);

        final TextView timeTextView =(TextView) rowView.findViewById(R.id.schedule_list_row_time);
        final TextView taskNameTextView = (TextView) rowView.findViewById(R.id.schedule_list_row_name);
        final TextView taskDurationTextView = (TextView) rowView.findViewById(R.id.schedule_list_row_duration);
        final TextView startEndTimeTextView = (TextView) rowView.findViewById(R.id.schedule_list_row_start_end_time);
        final TextView startDateTextView = (TextView) rowView.findViewById(R.id.schedule_list_row_start_date);
        final TextView dailyTotalTextView = (TextView) rowView.findViewById(R.id.schedule_list_row_daily_total);
        final Button editButton = (Button) rowView.findViewById(R.id.schedule_list_row_edit);
        final LinearLayout taskLayout = (LinearLayout) rowView.findViewById(R.id.schedule_list_row_task_layout);

        final Task task = (Task) getItem(position);

        final SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.US);
        final SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE MMM d, yyyy", Locale.US);
        timeTextView.setText(timeFormat.format(task.getStartTime()));

        taskNameTextView.setText(task.getName() + " - " + task.getCategory());
        taskNameTextView.setTextColor(Color.parseColor(task.calcTextColor()));

        taskDurationTextView.setText("(" + task.calcDuration() +")");
        taskDurationTextView.setTextColor(Color.parseColor(task.calcTextColor()));


        startDateTextView.setText(dateFormat.format(task.getStartTime()));
        startDateTextView.setTextColor(Color.parseColor(task.calcTextColor()));

        startEndTimeTextView.setText(timeFormat.format(task.getStartTime()) + " - " + timeFormat.format(task.getEndTime()));
        startEndTimeTextView.setTextColor(Color.parseColor(task.calcTextColor()));

        dailyTotalTextView.setText("Day Total: 3 hours 25 minutes");
        dailyTotalTextView.setTextColor(Color.parseColor(task.calcTextColor()));

        taskLayout.setBackgroundColor(Color.parseColor(task.calcBackgroundColor()));

        taskLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

/*               TextView startEndTimeTextView = (TextView) view.findViewById(R.id.schedule_list_row_start_end_time);
                TextView dailyTotalTextView = (TextView) view.findViewById(R.id.schedule_list_row_daily_total);
                Button editButton = (Button) view.findViewById(R.id.schedule_list_row_edit);*/

                if (startEndTimeTextView.getVisibility() != View.VISIBLE){
                    startEndTimeTextView.setVisibility(View.VISIBLE);
                    startDateTextView.setVisibility(View.VISIBLE);
                    dailyTotalTextView.setVisibility(View.VISIBLE);
                    editButton.setVisibility(View.VISIBLE);
                }
                else{
                    startEndTimeTextView.setVisibility(View.GONE);
                    dailyTotalTextView.setVisibility(View.GONE);
                    startDateTextView.setVisibility(View.GONE);
                    editButton.setVisibility(View.GONE);
                }
            }
        });


        editButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
/*              LinearLayout parentLayout=(LinearLayout) view.getParent();
                final TextView taskNameTextView = (TextView) parentLayout.findViewById(R.id.schedule_list_row_name);
                final TextView startEndTimeTextView = (TextView) parentLayout.findViewById(R.id.schedule_list_row_start_end_time);*/

                /*String taskNameAndCategory[] = taskNameTextView.getText().toString().split(" - ", 2);
                String taskName = taskNameAndCategory[0];
                String taskCategory = taskNameAndCategory[1];

                String taskStartAndEndTime[] = startEndTimeTextView.getText().toString().split(" - ", 2);
                String taskStartTime = taskStartAndEndTime[0];
                String taskEndTime = taskStartAndEndTime[1];*/


                AlertDialog alertDialog = new AlertDialog.Builder(mContext).create();
                LayoutInflater inflater = LayoutInflater.from(mContext);
                View alertView = inflater.inflate(R.layout.edit_task_dialog, null);

                final EditText taskNameEditView = alertView.findViewById(R.id.edit_text_task_name);
                final EditText taskCategoryEditView = alertView.findViewById(R.id.edit_text_task_category);
                final DatePicker taskStartDatePicker = alertView.findViewById(R.id.date_picker_task_start_date);
                final TimePicker taskStartTimePicker = alertView.findViewById(R.id.time_picker_task_start_time);
                final DatePicker taskEndDatePicker = alertView.findViewById(R.id.date_picker_task_end_date);
                final TimePicker taskEndTimePicker = alertView.findViewById(R.id.time_picker_task_end_time);

                taskNameEditView.setText(task.getName());
                taskCategoryEditView.setText(task.getCategory());
                Date startTime = task.getStartTime();
                Date endTime = task.getEndTime();
                taskStartDatePicker.updateDate(startTime.getYear()+1900, startTime.getMonth(), startTime.getDate());
                taskStartTimePicker.setCurrentHour(startTime.getHours());
                taskStartTimePicker.setCurrentMinute(startTime.getMinutes());
                taskEndDatePicker.updateDate(endTime.getYear()+1900, endTime.getMonth(), endTime.getDate());
                taskEndTimePicker.setCurrentHour(endTime.getHours());
                taskEndTimePicker.setCurrentMinute(endTime.getMinutes());

                alertDialog.setView(alertView);

                alertDialog.setTitle("Edit Task");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Confirm", new DialogInterface.OnClickListener(){
                   public void onClick(DialogInterface dialog, int which){
/*                     EditText taskNameEditView = ((AlertDialog) dialog).findViewById(R.id.edit_text_task_name);
                       EditText taskCategoryEditView = ((AlertDialog) dialog).findViewById(R.id.edit_text_task_category);
                       EditText taskStartTimeEditView = ((AlertDialog) dialog).findViewById(R.id.edit_text_task_start_time);
                       EditText taskEndTimeEditView = ((AlertDialog) dialog).findViewById(R.id.edit_text_task_end_time);*/
                       task.setName(taskNameEditView.getText().toString());
                       task.setCategory(taskCategoryEditView.getText().toString());
                       task.getStartTime().setYear(taskStartDatePicker.getYear()-1900);
                       task.getStartTime().setMonth(taskStartDatePicker.getMonth());
                       task.getStartTime().setDate(taskStartDatePicker.getDayOfMonth());
                       task.getStartTime().setHours(taskStartTimePicker.getCurrentHour());
                       task.getStartTime().setMinutes(taskStartTimePicker.getCurrentMinute());
                       task.getEndTime().setYear(taskEndDatePicker.getYear()-1900);
                       task.getEndTime().setMonth(taskEndDatePicker.getMonth());
                       task.getEndTime().setDate(taskEndDatePicker.getDayOfMonth());
                       task.getEndTime().setHours(taskEndTimePicker.getCurrentHour());
                       task.getEndTime().setMinutes(taskEndTimePicker.getCurrentMinute());



                       //taskNameTextView.setText(taskNameEditView.getText().toString() + " - " + taskCategoryEditView.getText().toString());
                      // startEndTimeTextView.setText(taskStartTimeEditView.getText().toString() + " - " + taskEndTimeEditView.getText().toString());

                       timeTextView.setText(timeFormat.format(task.getStartTime()));

                       taskNameTextView.setText(task.getName() + " - " + task.getCategory());
                       taskNameTextView.setTextColor(Color.parseColor(task.calcTextColor()));

                       taskDurationTextView.setText("(" + task.calcDuration() +")");
                       taskDurationTextView.setTextColor(Color.parseColor(task.calcTextColor()));

                       startDateTextView.setText(dateFormat.format(task.getStartTime()));
                       startDateTextView.setTextColor(Color.parseColor(task.calcTextColor()));

                       startEndTimeTextView.setText(timeFormat.format(task.getStartTime()) + " - " + timeFormat.format(task.getEndTime()));
                       startEndTimeTextView.setTextColor(Color.parseColor(task.calcTextColor()));

                       dailyTotalTextView.setText("3 hours 25 minutes");
                       dailyTotalTextView.setTextColor(Color.parseColor(task.calcTextColor()));

                       taskLayout.setBackgroundColor(Color.parseColor(task.calcBackgroundColor()));

                       DatabaseHandler db = new DatabaseHandler(mContext);
                       db.updateTask(task);
                       db.close();
                       dialog.dismiss();
                   }
                });
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){
                        dialog.dismiss();
                    }
                });
                alertDialog.show();

            }
        });

        return rowView;
    }
}
