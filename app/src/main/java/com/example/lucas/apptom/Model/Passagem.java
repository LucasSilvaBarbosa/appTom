package com.example.lucas.apptom.Model;

public class Passagem {
    private Poltrona assento;
    private boolean ocupado;
    private Origem origem;
    private Destino destino;
    private String dataVoo;
    private String valorPassagem;
    private Aviao aviao;
    private Usuario usuario;

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }



    public Passagem(Poltrona assento, boolean ocupado, Origem origem, Destino destino, String dataVoo, String valorPassagem, Aviao aviao,Usuario usuario) {
        this.assento = assento;
        this.ocupado = ocupado;
        this.origem = origem;
        this.destino = destino;
        this.dataVoo = dataVoo;
        this.valorPassagem = valorPassagem;
        this.aviao = aviao;
        this.usuario = usuario;
    }

    public Passagem() {
    }

    public Poltrona getAssento() {
        return assento;
    }

    public void setAssento(Poltrona assento) {
        this.assento = assento;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
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

    public String getValorPassagem() {
        return valorPassagem;
    }

    public void setValorPassagem(String valorPassagem) {
        this.valorPassagem = valorPassagem;
    }
}

