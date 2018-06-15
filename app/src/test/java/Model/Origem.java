package Model;

public class Origem {

    private int idDestino;
    private String aeroporto;
    private String cidade;

    public Origem() {
    }

    public Origem(int idDestino, String aeroporto, String cidade) {
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
