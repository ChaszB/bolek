package com.pawel.mplay;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.pm.ActivityInfoCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MActivityPlay extends AppCompatActivity {


    private static final int Read_From = 1001;

    private Button fromPhonBtn;
    private Button fromUrlBtn;
    private EditText urlEt;

    public MActivityPlay() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mplay);
        fromPhonBtn = (Button) findViewById(R.id.from_tel);
        fromUrlBtn = (Button) findViewById(R.id.from_int);
        urlEt = (EditText) findViewById(R.id.url_et);

        fromUrlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), VideoPlay.class);
                intent.putExtra("video_to_play", urlEt.getText().toString());
                startActivity(intent);
            }
        });


        fromPhonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 23) {
                    int permissionCheck = ContextCompat.checkSelfPermission(getApplicationContext(),
                            Manifest.permission.READ_EXTERNAL_STORAGE);
                    if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                        //nie masz permisji
                        ActivityCompat.requestPermissions(MActivityPlay.this,
                                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                                Read_From);
                    } else {
                        //masz permisje
                        startFile();
                    }

                } else {
                    //android ponizej 6.0
                    startFile();
                }
            }

        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == Read_From) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //masz permisje
                startFile();
            } else {
                //nie masz permisji
                Toast.makeText(getApplicationContext(), "nie da sie nawiazac polaczenia",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void startFile() {
        Intent intent = new Intent(this, FileChoise.class);
        startActivity(intent);

    }
}
