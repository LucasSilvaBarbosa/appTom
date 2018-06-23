package com.example.lucas.apptom.Model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String email;
    private int idUsuario;
    private String login;
    private String nome;
    private String senha;

    public Usuario() {
    }

    public Usuario(String email, int idUsuario, String login, String nome, String senha) {
        this.email = email;
        this.idUsuario = idUsuario;
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

