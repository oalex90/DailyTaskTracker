package com.example.oalex.dailytasktracker;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
    public View getView(int position, View convertView, ViewGroup parent) {
        //Get view for row item
        View rowView = mInflater.inflate(R.layout.schedule_list_row, parent, false);

        TextView timeTextView =(TextView) rowView.findViewById(R.id.schedule_list_row_time);
        TextView taskNameTextView = (TextView) rowView.findViewById(R.id.schedule_list_row_name);
        TextView taskDurationTextView = (TextView) rowView.findViewById(R.id.schedule_list_row_duration);
        LinearLayout taskLayout = (LinearLayout) rowView.findViewById(R.id.schedule_list_row_task_layout);

        Task task = (Task) getItem(position);

        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("hh:mm a");
        timeTextView.setText(dateTimeFormat.format(task.startTime));

        taskNameTextView.setText(task.name + " - " + task.category);
        taskNameTextView.setTextColor(Color.parseColor(task.textColor));

        taskDurationTextView.setText("(" + task.duration +")");
        taskDurationTextView.setTextColor(Color.parseColor(task.textColor));

        taskLayout.setBackgroundColor(Color.parseColor(task.backgroundColor));

        return rowView;
    }
}
