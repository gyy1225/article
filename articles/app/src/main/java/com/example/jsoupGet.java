package com.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by ASUS on 2018/3/26.
 */

public class jsoupGet {
    private Document document;
    public jsoupGet(String mURL) {
        document = (Document) Jsoup.connect("mURL");
//在下载的document里进行检索的语句
    }
    public String getArticle(){
        Elements marticle = document.select("#article_show ")
                .select("div.article_text");
        String articles = marticle.toString();//将标签转化成字符串
        // String text=test.text();//将标签里的文本提取出来
        return articles;
    }
    public int getBookImage(){
        Elements mBookImage=document.select("#container" ).select("div.content")
                .select("div.list-bg");
        return 0;
    }
    public String getBookTitle(){
        Elements mBookTitle = document.select("#container")
                .select("div.content").select("div.list-bg").select("div.book-name");
        String bookTitle=mBookTitle.toString();
        return bookTitle;
    }
    public String getBookAuthor(){
        Elements mBookAuthor = document.select("#container")
                .select("div.content").select("div.list-bg").select("div.book-author");
        String bookAuthor=mBookAuthor.toString();
        return bookAuthor;
    }
    public String getMusicAuthor(){
        Elements mMudicAuthor = document.select("#container")
                .select("div.content").select("div.list-bg").select("div.book-author");
        String musicAuthor=mMudicAuthor.toString();

        return musicAuthor;
    }
}

