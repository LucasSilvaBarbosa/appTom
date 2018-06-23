package com.example.lucas.apptom.Model;

public class Aviao {

    private String id;
    private int capacidade;
    private String modelo;
    private String prefixo;

    public Aviao() {
    }

    public Aviao(String id, int capacidade, String modelo, String prefixo) {
        this.id = id;
        this.capacidade = capacidade;
        this.modelo = modelo;
        this.prefixo = prefixo;
    }

    public String getId() {
        return id;
    }

    public void setId(String idAviao) {
        this.id = idAviao;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }
    
}
