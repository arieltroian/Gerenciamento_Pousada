package modelos.acomodacao;

import java.text.DecimalFormat;

public class Suite extends Acomodacao{
    private double taxaHidromassagem;
    private double adicionalServico;
    
    public Suite(int codigo, int capacidadeMax, double precoBaseDiaria, double taxaHidromassagem, double adicionalServico) {
        super(codigo, capacidadeMax, precoBaseDiaria);
        this.taxaHidromassagem = taxaHidromassagem;
        this.adicionalServico = adicionalServico;
    }

    @Override
    public double calcPrecoTotal(int qtdDias) {
        double precoDiariasComVIP = (getPrecoBaseDiaria() + this.adicionalServico) * qtdDias;
        return precoDiariasComVIP + this.taxaHidromassagem;
    }

    @Override
    public double calcPrecoTotalDiaria() {
        return getPrecoBaseDiaria() + this.adicionalServico + this.taxaHidromassagem;
    }

    @Override
    public void exibirDados() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        System.out.println("SUÍTE\n\nCódigo: " + getCodigo() + 
        "\nCapacidade máxima de pessoas: " + getCapacidadeMax() + 
        "\nPreço da diária: R$" + df.format(getPrecoBaseDiaria()) + 
        "\nAdicional de Serviço: R$" + df.format(this.adicionalServico) + 
        "\nTaxa Fixa de Hidromassagem: R$" + df.format(this.taxaHidromassagem) + 
        "\nPreço total da diária: R$" + df.format(calcPrecoTotalDiaria()));
    }

    public double getTaxaHidromassagem() {
        return this.taxaHidromassagem;
    }

    public void setTaxaHidromassagem(double taxaHidromassagem) {
        this.taxaHidromassagem = taxaHidromassagem;
    }

    public double getAdicionalServico() {
        return this.adicionalServico;
    }

    public void setAdicionalServico(double adicionalServico) {
        this.adicionalServico = adicionalServico;
    }
}
