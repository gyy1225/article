package com.example;

import org.jsoup.nodes.Document;
import org.litepal.crud.DataSupport;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2018/3/25.
 */

public class article extends DataSupport implements Serializable{
    String text;
    String author;
    String title;
    Document document1;
    jsoupGet jsoupGet1;

   public  article(String text,String author,String title){
       this.text=text;
       this.author=author;
       this.title=title;
   }
   public article(){

   }
    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
