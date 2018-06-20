package com.example.lucas.apptom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.lucas.apptom.Model.Usuario;
import com.example.lucas.apptom.service.NovoUsuarioService;

import java.util.concurrent.ExecutionException;

public class NovoUsuarioActivity extends AppCompatActivity {

    EditText edtNome,edtSenha,edtLogin,edtEmail;
    Button Inserir,Voltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        binding();

        Voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    NovoUsuarioService nus = new NovoUsuarioService();

                    Usuario user = new Usuario();

                    user = nus.execute(edtNome.getText().toString(), edtLogin.getText().toString(), edtEmail.getText().toString(), edtSenha.getText().toString()).get();

                    if(user != null){
                        Toast.makeText(getApplicationContext(), "Logou: " + user.getNome(), Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Não Logou " , Toast.LENGTH_SHORT).show();
                    }
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }


            }
        });
    }

    private void binding() {

        Inserir = findViewById(R.id.btnGravar);
        Voltar = findViewById(R.id.btnVoltar);
        edtNome = findViewById(R.id.edtUsuarioNome);
        edtEmail = findViewById(R.id.edtUsuarioEmail);
        edtLogin = findViewById(R.id.edtUsuarioLogin);
        edtSenha = findViewById(R.id.edtUsuarioSenha);
    }
}
