package com.example;

/**
 * Created by ASUS on 2018/3/25.
 */

public class book {
    private String title;
    private String author;
    private String imageURL;
    private String menuURL;
    private String menuImageURL;

    public String getMenuURL() {
        return menuURL;
    }

    public void setMenuURL(String menuURL) {
        this.menuURL = menuURL;
    }

    public String getMenuImageURL() {
        return menuImageURL;
    }

    public void setMenuImageURL(String menuImageURL) {
        this.menuImageURL = menuImageURL;
    }

    public book(String title, String author, String imageURL){
        this.title=title;
        this.author=author;
        this.imageURL=imageURL;
    }

    public book(){}
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
