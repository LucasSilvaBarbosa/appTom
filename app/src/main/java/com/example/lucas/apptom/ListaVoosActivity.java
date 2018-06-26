package com.example.lucas.apptom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lucas.apptom.Model.Voo;
import com.example.lucas.apptom.service.ListaVoosService;

import java.util.List;

public class ListaVoosActivity extends AppCompatActivity {

    ListView lstVoos;
    List<Voo> voos;
    String token;
    Button btnVoltar;

    final static int Tela_Lista_Voos = 20;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_voos);

        binding();

        token = getIntent().getExtras().getString("token");

        ListaVoosService listavoos = new ListaVoosService();

        try{

            voos = listavoos.execute(token).get();

        } catch(Exception e){
            Toast.makeText(getApplicationContext(), "Erro no Serviço", Toast.LENGTH_SHORT).show();
        }
        String [] vet = new String [voos.size()];
        int i = 0;
        for(Voo v: voos){
            vet[i++] = "Data do voo: "+v.getDataVoo()+"\n"+"Origem: "+v.getOrigem().getCidade()+"\n"+"Destino: "+v.getDestino().getCidade()+"\n"+"Valor: "+v.getValorPassagem();
        }
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,vet);

        lstVoos.setAdapter(adapter);

        lstVoos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                      String voo = voos.get(position).getId();

                      Intent itn = new Intent(getApplicationContext(),VooActivity.class);

                      itn.putExtra("voo",voo);
                      itn.putExtra("token",token);

                      startActivityForResult(itn,Tela_Lista_Voos);

            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(Tela_Lista_Voos);
                finish();
            }
        });

    }

    private void binding() {
        lstVoos = findViewById(R.id.lstListaVoos);
        btnVoltar = findViewById(R.id.btnVoltar);
    }
}
