package com.example;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.File;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class musicPlayActivity extends AppCompatActivity implements OnClickListener,
        OnSeekBarChangeListener {
    private Button play, pause, stop;
    String musicURL, imageURL, author, title;
    private MediaPlayer player=new MediaPlayer();
    private SeekBar mSeekBar;
    private ImageView musicImage;
    private TextView tv, tv2, musicTitle, musicAuthor;
    private boolean hadDestroy = false;
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {

            switch (msg.what) {
                case 0x01:


                    break;

                default:
                    break;
            }
        }

        ;
    };
    Runnable runnable = new Runnable() {
        @Override
        public void run() {

            if (!hadDestroy) {
                mHandler.postDelayed(this, 1000);
                int currentTime = Math
                        .round(player.getCurrentPosition() / 1000);
                String currentStr = String.format("%s%02d:%02d", "当前时间 ",
                        currentTime / 60, currentTime % 60);
                tv.setText(currentStr);
                mSeekBar.setProgress(player.getCurrentPosition());
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_play);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        play = (Button) findViewById(R.id.play);
        pause = (Button) findViewById(R.id.pause);
        stop = (Button) findViewById(R.id.stop);
        mSeekBar = (SeekBar) findViewById(R.id.seekbar);
        tv = (TextView) findViewById(R.id.tv);
        tv2 = (TextView) findViewById(R.id.tv2);
        musicImage = (ImageView) findViewById(R.id.music_image1);
        musicTitle = (TextView) findViewById(R.id.music_title1);
        musicAuthor = (TextView) findViewById(R.id.music_author1);
        music music = (music) getIntent().getSerializableExtra("thisMusic");
        String musicURL = music.getMusicURL();
        String imageURL = music.getImageURL();
        String title = music.getTitle();
        String author = music.getAuthor();
        mSeekBar.setOnSeekBarChangeListener(this);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
        musicTitle.setText(title);
        musicAuthor.setText(author);
        Glide.with(musicPlayActivity.this).load(imageURL).centerCrop().diskCacheStrategy(DiskCacheStrategy.ALL).into(musicImage);
        player = new MediaPlayer();
        initMediaplayer(musicURL);
    }

    private void initMediaplayer(String musicURL) {
        try {
            Document document1 = (Document) Jsoup.connect(musicURL).get();
            String musicURL1 = document1.getElementsByClass("p_file").select("audio").attr("src");
            player.setDataSource(musicURL1);
            Log.e("播放器", musicURL1);
            player.prepare();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.play:
                if (!player.isPlaying()) {
                    player.start();
                    int totalTime = Math.round(player.getDuration() / 1000);
                    String str = String.format("%02d:%02d", totalTime / 60,
                            totalTime % 60);
                    tv2.setText(str);
                    mSeekBar.setMax(player.getDuration());
                    mHandler.postDelayed(runnable, 1000);
                }

                break;
            case R.id.pause:
                if (player.isPlaying()) {
                    player.pause();
                }
                break;
            case R.id.stop:
                if (player.isPlaying()) {
                    player.reset();
                    initMediaplayer(musicURL);
                }
                break;

            default:
                break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {
        if (player != null) {
            player.seekTo(seekBar.getProgress());
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.stop();
            hadDestroy = true;
            player.release();
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                musicPlayActivity.this.finish();
        }
        return true;
    }
}
