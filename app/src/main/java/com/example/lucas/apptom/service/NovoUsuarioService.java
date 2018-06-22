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
            //url = new URL("http://localhost:8080/api/usuarios/login");

            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setConnectTimeout(95 * 1000);
            urlConnection.setDoInput(true);
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("X-Environment", "android");

            urlConnection.connect();

            Scanner s = new Scanner(url.openStream());
            StringBuffer resp = new StringBuffer();
            while (s.hasNext()) {
                resp.append(s.next());
            }

            Usuario user = new Gson().fromJson(resp.toString(),Usuario.class);

            return user;

        } catch (MalformedURLException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
    }
}
