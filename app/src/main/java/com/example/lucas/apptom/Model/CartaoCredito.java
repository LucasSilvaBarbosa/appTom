package com.example.lucas.apptom.Model;

public class CartaoCredito {

    private String id;
    private String cartao;
    private int mes;
    private int ano;
    private String tarja;
    private double valor;

    public CartaoCredito() {
    }

    public CartaoCredito(String id, String cartao, int mes, int ano, String tarja, double valor) {
        this.id = id;
        this.cartao = cartao;
        this.mes = mes;
        this.ano = ano;
        this.tarja = tarja;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCartao() {
        return cartao;
    }

    public void setCartao(String cartao) {
        this.cartao = cartao;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getTarja() {
        return tarja;
    }

    public void setTarja(String tarja) {
        this.tarja = tarja;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
