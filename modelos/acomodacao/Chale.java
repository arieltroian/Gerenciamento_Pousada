package modelos.acomodacao;

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
    public void exibirDados() {
        System.out.println("Código: " + getCodigo() + 
        "\nCapacidade Máxima de pessoas: " + getCapacidadeMax() + 
        "\nPreço da diária: " + getPrecoBaseDiaria() + 
        "\nTaxa de Aquecimento: " + this.taxaAquecimento + 
        "Taxa de limpeza: " + this.taxaLimpeza);
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
