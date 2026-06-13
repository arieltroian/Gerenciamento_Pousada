package modelos.acomodacao;

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
    public void exibirDados() {
        System.out.println("SUÍTE\n\nCódigo: " + getCodigo() + 
        "\nCapacidade Máxima de pessoas: " + getCapacidadeMax() + 
        "\nPreço da diária: R$ " + getPrecoBaseDiaria() + 
        "\nAdicional de Serviço: R$ " + this.adicionalServico + 
        "\nTaxa Fixa de Hidromassagem: R$ " + this.taxaHidromassagem);
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
