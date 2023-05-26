package com.example.classprojcalender;

import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

import android.widget.EditText;
import android.widget.TextView;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;

public class Event_Edit extends AppCompatActivity
{
    private EditText eventNameET;
    private EditText eventColorET;
    private TextView eventDateTV, eventTimeTV;

    private TextView eventCellBox;

    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
    private LocalTime time;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_event);
        initWidgets();
    }

    private void initWidgets()
    {
        eventNameET = findViewById(R.id.eventNameET);

        eventDateTV = findViewById(R.id.editTextDate);
        eventTimeTV = findViewById(R.id.editTextTime);
        eventColorET = findViewById(R.id.editTextColor);

    }

    public void saveEventAction(View view)
    {
        Date edate = null;
        Time etime = null;
        String eventName = eventNameET.getText().toString();
        String eventDate = eventDateTV.getText().toString();
        String eventTime = eventTimeTV.getText().toString();
        String eventColor = eventColorET.getText().toString();
        try {
            edate = formatter.parse(eventDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            etime = (Time) formatter.parse(eventTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        // int eventTime = eventTimeTV;
        Event newEvent = new Event(eventName, edate , etime, eventColor);
        Event.eventsList.add(newEvent);
        finish();
    }
}