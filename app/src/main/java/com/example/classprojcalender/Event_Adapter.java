package com.example.classprojcalender;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
import java.util.Objects;

public class Event_Adapter extends ArrayAdapter<Event> {    public Event_Adapter(@NonNull Context context, List<Event> events)
{
    super(context, 0, events);
}

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        Event event = getItem(position);

        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.event_cell, parent, false);



        TextView eventCellTV = convertView.findViewById(R.id.eventCellTV);

        if (Objects.equals(event.getColor(), "black"))
        {

            eventCellTV.setTextColor(Color.BLACK);
        }


        String eventTitle = event.getName() +" "+ Cal_Utils.formattedTime(event.getTime());
        eventCellTV.setText(eventTitle);
        return convertView;
    }
}
