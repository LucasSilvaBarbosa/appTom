package com.example.lucas.apptom.service;

import android.os.AsyncTask;

import com.example.lucas.apptom.Model.Poltrona;
import com.example.lucas.apptom.Model.Voo;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class PoltronaService extends AsyncTask<String,Void,Poltrona> {
    @Override
    protected Poltrona doInBackground(String... param) {

        URL url = null;
        try {
            url = new URL("https://service.davesmartins.com.br/api/voo/"+param[0]+"/poltronas/"+param[1]);

            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(95 * 1000);
            urlConnection.setConnectTimeout(95 * 1000);
            urlConnection.setDoInput(true);
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("code", param[2]);
            urlConnection.setRequestProperty("X-Environment", "android");

            urlConnection.connect();

            String finalJson = "";
            if (urlConnection.getResponseCode() == 200) {
                InputStream responseBody = urlConnection.getInputStream();
                InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");
                BufferedReader reader = new BufferedReader(responseBodyReader);
                StringBuffer buffer = new StringBuffer();
                String line ="";

                while ((line=reader.readLine())!=null){
                    buffer.append(line);
                }

                finalJson = buffer.toString();
            } else {
                finalJson = urlConnection.getResponseCode()+" "+
                        urlConnection.getResponseMessage();
            }
            Poltrona p = new Gson().fromJson(finalJson.toString(),Poltrona.class);

            return p;

        } catch (MalformedURLException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
    }
}
