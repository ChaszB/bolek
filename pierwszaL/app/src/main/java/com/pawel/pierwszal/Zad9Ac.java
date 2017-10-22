package com.pawel.pierwszal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.AbstractCollection;

/**
 * Created by uczen on 2017-09-24.
 */

public class Zad9Ac extends AppCompatActivity {

    private EditText tekst;
    private Button przycisk;
    private TextView obraz;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zad9);

        tekst = (EditText) findViewById(R.id.txt);
        przycisk = (Button) findViewById(R.id.bot);
        obraz = (TextView) findViewById(R.id.vie);

        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = tekst.getText().toString();
                obraz.setText(s);
            }
        });

    }
}
