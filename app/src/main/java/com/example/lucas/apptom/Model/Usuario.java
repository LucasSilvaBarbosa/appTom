package com.example.lucas.apptom.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable {
    private String email;
    private String id;
    private String login;
    private String nome;
    private String senha;
    private String token;

    public List<Passagem> getPassagens() {
        return passagens;
    }

    public void setPassagens(List<Passagem> passagens) {
        this.passagens = passagens;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    private List<Passagem> passagens;
    private String peso;

    public Usuario(String email, String id, String login, String nome, String senha, String token,String peso) {
        this.email = email;
        this.id = id;
        this.login = login;
        this.nome = nome;
        this.senha = senha;
        this.token = token;
        this.passagens = new ArrayList<>();
        }

    public Usuario() {
    }

    public Usuario(String email, String id, String login, String nome, String senha, String token, List<Passagem> passagens) {
        this.email = email;
        this.id = id;
        this.login = login;
        this.nome = nome;
        this.senha = senha;
        this.token = token;
        this.passagens = passagens;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}

