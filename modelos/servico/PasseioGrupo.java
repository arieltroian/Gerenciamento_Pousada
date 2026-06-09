package modelos.servico;
public class PasseioGrupo extends Servico{
    private int capacidadeMax;

    public PasseioGrupo(int codigo, String descricao, double precoBase){
        super(codigo, descricao, precoBase);
    }

    public void exibirDados(){}

    @Override
    public double calcPrecoTotal() {
        return getPrecoBase() * capacidadeMax;
    }
}
