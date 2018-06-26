package com.example.lucas.apptom.Model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String email;
    private String id;
    private String login;
    private String nome;
    private String senha;

    public Usuario() {
    }

    public Usuario(String email, String id, String login, String nome, String senha) {
        this.email = email;
        this.id = id;
        this.login = login;
        this.nome = nome;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdUsuario() {
        return id;
    }

    public void setIdUsuario(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}

