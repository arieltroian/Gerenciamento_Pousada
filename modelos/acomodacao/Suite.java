package modelos.acomodacao;

public class Suite extends Acomodacao{
    
    public Suite(int codigo, int capacidadeMax, double precoBase) {
        super(codigo, capacidadeMax, precoBase);
    }

    public void exibirDados() {}

    @Override
    public double calcPrecoTotal(int dias) {
        return getPrecoBase();
    }
}
