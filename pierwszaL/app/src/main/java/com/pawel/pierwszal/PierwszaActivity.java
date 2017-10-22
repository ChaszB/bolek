package com.pawel.pierwszal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by uczen on 2017-10-01.
 */

public class PierwszaActivity extends AppCompatActivity {

    private EditText tekst;
    private Button przycisk;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z314);

        tekst = (EditText) findViewById(R.id.text);
        przycisk = (Button) findViewById(R.id.przy);


        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = tekst.getText().toString();
                Intent intent =new Intent(getApplicationContext(),SecActivity.class);
                intent.putExtra("dane",s);
                startActivity(intent);
            }


        });

    }
}