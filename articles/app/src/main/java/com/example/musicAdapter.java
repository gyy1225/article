package com.example;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

/**
 * Created by ASUS on 2018/3/24.
 */

public class musicAdapter extends RecyclerView.Adapter<musicAdapter.ViewHolder> {
    private Context mContext;
    private List<music> mMusicList;
    private music music;
    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;

    static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView1;
        ImageView musicImage;
        TextView musicTitle;
        TextView musicAuthor;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView1 = (CardView) itemView;
            musicImage = (ImageView) itemView.findViewById(R.id.music_image);
            musicTitle = (TextView) itemView.findViewById(R.id.music_title);
            musicAuthor = (TextView) itemView.findViewById(R.id.music_author);
        }
    }

    public musicAdapter(List<music> musicList) {
        mMusicList = musicList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.music_item, parent, false);
       /* final ViewHolder holder = new ViewHolder(view);
        holder.cardView1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int position = holder.getLayoutPosition();
                music = mMusicList.get(position);
                Intent intent7 = new Intent(mContext, musicPlayActivity.class);
                intent7.putExtra("thisMusic", music);
                mContext.startActivity(intent7);
            }
        });*/
        return new ViewHolder(view);
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int pos);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View view, int position);
    }






    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        music = mMusicList.get(position);
        final int pos = holder.getLayoutPosition();
        holder.cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (onItemClickListener != null)
                        onItemClickListener.onItemClick(v, pos);
                }

        });

        //holder.musicImage.setImageResource(music.getImageId());
        holder.musicTitle.setText(music.getTitle());
        holder.musicAuthor.setText(music.getAuthor());
        Glide.with(mContext).load(music.getImageURL()).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.musicImage);

    }

    @Override
    public int getItemCount() {
        return mMusicList.size();

    }
}
