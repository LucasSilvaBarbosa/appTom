package Model;

public class Aviao {

    private int idAviao;
    private int capacidade;
    private String modelo;
    private String prefixo;

    public Aviao() {
    }

    public Aviao(int idAviao, int capacidade, String modelo, String prefixo) {
        this.idAviao = idAviao;
        this.capacidade = capacidade;
        this.modelo = modelo;
        this.prefixo = prefixo;
    }

    public int getIdAviao() {
        return idAviao;
    }

    public void setIdAviao(int idAviao) {
        this.idAviao = idAviao;
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
