package com.example.lucas.apptom.Model;

public class Voo {
    private String idVoo;
    private Origem origem;
    private Destino destino;
    private String datavoo;
    private double valor;
    private Aviao aviao;

    public Voo() {
    }

    public Voo(String idVoo, Origem origem, Destino destino, String datavoo, double valor, Aviao aviao) {
        this.idVoo = idVoo;
        this.origem = origem;
        this.destino = destino;
        this.datavoo = datavoo;
        this.valor = valor;
        this.aviao = aviao;
    }

    public String getIdVoo() {
        return idVoo;
    }

    public void setIdVoo(String idVoo) {
        this.idVoo = idVoo;
    }

    public Origem getOrigem() {
        return origem;
    }

    public void setOrigem(Origem origem) {
        this.origem = origem;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public String getDatavoo() {
        return datavoo;
    }

    public void setDatavoo(String datavoo) {
        this.datavoo = datavoo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }
}
