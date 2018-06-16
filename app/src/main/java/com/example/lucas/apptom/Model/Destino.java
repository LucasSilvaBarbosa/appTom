package com.example.lucas.apptom.Model;

public class Destino {

    private int idDestino;
    private String aeroporto;
    private String cidade;

    public Destino() {
    }

    public Destino(int idDestino, String aeroporto, String cidade) {
        this.idDestino = idDestino;
        this.aeroporto = aeroporto;
        this.cidade = cidade;
    }

    public int getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }

    public String getAeroporto() {
        return aeroporto;
    }

    public void setAeroporto(String aeroporto) {
        this.aeroporto = aeroporto;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
