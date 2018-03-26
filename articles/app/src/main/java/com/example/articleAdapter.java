package com.example;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

/**
 * Created by ASUS on 2018/3/25.
 */

public class articleAdapter extends RecyclerView.Adapter<articleAdapter.ViewHolder> {
    private Context mContext;
    private List<article> mArticleList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;
        TextView article;
        Button download;

        public ViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView;
            article = (TextView) itemView.findViewById(R.id.tv_article);
            download = (Button) itemView.findViewById(R.id.btn_download);
        }
    }

    public articleAdapter(List<article> articleList) {
        mArticleList = articleList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.music_item, parent, false);
        return new articleAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        article article = mArticleList.get(position);
        holder.article.setText(article.marticle);
    }

    @Override
    public int getItemCount() {
        return mArticleList.size();
    }

}
