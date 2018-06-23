package com.example.lucas.apptom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lucas.apptom.Model.Poltrona;
import com.example.lucas.apptom.Model.Voo;
import com.example.lucas.apptom.service.PoltronaService;
import com.example.lucas.apptom.service.VooService;

public class ConfirmaCompraActivity extends AppCompatActivity {

    String token,poltrona,idVoo;
    TextView txtData,txtOrigem,txtDestino,txtAssento;
    Button btnDeslogar;
    Poltrona pol;
    Voo v;
    final static int Tela_Confirma_Compra = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirma_compra);

        binding();

        token = getIntent().getExtras().getString("token");

        idVoo = getIntent().getExtras().getString("idVoo");

        poltrona = getIntent().getExtras().getString("pol");

        PoltronaService polService = new PoltronaService();

        VooService vooService = new VooService();

        try{
            v = vooService.execute(idVoo,token).get();

            txtDestino.setText("Destino: "+v.getDestino().getAeroporto());
            txtOrigem.setText("Origem: "+v.getOrigem().getAeroporto());
            txtData.setText("Data: "+v.getDataVoo());
        }

        catch(Exception e){
            Toast.makeText(getApplicationContext(), "Erro no Serviço", Toast.LENGTH_SHORT).show();
        }
        try{
            pol = polService.execute(idVoo,poltrona,token).get();

            txtAssento.setText("Assento: "+pol.getAssento());
        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(), "Erro no Serviço", Toast.LENGTH_SHORT).show();
        }

        btnDeslogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setResult(Tela_Confirma_Compra);
                finish();
            }
        });

    }

    private void binding() {
        txtData = findViewById(R.id.txtDataConfirmacao);
        txtOrigem = findViewById(R.id.txtOrigemConfirmacao);
        txtDestino = findViewById(R.id.txtDestinoConfirmacao);
        btnDeslogar = findViewById(R.id.btnDeslogar);
        txtAssento = findViewById(R.id.txtAssentoConfirmacao);

    }
}
