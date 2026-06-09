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
    public void exibirDados() {
        System.out.println("Código: " + getCodigo() + 
        "\nCapacidade Máxima de pessoas: " + getCapacidadeMax() + 
        "\nPreço da diária: " + getPrecoBaseDiaria());
    }


}
