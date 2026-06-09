package modelos.servico;
import interfaces.Exibivel;

public abstract class Servico implements Exibivel{
    private int codigo;
    private String descricao;
    private double precoBase;

    public Servico (int codigo, String descricao, double precoBase) {
        this.codigo = codigo;
        this.descricao = descricao;
        this. precoBase = precoBase;
    }

    public abstract double calcPrecoTotal(); 

    public int getCodigo() {
        return this.codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoBase() {
        return this.precoBase;
    }
    public void setPrecoBase(int precoBase) {
        this.precoBase = precoBase;
    }
}
