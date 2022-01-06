package com.example.iqapp;

public class Blog {
    private final String mTitle;
    private final String mLink;
    private final String mThumbnail;
    private final String mDescription;

    public Blog(String title,String thumbnail,String link,String desc){
        mTitle = title;
        mThumbnail = thumbnail;
        mLink = link;
        mDescription = desc;
    }
    public String getTitle(){return mTitle;}
    public String getThumbnail(){return mThumbnail;}
    public String getLink(){return mLink;}
    public String getDescription(){return mDescription;}
}
