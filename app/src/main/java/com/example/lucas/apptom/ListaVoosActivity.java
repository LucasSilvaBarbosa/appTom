package com.example.lucas.apptom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lucas.apptom.Model.Voo;
import com.example.lucas.apptom.service.ListaVoosService;

import java.util.List;

public class ListaVoosActivity extends AppCompatActivity {

    ListView lstVoos;
    List<Voo> voos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_voos);

        binding();

        String token = getIntent().getExtras().getString("token");

        ListaVoosService listavoos = new ListaVoosService();

        try{

            voos = listavoos.execute(token).get();

        } catch(Exception e){
            Toast.makeText(getApplicationContext(), "Erro no Serviço", Toast.LENGTH_SHORT).show();
        }
        String [] vet = new String [voos.size()];
        int i = 0;
        for(Voo v: voos){
            vet[i++] = v.getOrigem().getAeroporto();
        }
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,vet);

        lstVoos.setAdapter(adapter);


    }

    private void binding() {
        lstVoos = findViewById(R.id.lstListaVoos);
    }
}
