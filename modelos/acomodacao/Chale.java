package modelos.acomodacao;

public class Chale extends Acomodacao {
    
    public Chale(int codigo, int capacidadeMax, double precoBase) {
        super(codigo, capacidadeMax, precoBase);
    }

    public void exibirDados() {}

    @Override
    public double calcPrecoTotal(int dias) {
        return getPrecoBase();
    }

    public double taxaAquecimento() {
        return 0.0;
    }

    public double taxaLimpeza() {
        return 0.0;
    }
}
