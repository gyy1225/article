package com.example;

import java.io.Serializable;

/**
 * Created by ASUS on 2018/3/29.
 */

public class menu implements Serializable{
   private String menu;
   private String imageURL;
   private String chapterURL;

    public String getChapterURL() {
        return chapterURL;
    }

    public void setChapterURL(String chapterURL) {
        this.chapterURL = chapterURL;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }
}
