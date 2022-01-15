package com.example.iqapp;

public class Event {
    private String date;
    private String name;
    private String poster;

    public Event(){}

    public Event(String date,String name,String poster){

        this.date =date;
        this.name =name;
        this.poster=poster;
    }



    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getPoster() {
        return poster;
    }
}
