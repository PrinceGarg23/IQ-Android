package com.example.iqapp;

public class Event {
    private String date;
    private String name;
    private String poster;
    private String url;

    public Event(){}

    public Event(String date,String name,String poster,String url){

        this.date =date;
        this.name =name;
        this.poster=poster;
        this.url=url;
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

    public String getUrl() { return url; }
}
