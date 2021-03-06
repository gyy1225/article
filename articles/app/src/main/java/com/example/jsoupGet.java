package com.example;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2018/3/26.
 */

public class jsoupGet {

    /*String mURL;

    //传进去url
    public jsoupGet(String mURL) {
        this.mURL = mURL;
    }*/

    public article getArticle(String mURL) {
        // Element AR;
        String text="", author, title;
        Document document;
        article article = new article();
        try {
            document = (Document) Jsoup.connect(mURL).get();
            // Elements AR = document.select("div.article_show");
            // AR = document.getElementById("article_show");
            Elements marticle = document.select("div.articleContent").select("p");
            for (int j=1;j<marticle.size();j++) {
                text = text + "        "+marticle.get(j).text()+"\n"+"\n";
            }
            title = document.select("h2.articleTitle").text();
            author = document.select("div.articleAuthorName").text();
            article.setText(text);
            article.setTitle(title);
            article.setAuthor(author);
            String articles = marticle.toString();//将标签转化成字符串

        } catch (IOException e) {
            Log.e("URL", "URL出错");
            e.printStackTrace();
        }
        // Handler handler=new Handler();
        Message message = new Message();
        //handler.sendMessage(message);
        return article;
    }

    public article getRanArticle() {
        // Element AR;
        String text="", author, title;
        Document document;
        article article = new article();
        try {
            document = (Document) Jsoup.connect("https://meiriyiwen.com/random").get();
            // Elements AR = document.select("div.article_show");
            // AR = document.getElementById("article_show");
            Elements marticle = document.select("div.article_text").select("p");
            for (int j=1;j<marticle.size();j++) {
                text = text + "        "+marticle.get(j).text()+"\n"+"\n";
            }
            title = document.select("h1").text();
            author = document.select("p.article_author").text();
            article.setText(text);
            article.setTitle(title);
            article.setAuthor(author);
            String articles = marticle.toString();//将标签转化成字符串

        } catch (IOException e) {
            Log.e("URL", "URL出错");
            e.printStackTrace();
        }
        // Handler handler=new Handler();
        Message message = new Message();
        //handler.sendMessage(message);
        return article;
    }


    public List<book> getBooks() {
        String author, title;
        String content=" ";
        Document document;
        List<book> bookList1 = new ArrayList<>();

        try {
            for (int j = 1; j <= 8; j++) {
                String murl="http://book.meiriyiwen.com/book?page="+j;
                document = (Document) Jsoup.connect(murl).get();
                Elements articleElements = document.select("table.content").select("tr.books");
                for (int i = 0; i < articleElements.size(); i++) {
                    book book = new book();
                    Element articleElement = articleElements.get(i);
                    Elements titleElement = articleElement.select("div.book-name");
                    Elements authorElement = articleElement.select("div.book-author");
                    String imageElement = "http://book.meiriyiwen.com" + articleElement.select("a").select("img").attr("src").replace("_250", "");
                    String menuElement = "http://book.meiriyiwen.com" + articleElement.getElementsByClass("book-link").select("a").attr("href");
                    String bookTitle = titleElement.text();
                    String bookAuthor = authorElement.text();
                    String imageURL = imageElement;
                    String menuURL = menuElement;
                    Log.i("title", bookTitle);
                    book.setTitle(bookTitle);
                    book.setAuthor(bookAuthor);
                    book.setImageURL(imageURL);
                    book.setMenuURL(menuURL);
                    bookList1.add(book);

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookList1;
        }
    public List<music> getMusics() {
        String author, title, reader, imageURL;
        Document document;
        List<music> musicList1 = new ArrayList<>();

        try {
            for (int j = 1; j <= 5; j++) {

                String murl="http://voice.meiriyiwen.com/voice/past?page="+j;
                document = (Document) Jsoup.connect(murl).get();
                Elements musicElements = document.getElementsByClass("voice_card");
                for (int i = 0; i < musicElements.size(); i++) {
                    music music = new music();
                    Element musicElement = musicElements.get(i);
                    Elements titleElement = musicElement.select("div.voice_title");
                    Elements authorElement = musicElement.select("div.voice_author");
                    String imageElement = "http://voice.meiriyiwen.com" + musicElement.select("a").select("img").attr("src").replace("_250", "");
                    String musicElement1 = "http://voice.meiriyiwen.com" + musicElement.getElementsByClass("voice_title").select("a").attr("href");
                    String musicTitle = titleElement.text();
                    String musicAuthor = authorElement.text();
                    imageURL = imageElement;
                    String musicURL = musicElement1;
                    Log.i("title", musicTitle);
                    music.setTitle(musicTitle);
                    music.setAuthor(musicAuthor);
                    music.setImageURL(imageURL);
                    music.setMusicURL(musicURL);
                    musicList1.add(music);

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return musicList1;
    }
   
    }
