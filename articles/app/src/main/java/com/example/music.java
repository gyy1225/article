package com.example;

/**
 * Created by ASUS on 2018/3/24.
 */

public class music {

    private String title;
    private String author;
    private String reader;
    private String imageURL;
    public music(String title,String author,String reader,String imageURL){
        this.title=title;
        this.author=author;
        this.reader=reader;
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

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}

