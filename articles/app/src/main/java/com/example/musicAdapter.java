package com.example;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ASUS on 2018/3/24.
 */

public class musicAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<music> mMusicList;
    static class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView1;
        ImageView musicImage;
        TextView musicTitle;
        TextView musicAuthor;
        TextView musicReader;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView1=(CardView)itemView;
            musicImage=(ImageView)itemView.findViewById(R.id.music_image);
            musicTitle=(TextView)itemView.findViewById(R.id.music_title);
            musicAuthor=(TextView)itemView.findViewById(R.id.music_author);
            musicReader=(TextView)itemView.findViewById(R.id.music_reader);
        }
    }
    public musicAdapter(List<music> musicList){
        mMusicList=musicList;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.music_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
