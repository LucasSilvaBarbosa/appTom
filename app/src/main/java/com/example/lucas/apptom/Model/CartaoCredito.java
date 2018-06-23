package com.example.lucas.apptom.Model;

public class CartaoCredito {

    private String status;
    private String numero;
    private String validade;
    private String bandeira;
    private String tarja;
    private double valor;

    public CartaoCredito() {
    }

    public CartaoCredito(String status, String numero, String validade, String bandeira, String tarja, double valor) {
        this.status = status;
        this.numero = numero;
        this.validade = validade;
        this.bandeira = bandeira;
        this.tarja = tarja;
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
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
