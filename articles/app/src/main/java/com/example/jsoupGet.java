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
        String text, author, title;
        Document document;
        article article = new article();
        try {
            document = (Document) Jsoup.connect(mURL).get();
            // Elements AR = document.select("div.article_show");
            // AR = document.getElementById("article_show");
            Elements marticle = document.select("div.articleContent");
            text = marticle.text();
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
        String text, author, title;
        Document document;
        article article = new article();
        try {
            document = (Document) Jsoup.connect("http://meiriyiwen.com/random").get();
            // Elements AR = document.select("div.article_show");
            // AR = document.getElementById("article_show");
            Elements marticle = document.select("div.article_text");
            text = marticle.text();
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
        Document document;
        List<book> bookList1 = new ArrayList<>();

        try {
            document = (Document) Jsoup.connect("http://book.meiriyiwen.com").get();
            Elements articleElements = document.select("table.content").select("tr.books");
            for (int i = 0; i < articleElements.size(); i++) {
                book book = new book();
                Element articleElement = articleElements.get(i);
                Elements titleElement = articleElement.select("div.book-name");
                Elements authorElement = articleElement.select("div.book-author");
                String imageElement="http://book.meiriyiwen.com" + articleElement.select("a").select("img").attr("src").replace("_250","");
                String bookTitle = titleElement.text();
                String bookAuthor = authorElement.text();
                String imageURL=imageElement;
                Log.i("title", bookTitle);
                book.setTitle(bookTitle);
                book.setAuthor(bookAuthor);
                book.setImageURL(imageURL);
                bookList1.add(book);

            }
            } catch(IOException e){
                e.printStackTrace();
            }
            return bookList1;
        }
    public List<music> getMusics() {
        String author, title,reader, imageURL;
        Document document;
        List<music> musicList1 = new ArrayList<>();

        try {
            document = (Document) Jsoup.connect("http://voice.meiriyiwen.com").get();
            Elements musicElements = document.getElementsByClass("voice_card");
            for (int i = 0; i < musicElements.size(); i++) {
                music music=new music();
                Element articleElement = musicElements.get(i);
                Elements titleElement = articleElement.select("div.voice_title");
                Elements authorElement = articleElement.select("div.voice_author");
                String imageElement="http://voice.meiriyiwen.com" + articleElement.select("a").select("img").attr("src").replace("_250","");
                String musicTitle = titleElement.text();
                String musicAuthor = authorElement.text();
                imageURL=imageElement;
                Log.i("title", musicTitle);
                music.setTitle(musicTitle);
                music.setAuthor(musicAuthor);
                music.setImageURL(imageURL);
                musicList1.add(music);

            }
        } catch(IOException e){
            e.printStackTrace();
        }
        return musicList1;
    }
   /* public List<menu> getMenus() {
        String author, title;
        Document document;
        List<book> bookList1 = new ArrayList<>();

        try {
            document = (Document) Jsoup.connect("http://book.meiriyiwen.com").get();
            Elements articleElements = document.select("table.content").select("tr.books");
            for (int i = 0; i < articleElements.size(); i++) {
                book book = new book();
                Element articleElement = articleElements.get(i);
                Elements titleElement = articleElement.select("div.book-name");
                Elements authorElement = articleElement.select("div.book-author");
                String imageElement="http://book.meiriyiwen.com" + articleElement.select("a").select("img").attr("src").replace("_250","");
                String bookTitle = titleElement.text();
                String bookAuthor = authorElement.text();
                String imageURL=imageElement;
                Log.i("title", bookTitle);
                book.setTitle(bookTitle);
                book.setAuthor(bookAuthor);
                book.setImageURL(imageURL);
                bookList1.add(book);

            }
        } catch(IOException e){
            e.printStackTrace();
        }
        return bookList1;
    }*/
    }
