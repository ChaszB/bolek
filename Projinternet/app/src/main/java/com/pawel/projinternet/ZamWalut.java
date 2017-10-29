package com.pawel.projinternet;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by uczen on 2017-10-08.
 */

public class ZamWalut extends AppCompatActivity {
    private TextView result;
    private EditText serchEt;
    private EditText serchWt;
    private Button SerchBt;
    private ProgressBar progress;


    private final String BASE_URL = "http://api.fixer.io/latest?base=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kantor);

        result = (TextView) findViewById(R.id.wynik);
        serchEt = (EditText) findViewById(R.id.kwota);
        serchWt = (EditText) findViewById(R.id.waluta);
        SerchBt = (Button) findViewById(R.id.przelicz);
        progress = (ProgressBar) findViewById(R.id.prog);

        SerchBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = BASE_URL + serchEt.getText().toString();
                Uri uri = Uri.parse(query);
                URL url = null;

                try {
                    url = new URL(uri.toString());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                if (url != null) {
                    new ZamWalutTask().execute(url);
                }

            }
        });
    }

    public class ZamWalutTask extends AsyncTask<URL, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress.setVisibility(View.VISIBLE);
            result.setVisibility(View.INVISIBLE);
        }

        @Override
        protected String doInBackground(URL... urls) {
            URL searchUrl = urls[0];
            String resposne = null;
            try {
                resposne = NetUtils.getResponfromhttpUrl(searchUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return resposne;
        }

        @Override
        protected void onPostExecute(String s) {
            progress.setVisibility(View.INVISIBLE);
            result.setVisibility(View.VISIBLE);

            if (s != null && !s.equals("")) {
                result.setText("");
                try {
                    JSONObject in = new JSONObject(s);

                    JSONObject obj = in.getJSONObject("rates");

                    Double wyn = obj.getDouble(serchWt.getText().toString());
                    result.setText(wyn + "");


                } catch (JSONException e) {
                    e.printStackTrace();
                    result.setText(e.toString());
                }
            } else {
                result.setText("Brak wyników zapytania");
            }
        }


    }

}

