package com.pawel.pierwszal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by uczen on 2017-10-01.
 */

public class SecActivity extends AppCompatActivity{

    private TextView tekst;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.z15);
        tekst = (TextView) findViewById(R.id.widok);


        Intent intent =getIntent();
        if (intent != null) {
            String str =intent.getStringExtra("dane");
            tekst.setText(str);
        }



    }
}
