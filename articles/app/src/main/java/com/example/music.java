package com.example;

/**
 * Created by ASUS on 2018/3/24.
 */

public class music {

    private String title;
    private String author;
    private String reader;
    private int imageId;
    public music(String title,String author,String reader,int imageId ){
        this.title=title;
        this.author=author;
        this.reader=reader;
        this.imageId=imageId;
    }

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

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
