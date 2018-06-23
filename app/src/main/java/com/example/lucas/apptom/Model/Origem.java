package com.example.lucas.apptom.Model;

public class Origem {

    private String id;
    private String aeroporto;
    private String cidade;

    public Origem() {
    }

    public Origem(String id, String aeroporto, String cidade) {
        this.id = id;
        this.aeroporto = aeroporto;
        this.cidade = cidade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
