package com.example.lucas.apptom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.lucas.apptom.Model.Usuario;
import com.example.lucas.apptom.service.NovoUsuarioService;

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
                NovoUsuarioService nus = new NovoUsuarioService();

                Usuario u = new Usuario();
                u.setNome(edtNome.getText().toString());
                u.setLogin(edtLogin.getText().toString());
                u.setEmail(edtEmail.getText().toString());
                u.setSenha(edtSenha.getText().toString());

                nus.execute(u.getNome(),u.getLogin(),u.getSenha(),u.getEmail());

                finish();


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
