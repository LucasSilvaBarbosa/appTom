package Model;

public class CartaoCredito {

    private int idCartao;
    private String numeroCartao;
    private int mes;
    private int ano;
    private String tarja;
    private double valor;

    public CartaoCredito() {
    }

    public CartaoCredito(int idCartao, String numeroCartao, int mes, int ano, String tarja, double valor) {
        this.idCartao = idCartao;
        this.numeroCartao = numeroCartao;
        this.mes = mes;
        this.ano = ano;
        this.tarja = tarja;
        this.valor = valor;
    }

    public int getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(int idCartao) {
        this.idCartao = idCartao;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
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
