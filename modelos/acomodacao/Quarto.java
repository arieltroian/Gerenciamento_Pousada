package modelos.acomodacao;
public class Quarto extends Acomodacao{

    public Quarto(int codigo, int capacidadeMax, double precoBase) {
        super(codigo, capacidadeMax, precoBase);
    }
    
    public void exibirDados() {}

    @Override
    public double calcPrecoTotal(int dias) {
        return getPrecoBase();
    }
}
