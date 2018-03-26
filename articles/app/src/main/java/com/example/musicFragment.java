package com.example;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2018/3/25.
 */

public class musicFragment extends Fragment {
    private List<music> mmusicList=new ArrayList<>();
    private musicAdapter mmusicAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.music_frag, container, false);
        RecyclerView musicView=(RecyclerView)view.findViewById(R.id.rv_music);
        musicView.setLayoutManager(new GridLayoutManager(getActivity(),1));
       // GridLayoutManager layoutManager=new GridLayoutManager(this,1);
        mmusicAdapter = new musicAdapter(mmusicList);
       /* mmusicAdapter.setRecyclerItemClickListener(new OnRecyclerItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                mPresenter.onItemClick(pos);
            }
        });*/
        musicView.setAdapter(mmusicAdapter);

        return view;
    }



}
