package com.example.classprojcalender;

import java.time.LocalTime;
import java.util.ArrayList;

public class Event_Hour {    LocalTime time;
    ArrayList<Event> events;

    public Event_Hour(LocalTime time, ArrayList<Event> events)
    {
        this.time = time;
        this.events = events;
    }

    public LocalTime getTime()
    {
        return time;
    }

    public void setTime(LocalTime time)
    {
        this.time = time;
    }

    public ArrayList<Event> getEvents()
    {
        return events;
    }

    public void setEvents(ArrayList<Event> events)
    {
        this.events = events;
    }
}
