package com.example.lucas.apptom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.lucas.apptom.Model.Usuario;
import com.example.lucas.apptom.service.LoginService;

import java.util.concurrent.ExecutionException;

public class LoginActivity extends AppCompatActivity {

    ImageButton imgLogar,imgNovoUsuario;
    EditText edtlogin,senha;
    final static int Tela_Principal = 15;
    String resp,token = "";
    String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        binding();

        imgLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginService login = new LoginService();

                if(edtlogin.getText().toString().length() == 0){
                    edtlogin.setError("Digite o Login!");
                }
                else if(senha.getText().toString().length() == 0){
                    senha.setError("Digite a Senha!");
                }

                else {
                    try {
                        resp = login.execute(edtlogin.getText().toString(), senha.getText().toString()).get();

                        token = resp.substring(resp.indexOf("token") + 8, resp.indexOf("}") - 1);

                        if (token != "") {

                            Intent itn = new Intent(getApplicationContext(), ListaVoosActivity.class);

                            itn.putExtra("token", token);

                            startActivityForResult(itn, Tela_Principal);

                            Toast.makeText(getApplicationContext(), "Logou com sucesso", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Não Logou ", Toast.LENGTH_SHORT).show();
                        }
                    } catch (InterruptedException e) {
                        Toast.makeText(getApplicationContext(), "Erro no Serviço", Toast.LENGTH_SHORT).show();
                    } catch (ExecutionException e) {
                        Toast.makeText(getApplicationContext(), "Erro no Serviço", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


        imgNovoUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itn = new Intent(getApplicationContext(),NovoUsuarioActivity.class);

                startActivityForResult(itn,Tela_Principal);
            }
        });
    }

    private void binding() {
        imgLogar = findViewById(R.id.imgLogar);
        imgNovoUsuario = findViewById(R.id.imgNovoUsuario);
        edtlogin = findViewById(R.id.edtLogin);
        senha = findViewById(R.id.edtSenha);
    }
}
