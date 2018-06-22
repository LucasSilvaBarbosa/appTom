package com.example.lucas.apptom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class CompraPoltronaActivity extends AppCompatActivity {

    String token,poltrona,idVoo;
    EditText edtCartao,edtMes,edtAno,edtTarja;
    Button btnComprar;
    TextView txtAssento,txtValor,txtOrigem,txtDestino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra_poltrona);

        binding();

        token = getIntent().getExtras().getString("token");

        idVoo = getIntent().getExtras().getString("idVoo");

        poltrona = getIntent().getExtras().getString("pol");
    }

    private void binding() {
        edtCartao = findViewById(R.id.edtCartao);
        edtMes = findViewById(R.id.edtMes);
        edtAno = findViewById(R.id.edtAno);
        edtTarja = findViewById(R.id.edtTarja);
        txtAssento = findViewById(R.id.txtAssentoVoo);
        txtValor = findViewById(R.id.txtValorVooPoltrona);
        txtOrigem = findViewById(R.id.txtOrigemVooPoltrona);
        txtDestino = findViewById(R.id.txtDestinoVooPoltrona);
    }
}
