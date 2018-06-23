package com.example.lucas.apptom;

import android.content.Intent;
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

    String token,poltrona,idVoo;
    EditText edtCartao,edtMes,edtAno,edtTarja;
    Button btnComprar;
    TextView txtAssento,txtValor,txtOrigem,txtDestino;
    Poltrona pol;
    String valor;
    Voo v;
    final static int Tela_Compra_Poltrona = 20;


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

            txtAssento.setText("Assento: "+pol.getAssento());
        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(), "Erro no Serviço", Toast.LENGTH_SHORT).show();
        }

        btnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edtCartao.getText().toString().length() != 16){
                    edtCartao.setError("Informe 16 digitos");
                }
                else if(edtMes.getText().toString().length() > 2){
                    edtMes.setError("Mes invalido");
                }
                else if(edtAno.getText().toString().length() != 4){
                    edtAno.setError("Informe 4 digitos");
                }
                else if(edtTarja.getText().toString().length() != 3){
                    edtTarja.setError("Informe 3 digitos");
                }
                else {
                    try {
                        CartaoCreditoService cartaoServico = new CartaoCreditoService();

                        CartaoCredito c = cartaoServico.execute(edtCartao.getText().toString(), edtMes.getText().toString(), edtAno.getText().toString(), edtTarja.getText().toString(), valor).get();

                        if (c.getStatus().equals("APROVADO")) {
                            ConfirmarAssentoService confirmacao = new ConfirmarAssentoService();

                            confirmacao.execute(idVoo, poltrona, token);

                            Intent itn = new Intent(getApplicationContext(),ConfirmaCompraActivity.class);

                            itn.putExtra("pol", poltrona);
                            itn.putExtra("idVoo", idVoo);
                            itn.putExtra("token", token);

                            startActivityForResult(itn,Tela_Compra_Poltrona);

                            finish();


                        } else {
                            Toast.makeText(getApplicationContext(), "Cartao Recusado", Toast.LENGTH_SHORT).show();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
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
