package com.example.classprojcalender;

import static com.example.classprojcalender.Cal_Utils.daysInWeekArray;
import static com.example.classprojcalender.Cal_Utils.monthYearFromDate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cal_Week extends AppCompatActivity implements Cal_Adapter.OnItemListener
{
    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    private ListView eventListView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_week);
        initWidgets();
        Cal_Utils.selectedDate = LocalDate.now();
        setWeekView();
    }

    @Override
    public void onItemClick(int position, LocalDate date)
    {
        Cal_Utils.selectedDate = date;
        setWeekView();
    }
    @Override
    protected void onResume()
    {
        super.onResume();
        setEventAdpater();
    }

    private void initWidgets()
    {
        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        monthYearText = findViewById(R.id.monthYearTV);
        eventListView = findViewById(R.id.eventListView);
    }

    private void setWeekView()
    {
        monthYearText.setText(monthYearFromDate(Cal_Utils.selectedDate));
        ArrayList<LocalDate> days = daysInWeekArray(Cal_Utils.selectedDate);

        Cal_Adapter calendarAdapter = new Cal_Adapter(days, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager);
        calendarRecyclerView.setAdapter(calendarAdapter);
        setEventAdpater();
    }

    public void previousWeekAction(View view)
    {
        Cal_Utils.selectedDate = Cal_Utils.selectedDate.minusWeeks(1);
        setWeekView();
    }

    public void nextWeekAction(View view)
    {
        Cal_Utils.selectedDate = Cal_Utils.selectedDate.plusWeeks(1);
        setWeekView();
    }

    private void setEventAdpater()
    {
        ArrayList<Event> dailyEvents = Event.eventsForDate(Cal_Utils.selectedDate);
        Event_Adapter eventAdapter = new Event_Adapter(getApplicationContext(), dailyEvents);
        eventListView.setAdapter(eventAdapter);
    }
    public void newEventAction(View view)
    {
        startActivity(new Intent(this, Event_Edit.class));
    }

    public void dailyAction(View view)
    {
        startActivity(new Intent(this, Cal_Day.class));
    }
}