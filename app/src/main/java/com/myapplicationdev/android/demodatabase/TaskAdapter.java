package com.myapplicationdev.android.demodatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<Task> {
    // ListView
    private ArrayList<Task> task;
    private Context context;
    private TextView tvID, tvDesc, tvDate;


    public TaskAdapter(@NonNull Context context, int resource, ArrayList<Task> objects) {
        super(context, resource, objects);
        // Store the tasks that is passed to this adapter
        task = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView= inflater.inflate(R.layout.row, parent, false);
        // Get the TextViews object
        tvID = (TextView) rowView.findViewById(R.id.tvID);
        tvDesc = (TextView) rowView.findViewById(R.id.tvDesc);
        tvDate = (TextView) rowView.findViewById(R.id.tvDate);

        Task currentTask = task.get(position);

        // Set the TextView to show the food
        tvID.setText(currentTask.getId() + "");
        tvDesc.setText(currentTask.getDescription());
        tvDate.setText(currentTask.getDate());

        // Return the nicely done up View to the ListView
        return rowView;
    }

}
