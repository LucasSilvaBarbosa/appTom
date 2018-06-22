package com.example.lucas.apptom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.lucas.apptom.Model.Voo;

public class VooActivity extends AppCompatActivity {

    String token,resp = "";
    int idVoo;
    Voo voo;
    TextView txtVooAviao,txtVooData,txtVooOrigem,txtVooDestino,txtVooValor;
    ListView lstListaPoltronas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voo);

        binding();

        token = getIntent().getExtras().getString("token");

        idVoo = getIntent().getExtras().getInt("voo");


    }

    private void binding() {
        lstListaPoltronas = findViewById(R.id.lstPoltronasVoo);
        txtVooAviao = findViewById(R.id.txtAviaoVoo);
        txtVooData = findViewById(R.id.txtDataVoo);
        txtVooOrigem = findViewById(R.id.txtVooOrigem);
        txtVooDestino = findViewById(R.id.txtDestinoVoo);
        txtVooValor = findViewById(R.id.txtVooValor);
    }
}
