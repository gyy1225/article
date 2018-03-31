package com.example;

import java.io.Serializable;

/**
 * Created by ASUS on 2018/3/24.
 */

public class music implements Serializable {

    private String title;
    private String author;
    private String imageURL;
    private String musicURL;

    public String getMusicURL() {
        return musicURL;
    }

    public void setMusicURL(String musicURL) {
        this.musicURL = musicURL;
    }

    public music(String title, String author, String imageURL){
        this.title=title;
        this.author=author;
        this.imageURL=imageURL;
    }

    public music(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}

