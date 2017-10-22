package com.pawel.pierwszal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by uczen on 2017-10-01.
 */

public class MenActivity extends AppCompatActivity {
    private Button przycisk1;
    private Button przycisk2;
    private Button przycisk3;
    private Button przycisk4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        przycisk1 = (Button) findViewById(R.id.b1);
        przycisk2 = (Button) findViewById(R.id.b2);
        przycisk3 = (Button) findViewById(R.id.b3);
        przycisk4 = (Button) findViewById(R.id.b4);

        przycisk1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Zad3Activity.class);
                startActivity(intent);
            }
        });
        przycisk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Zad9Ac.class);
                startActivity(intent);
            }
        });
        przycisk3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        przycisk4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PierwszaActivity.class);
                startActivity(intent);
            }
        });
    }
}
