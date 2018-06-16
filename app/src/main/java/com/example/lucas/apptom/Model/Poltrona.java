package com.example.lucas.apptom.Model;

import com.example.lucas.apptom.Model.Usuario;

public class Poltrona {

    private int idPoltrona;
    private String assento;
    private boolean ocupado;
    private Usuario usuario;

    public Poltrona() {
    }

    public Poltrona(int idPoltrona, String assento, boolean ocupado, Usuario usuario) {
        this.idPoltrona = idPoltrona;
        this.assento = assento;
        this.ocupado = ocupado;
        this.usuario = usuario;
    }

    public int getIdPoltrona() {
        return idPoltrona;
    }

    public void setIdPoltrona(int idPoltrona) {
        this.idPoltrona = idPoltrona;
    }

    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
