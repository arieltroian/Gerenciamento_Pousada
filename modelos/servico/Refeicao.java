package modelos.servico;
public class Refeicao extends Servico{

    public Refeicao(int codigo, String descricao, double precoBase){
        super(codigo, descricao, precoBase);
    }

    public void exibirDados(){}

    @Override
    public double calcPrecoTotal() {
        return getPrecoBase();
    }
}
