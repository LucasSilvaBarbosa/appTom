package com.example.lucas.apptom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class LoginActivity extends AppCompatActivity {

    ImageButton imgLogar,imgNovoUsuario;
    EditText edtlogin,senha;
    final static int Tela_Principal = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        binding();


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
