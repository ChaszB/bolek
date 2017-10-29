package com.pawel.projinternet;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by uczen on 2017-10-29.
 */

public class SecFrag extends Fragment  implements LoaderManager.LoaderCallbacks<String> {

    private TextView result;
    private EditText serchEt;
    private Button SerchBt;
    private ProgressBar progress;
    private RecyclerView recycler;


    private List<forecast> forecasts = new LinkedList<>();

    private final String APT_KEY = "&APPID=2e78ba94720adbdae6a05c74e178b6aa";
    private final String BASE_URL = "http://api.openweathermap.org/data/2.5/forecast?q=";
    private final int LOADER_id = 24;

    private String jedn = "&units=metric";

    public static SecFrag newIstance(){
        SecFrag fragm = new SecFrag();
        return fragm;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viev = inflater.inflate(R.layout.activity_main, container, false);

        result = (TextView) viev.findViewById(R.id.TSV);
        serchEt = (EditText) viev.findViewById(R.id.ET);
        SerchBt = (Button) viev.findViewById(R.id.But);
        progress = (ProgressBar) viev.findViewById(R.id.prog);
        recycler = (RecyclerView) viev.findViewById(R.id.rec);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(layoutManager);


        recycler.addItemDecoration(new Dekorator(10));

        final LoaderManager.LoaderCallbacks<String> collback = this;
        getActivity().getSupportLoaderManager().initLoader(LOADER_id, null, collback);

        SerchBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (czyInternet()) {
                    String query = BASE_URL + serchEt.getText().toString() + APT_KEY + jedn;
                    Uri uri = Uri.parse(query);
                    URL url = null;

                    try {
                        url = new URL(uri.toString());
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                    if (url != null) {
                        Bundle queryBundle = new Bundle();
                        queryBundle.putString("query", url.toString());

                        Loader<String> stringLoader = getActivity().getSupportLoaderManager().getLoader(LOADER_id);

                        if (stringLoader == null) {
                            getActivity().getSupportLoaderManager().initLoader(LOADER_id, queryBundle, collback);
                        } else {
                            getActivity().getSupportLoaderManager().restartLoader(LOADER_id, queryBundle, collback);
                        }
                    }
                } else {
                    Toast.makeText(getActivity().getApplicationContext(), "Nie masz Internetu", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return viev;
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("pogoda", Context.MODE_PRIVATE);
        String temp = sharedPreferences.getString("jedn", "C");
        if (temp.equals("C")) {
            jedn = "&units=metric";
        } else if (temp.equals("F")) {
            jedn = "&units=imperial";
        } else if (temp.equals("K")) {
            jedn = "&units=default";
        }
    }

    public boolean czyInternet() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        return info != null && info.isConnected();
    }

    @Override
    public Loader<String> onCreateLoader(int id, final Bundle args) {

        return new AsyncTaskLoader<String>(getContext()) {

            @Override
            protected void onStartLoading() {
                super.onStartLoading();
                if (args == null) {
                    return;
                }
                progress.setVisibility(View.VISIBLE);
                result.setVisibility(View.INVISIBLE);

                forceLoad();
            }

            @Override
            public String loadInBackground() {
                String urlString = args.getString("query");
                if (urlString == null || urlString.isEmpty()) {
                    return null;
                }


                try {
                    URL url = new URL(urlString);
                    return NetUtils.getResponfromhttpUrl(url);
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }

            }
        };
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {
        progress.setVisibility(View.INVISIBLE);
        result.setVisibility(View.VISIBLE);

        if (data != null && !data.equals("")) {
            forecasts.clear();
            try {
                JSONObject in = new JSONObject(data);

                JSONObject cityobj = in.getJSONObject("city");
                String city = cityobj.getString("name");

                JSONArray arr = in.getJSONArray("list");
                for (int i = 0; i < arr.length(); i++) {
                    JSONObject obj = arr.getJSONObject(i);


                    String date = obj.getString("dt_txt");
                    JSONObject tempobj = obj.getJSONObject("main");
                    Double tmp = tempobj.getDouble("temp");
                    JSONArray arr1 = obj.getJSONArray("weather");
                    JSONObject weth = arr1.getJSONObject(0);
                    String wether = weth.getString("main");
                    String icon = weth.getString("icon");

                    forecast f = new forecast(city, date, wether, tmp, icon);
                    forecasts.add(f);

                }

                WAdapter adpter = new WAdapter(getActivity().getApplicationContext(), forecasts);
                recycler.setAdapter(adpter);

            } catch (JSONException e) {
                e.printStackTrace();
                result.setText(e.toString());
            }
        } else {
            result.setText("Brak wyników zapytania");
        }
    }

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }
}
