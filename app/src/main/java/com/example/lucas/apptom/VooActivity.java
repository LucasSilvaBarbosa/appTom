package com.example.lucas.apptom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lucas.apptom.Model.Poltrona;
import com.example.lucas.apptom.Model.Voo;
import com.example.lucas.apptom.service.ListaPoltronasService;
import com.example.lucas.apptom.service.VooService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class VooActivity extends AppCompatActivity {

    String token,resp = "";
    String idVoo;
    Voo voo;
    List<Poltrona> lista;
    TextView txtVooAviao,txtVooData,txtVooOrigem,txtVooDestino,txtVooValor;
    ListView lstListaPoltronas;
    final static int Tela_Voo = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voo);

        binding();

        token = getIntent().getExtras().getString("token");

        idVoo = getIntent().getExtras().getString("voo");

        VooService vooService = new VooService();

        try{
            voo = vooService.execute(idVoo,token).get();

            txtVooAviao.setText("Avião: "+voo.getAviao().getModelo());
            txtVooValor.setText("Valor: "+voo.getValorPassagem());
            txtVooDestino.setText("Destino:"+voo.getDestino().getCidade());
            txtVooOrigem.setText("Origem:"+voo.getOrigem().getCidade());
            txtVooData.setText("Data:"+voo.getDataVoo());
        }
        catch (InterruptedException e1) {
            e1.printStackTrace();
        } catch (ExecutionException e1) {
            e1.printStackTrace();
        }

        ListaPoltronasService poltronas = new ListaPoltronasService();

        try{

            lista = poltronas.execute(idVoo,token).get();

        } catch(Exception e){
            Toast.makeText(getApplicationContext(), "Erro no Serviço", Toast.LENGTH_SHORT).show();
        }
        List<Poltrona> vazias = new ArrayList<>();
        for(Poltrona p : lista){
            if(p.isOcupado() == false){
                vazias.add(p);
            }
        }
        String [] vet = new String [vazias.size()];
        int i = 0;
        for(Poltrona p: vazias){
                vet[i++] = p.getAssento();
        }
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,vet);

        lstListaPoltronas.setAdapter(adapter);

        lstListaPoltronas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String pol = lista.get(position).getId();

                Intent itn = new Intent(getApplicationContext(),CompraPoltronaActivity.class);

                itn.putExtra("pol",pol);
                itn.putExtra("idVoo",idVoo);
                itn.putExtra("token",token);

                startActivityForResult(itn,Tela_Voo);
            }
        });
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
