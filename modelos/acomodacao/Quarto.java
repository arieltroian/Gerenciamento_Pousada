package modelos.acomodacao;

public class Quarto extends Acomodacao{

    public Quarto(int codigo, int capacidadeMax, double precoBaseDiaria) {
        super(codigo, capacidadeMax, precoBaseDiaria);
    }
    
    @Override
    public double calcPrecoTotal(int qtdDias) {
        return getPrecoBaseDiaria() * qtdDias;
    }

    @Override
    public double calcPrecoTotalDiaria(){
        return getPrecoBaseDiaria();
    }

    @Override
    public void exibirDados() {
        System.out.println("QUARTO\n\nCódigo: " + getCodigo() + 
        "\nCapacidade máxima de pessoas: " + getCapacidadeMax() + 
        "\nPreço da diária: R$" + getPrecoBaseDiaria() +
        "\nPreço total da diária: R$" + calcPrecoTotalDiaria());
    }
}
