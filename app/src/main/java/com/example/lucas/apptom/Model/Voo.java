package com.example.lucas.apptom.Model;

public class Voo {
    private String id;
    private Origem origem;
    private Destino destino;
    private String dataVoo;
    private double valorPassagem;
    private Aviao aviao;

    public Voo() {
    }

    public Voo(String id, Origem origem, Destino destino, String dataVoo, double valorPassagem, Aviao aviao) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.dataVoo = dataVoo;
        this.valorPassagem = valorPassagem;
        this.aviao = aviao;
    }

    public String getId() {
        return id;
    }

    public void setIdVoo(String id) {
        this.id = id;
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

    public String getDataVoo() {
        return dataVoo;
    }

    public void setDataVoo(String dataVoo) {
        this.dataVoo = dataVoo;
    }

    public double getValorPassagem() {
        return valorPassagem;
    }

    public void setValorPassagem(double valorPassagem) {
        this.valorPassagem = valorPassagem;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }
}
