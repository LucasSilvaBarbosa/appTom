package com.example.lucas.apptom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.lucas.apptom.Model.Usuario;

public class NovoUsuarioActivity extends AppCompatActivity {

    EditText edtNome,edtSenha,edtLogin,edtEmail;
    ImageButton imgInserir,imgVoltar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        binding();

        imgVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        imgInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario u = new Usuario();
                u.setNome(edtNome.getText().toString());
                u.setLogin(edtLogin.getText().toString());
                u.setEmail(edtEmail.getText().toString());
            }
        });
    }

    private void binding() {
        imgInserir = findViewById(R.id.imgUsuarioSalvar);
        imgVoltar = findViewById(R.id.imgUsuarioVoltar);
        edtNome = findViewById(R.id.edtUsuarioNome);
        edtEmail = findViewById(R.id.edtUsuarioEmail);
        edtLogin = findViewById(R.id.edtUsuarioLogin);
        edtSenha = findViewById(R.id.edtUsuarioSenha);
    }
}
