package com.pawel.projinternet;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by uczen on 2017-10-08.
 */

public class PAktivity  extends AppCompatActivity{
    private Button cel;
    private Button far;
    private Button kal;
    private Button changs;
    private TextView deg;
    private TextView city;
    private EditText cityEt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ustawienia);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cel =(Button) findViewById(R.id.cel);
        far=(Button) findViewById(R.id.far);
        kal =(Button) findViewById(R.id.kal);
        changs =(Button) findViewById(R.id.change);
        deg =(TextView) findViewById(R.id.deg);
        city =(TextView) findViewById(R.id.city);
        cityEt =(EditText) findViewById(R.id.city_et);



        cel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("pogoda", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("jedn","C");
                editor.commit();
                deg.setText("C");
            }
        });

        far.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("pogoda",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("jedn", "F");
                editor.commit();
                deg.setText("F");
            }
        });

        kal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("pogoda",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("jedn", "K");
                editor.commit();
                deg.setText("K");
            }
        });
        changs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("pogoda",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("citys", cityEt.getText().toString());
                editor.commit();
                city.setText(cityEt.getText().toString());
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("pogoda",Context.MODE_PRIVATE);
        String citys =sharedPreferences.getString("citys","Warszawa");
        String temp = sharedPreferences.getString("jedn","C");

        deg.setText(temp);
        city.setText(citys);
    }
}
