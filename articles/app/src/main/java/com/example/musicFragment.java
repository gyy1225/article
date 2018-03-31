package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2018/3/25.
 */

public class musicFragment extends Fragment {
    private List<music> mmusicList1 = new ArrayList<>();
    private musicAdapter mmusicAdapter;
    private RecyclerView musicRecyclerView;

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    mmusicList1 = (List<music>) msg.obj;
                    mmusicAdapter = new musicAdapter(mmusicList1);
                    mmusicAdapter.setOnItemClickListener(new musicAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int pos) {
                            music music = mmusicList1.get(pos);
                            Intent intent7 = new Intent(getContext(), musicPlayActivity.class);
                            intent7.putExtra("thisMusic", music);
                            ( (Activity)getActivity()).startActivity(intent7);
                        }
                    });
                    LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
                    musicRecyclerView.setLayoutManager(layoutManager);
                    musicRecyclerView.setAdapter(mmusicAdapter);
                    break;
            }
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.music_frag, container, false);
        musicRecyclerView  = (RecyclerView) view.findViewById(R.id.rv_music);
        initMusics();

        return view;
    }


    private void initMusics() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<music> mMusicList = new ArrayList<>();
                jsoupGet jsoupGet4 = new jsoupGet();
                mMusicList= jsoupGet4.getMusics();
                Message message = new Message();
                message.what = 1;
                message.obj = mMusicList;
                handler.sendMessage(message);
            }


        }).start();

    }
}
