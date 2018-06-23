package com.example.lucas.apptom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lucas.apptom.Model.Poltrona;
import com.example.lucas.apptom.Model.Voo;
import com.example.lucas.apptom.service.PoltronaService;
import com.example.lucas.apptom.service.VooService;


public class CompraPoltronaActivity extends AppCompatActivity {

    String token,poltrona,idVoo;
    EditText edtCartao,edtMes,edtAno,edtTarja;
    Button btnComprar;
    TextView txtAssento,txtValor,txtOrigem,txtDestino;
    Poltrona pol;
    Voo v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra_poltrona);

        binding();

        token = getIntent().getExtras().getString("token");

        idVoo = getIntent().getExtras().getString("idVoo");

        poltrona = getIntent().getExtras().getString("pol");

        PoltronaService polService = new PoltronaService();

        VooService vooService = new VooService();

        try{
            v = vooService.execute(idVoo,token).get();

            txtValor.setText("Valor: "+v.getValorPassagem());
            txtDestino.setText("Destino: "+v.getDestino().getCidade());
            txtOrigem.setText("Origem: "+v.getOrigem().getCidade());
        }

        catch(Exception e){
            Toast.makeText(getApplicationContext(), "Erro no Serviço", Toast.LENGTH_SHORT).show();
        }

        try{
            pol = polService.execute(idVoo,poltrona,token).get();

            txtAssento.setText("Valor: "+pol.getAssento());
        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(), "Erro no Serviço", Toast.LENGTH_SHORT).show();
        }

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
