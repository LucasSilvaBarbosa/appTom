package com.example.lucas.apptom.Model;

import com.example.lucas.apptom.Model.Usuario;

public class Poltrona {

    private String id;
    private String assento;
    private boolean ocupado;
    private Usuario usuario;

    public Poltrona() {
    }

    public Poltrona(String id, String assento, boolean ocupado, Usuario usuario) {
        this.id = id;
        this.assento = assento;
        this.ocupado = ocupado;
        this.usuario = usuario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
