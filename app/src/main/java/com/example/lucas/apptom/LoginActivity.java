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
import com.example.lucas.apptom.service.UsuarioService;

import java.util.concurrent.ExecutionException;

public class LoginActivity extends AppCompatActivity {

    ImageButton imgLogar,imgNovoUsuario;
    EditText edtlogin, edtSenha;
    final static int Tela_Principal = 15;
    String resp,token = "";
    Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        binding();

        imgLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                LoginService login = new LoginService();

                if (edtlogin.getText().toString().length() == 0) {
                    edtlogin.setError("Digite o Login!");
                } else if (edtSenha.getText().toString().length() == 0) {
                    edtSenha.setError("Digite a Senha!");
                } else {
                    try {
                        user = login.execute(edtlogin.getText().toString(), edtSenha.getText().toString()).get();

                        if (user != null) {
                            
                            Intent itn = new Intent(getApplicationContext(), ListaVoosActivity.class);

                            itn.putExtra("usuario", user);
                            itn.putExtra("token", user.getToken());

                            startActivityForResult(itn, Tela_Principal);

                            Toast.makeText(getApplicationContext(), "Logou com sucesso "+user.getNome(), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Usuario ou Senha invalidos", Toast.LENGTH_SHORT).show();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
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
        edtSenha = findViewById(R.id.edtSenha);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Tela_Principal) {
            if(resultCode == ListaVoosActivity.Tela_Lista_Voos) {
                edtSenha.setText("");
                edtlogin.setText("");
            }
        }
    }
}
