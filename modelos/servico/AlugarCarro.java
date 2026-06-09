package modelos.servico;
public class AlugarCarro extends Servico{
    private double taxa;

    public AlugarCarro(int codigo, String descricao, double precoBase){
        super(codigo, descricao, precoBase);
    }

    public void exibirDados(){}

    @Override
    public double calcPrecoTotal() {
        return getPrecoBase() * taxa;
    }
}
