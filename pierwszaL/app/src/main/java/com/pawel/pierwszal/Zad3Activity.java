package com.pawel.pierwszal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by uczen on 2017-10-01.
 */

public class Zad3Activity extends AppCompatActivity{
private ViewPager paper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z311);

        paper = (ViewPager) findViewById(R.id.viupager);

        List<Book> books = new LinkedList<>();
        books.add(new Book(getResources().getString(R.string.info4),getResources().getString(R.string.info4o)));
        books.add(new Book(getResources().getString(R.string.e13),getResources().getString(R.string.e13o)));
        books.add(new Book(getResources().getString(R.string.cz),getResources().getString(R.string.czo)));

        BooksAdapter adapter = new BooksAdapter(this, books);
        paper.setAdapter(adapter);
    }
}
