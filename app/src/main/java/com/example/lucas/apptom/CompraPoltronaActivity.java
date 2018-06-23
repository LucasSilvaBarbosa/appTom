package com.example.lucas.apptom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lucas.apptom.Model.CartaoCredito;
import com.example.lucas.apptom.Model.Poltrona;
import com.example.lucas.apptom.Model.Voo;
import com.example.lucas.apptom.service.CartaoCreditoService;
import com.example.lucas.apptom.service.ConfirmarAssentoService;
import com.example.lucas.apptom.service.PoltronaService;
import com.example.lucas.apptom.service.VooService;

import java.util.concurrent.ExecutionException;


public class CompraPoltronaActivity extends AppCompatActivity {

    String token,poltrona,idVoo,resp;
    EditText edtCartao,edtMes,edtAno,edtTarja;
    Button btnComprar;
    TextView txtAssento,txtValor,txtOrigem,txtDestino;
    Poltrona pol;
    String valor;
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

            valor = ""+v.getValorPassagem();

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

        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartaoCreditoService cartaoServico = new CartaoCreditoService();

                try{
                    CartaoCredito c = cartaoServico.execute(edtCartao.getText().toString(),edtMes.getText().toString(),edtAno.getText().toString(),edtTarja.getText().toString(),valor).get();

                    String resp = c.getStatus();

                    if(resp.equals("APROVADO")){
                        ConfirmarAssentoService confirmacao = new ConfirmarAssentoService();

                        confirmacao.execute(idVoo,poltrona,token);

                        Toast.makeText(getApplicationContext(), "Cartão Aceito", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Cartao Recusado", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });

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
        btnComprar = findViewById(R.id.btnComprar);
    }
}
