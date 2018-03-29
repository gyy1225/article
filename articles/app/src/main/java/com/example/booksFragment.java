package com.example;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.ListView;

import com.example.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2018/3/25.
 */

public class booksFragment extends Fragment {
    private List<book> mbookList1 = new ArrayList<>();
    private bookAdapter mbookAdapter;
    private ListView mListView;
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    mbookList1 = (List<book>) msg.obj;
                    mbookAdapter = new bookAdapter(getActivity(), R.layout.book_item, mbookList1);
                    mListView.setAdapter(mbookAdapter);
                    break;
            }
        }
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.books_frag, container, false);
        mListView = (ListView) view.findViewById(R.id.lv_book);
        /*listView.setAdapter(mbookAdapter);*/
        initBooks();
        return view;
    }

    private void initBooks() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<book> mBookList=new ArrayList<>();
                jsoupGet jsoupGet3 = new jsoupGet();
                mBookList=jsoupGet3.getBooks();
                Message message = new Message();
                message.what = 1;
                message.obj = mBookList;
                handler.sendMessage(message);
            }


    }).start();



}


}

