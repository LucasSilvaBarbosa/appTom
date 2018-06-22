package com.example.lucas.apptom.service;

import android.os.AsyncTask;

import com.example.lucas.apptom.Model.Poltrona;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class ListaPoltronasService extends AsyncTask<String,Void,List<Poltrona>> {
    @Override
    protected List<Poltrona> doInBackground(String... param) {

        URL url = null;
        try {
            url = new URL("https://service.davesmartins.com.br/api/voo/"+param[0]+"/poltronas");

            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(95 * 1000);
            urlConnection.setConnectTimeout(95 * 1000);
            urlConnection.setDoInput(true);
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("code", param[1]);
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
                finalJson = urlConnection.getResponseCode()+"";
            }

            Type listType = new TypeToken<List<Poltrona>>() {}.getType();

            List<Poltrona> lista = new Gson().fromJson(finalJson.toString(),listType);

            return lista;

        } catch (MalformedURLException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
    }
}
