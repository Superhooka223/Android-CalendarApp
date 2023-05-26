package com.example.classprojcalender;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

public class Event {
    public static ArrayList<Event> eventsList = new ArrayList<>();
    private String name;
    private LocalDate localdate;
    private LocalTime localtime;
    private Date date;
    private Time time;
    private String color;

    public static ArrayList<Event> eventsForDate(LocalDate date)
    {
        ArrayList<Event> events = new ArrayList<>();

        for(Event event : eventsList)
        {
            if(event.getDate().equals(date))
                events.add(event);
        }

        return events;
    }

    public static ArrayList<Event> eventsForDateAndTime(LocalDate date, LocalTime time)
    {
        ArrayList<Event> events = new ArrayList<>();

        for(Event event : eventsList)
        {
            int eventHour = event.localtime.getHour();
            int cellHour = time.getHour();
            if(event.getDate().equals(date) && eventHour == cellHour)
                events.add(event);
        }

        return events;
    }

    public Event(String name, Date date, Time time, String color)
    {
        this.name = name;
        this.date = date;
        this.time = time;
        this.color = color;
    }

    public String getName()
    {
        return name;
    }

    public String getColor() {return color;}

    public void setName(String name)
    {
        this.name = name;
    }

    public LocalDate getDate()
    {
        return localdate;
    }

    public void setDate(LocalDate date)
    {
        this.localdate = date;
    }

    public LocalTime getTime()
    {
        return localtime;
    }

    public void setTime(LocalTime time)
    {
        this.localtime = time;
    }
}
