package modelos.acomodacao;
import interfaces.Exibivel;

public abstract class Acomodacao implements Exibivel{
    private int codigo;
    private int capacidadeMax;
    private double precoBase;

    public Acomodacao(int codigo, int capacidadeMax, double precoBase) {
        this.codigo = codigo;
        this.capacidadeMax = capacidadeMax;
        this.precoBase = precoBase;
    }

    public abstract double calcPrecoTotal(int dias);

    public int getCodigo() {
        return this.codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCapacidadeMax() {
        return this.capacidadeMax;
    }
    public void setCapacidadeMax(int capacidadeMax) {
        this.capacidadeMax = capacidadeMax;
    }

    public double getPrecoBase() {
        return this.precoBase;
    }
    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    } 
}
