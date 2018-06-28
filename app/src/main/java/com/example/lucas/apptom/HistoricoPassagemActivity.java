package com.example.lucas.apptom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.lucas.apptom.Model.Passagem;
import com.example.lucas.apptom.Model.Usuario;
import com.example.lucas.apptom.service.HistoricoService;
import com.google.gson.Gson;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class HistoricoPassagemActivity extends AppCompatActivity {

    List<Passagem> passagens;
    Usuario user;
    ListView lstHistorico;
    TextView usuarioLogado;
    Button btnVoltar;
    String token="",id="",resp="",nome="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_passagem);

        binding();

        Gson gson = new Gson();

        id = getIntent().getExtras().getString("id");

        token = getIntent().getExtras().getString("token");

        nome = getIntent().getExtras().getString("nome");

        usuarioLogado.setText(""+nome);
        try{
               resp = new HistoricoService().execute(id,token).get();
               user = gson.fromJson(resp, Usuario.class);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } catch (ExecutionException e1) {
            e1.printStackTrace();
        }

        String [] vet = new String [user.getPassagens().size()];
        int i = 0;
        for(Passagem p: user.getPassagens()){
            vet[i++] = "Data do voo: "+p.getDataVoo()+"\n"+"Origem: "+p.getOrigem().getCidade()+"\n"+"Destino: "+p.getDestino().getCidade()+"\n"+"Valor: "+p.getValorPassagem();
        }
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,vet);

        lstHistorico.setAdapter(adapter);


    }

    private void binding() {
        lstHistorico = findViewById(R.id.lstHistoricoUsuario);
        usuarioLogado = findViewById(R.id.txtUsuarioLogadoHistorico);
        btnVoltar = findViewById(R.id.btnVoltarHistorico);

    }
}
