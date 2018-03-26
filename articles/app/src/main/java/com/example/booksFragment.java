package com.example;

import android.os.Bundle;
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
    private List<book> mbookList=new ArrayList<>();
    private bookAdapter mbookAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.books_frag, container, false);
        initBooks();
        mbookAdapter=new bookAdapter(getActivity(),R.layout.book_item,mbookList);
        ListView listView=(ListView)view.findViewById(R.id.lv_book);
        listView.setAdapter(mbookAdapter);
        return view;
    }

    private void initBooks() {
        book book1=new book("大众读者","斯蒂芬",R.drawable.book1);
        mbookList.add(book1);
        book book2=new book("思想的诞生","每日一文精选",R.drawable.book2);
        mbookList.add(book2);
        book book3=new book("神赐福的城市","纪伯伦",R.drawable.book3);
        mbookList.add(book3);
    }
}
