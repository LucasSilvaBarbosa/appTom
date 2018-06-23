package com.example.lucas.apptom.service;

import android.os.AsyncTask;

import com.example.lucas.apptom.Model.Usuario;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class NovoUsuarioService extends AsyncTask<String,Void,Usuario> {

    @Override
    protected Usuario doInBackground(String... param) {

        URL url = null;
        try {
            url = new URL("https://service.davesmartins.com.br/api/usuarios");

            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setConnectTimeout(95 * 1000);
            urlConnection.setDoInput(true);
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("X-Environment", "android");

            String login = "{\"email\": \""+param[0]+"\"," +
                    "\"login\": \""+param[1] + "\"," +
                    "\"nome\": \""+param[2] + "\"," +
                    "\"senha\": \""+param[3] + "\" }";

            urlConnection.setDoOutput(true);
            urlConnection.getOutputStream().write(login.getBytes());

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

            Usuario user = new Gson().fromJson(finalJson.toString(),Usuario.class);

            return user;

        } catch (MalformedURLException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
    }
}
