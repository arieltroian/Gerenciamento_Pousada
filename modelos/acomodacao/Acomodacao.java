package modelos.acomodacao;
import interfaces.Exibivel;

public abstract class Acomodacao implements Exibivel{
    private int codigo;
    private int capacidadeMax;
    private double precoBaseDiaria;

    public Acomodacao(int codigo, int capacidadeMax, double precoBaseDiaria) {
        this.codigo = codigo;
        this.capacidadeMax = capacidadeMax;
        this.precoBaseDiaria = precoBaseDiaria;
    }

    public abstract double calcPrecoTotal(int dias);

    public abstract double calcPrecoTotalDiaria();

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

    public double getPrecoBaseDiaria() {
        return this.precoBaseDiaria;
    }
    public void setPrecoBasediaria(double precoBaseDiaria) {
        this.precoBaseDiaria = precoBaseDiaria;
    } 
}
