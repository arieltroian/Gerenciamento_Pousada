package modelos.acomodacao;

import java.text.DecimalFormat;

public class Chale extends Acomodacao {
    private double taxaAquecimento;
    private double taxaLimpeza;
    
    public Chale(int codigo, int capacidadeMax, double precoBaseDiaria, double taxaAquecimento, double taxaLimpeza) {
        super(codigo, capacidadeMax, precoBaseDiaria);
        this.taxaAquecimento = taxaAquecimento;
        this.taxaLimpeza = taxaLimpeza;
    }

    @Override
    public double calcPrecoTotal(int qtdDias) {
        double precoDiarias = getPrecoBaseDiaria() *qtdDias;
        double precoAquecimento = this.taxaAquecimento *qtdDias;
        return precoDiarias + precoAquecimento + this.taxaLimpeza;
    }

    @Override
    public double calcPrecoTotalDiaria() {
        return getPrecoBaseDiaria() + this.taxaAquecimento + this.taxaLimpeza;
    }

    @Override
    public String getTipo() {
        return "Chalé";
    }

    @Override
    public void exibirDados() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        System.out.println(getTipo() +"\nCódigo: " + getCodigo() + 
        "\nCapacidade máxima de pessoas: " + getCapacidadeMax() + 
        "\nPreço da diária: R$" + df.format(getPrecoBaseDiaria()) + 
        "\nTaxa de Aquecimento: R$" + df.format(this.taxaAquecimento) + 
        "\nTaxa de limpeza: R$" + df.format(this.taxaLimpeza) +
        "\nPreço total da diária: R$" + df.format(calcPrecoTotalDiaria()));
    }

    public double getTaxaAquecimento() {
        return this.taxaAquecimento;
    }

    public void setTaxaAquecimento(double taxaAquecimento) {
        this.taxaAquecimento = taxaAquecimento;
    }

    public double getTaxaLimpeza() {
        return this.taxaLimpeza;
    }

    public void setTaxaLimpeza(double taxaLimpeza) {
        this.taxaLimpeza = taxaLimpeza;
    }

}
