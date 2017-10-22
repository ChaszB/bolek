package com.pawel.pierwszal;

import android.support.annotation.Nullable;
import android.support.v4.app.BundleCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zad310);


       recycler = (RecyclerView) findViewById(R.id.recycler);

        List<Integer> data = new LinkedList<>();
        for (int i = 0; i<60 ;i++){
            data.add(i);
        }

        IntAdapter adapter = new IntAdapter(this, data);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));


    }
}
