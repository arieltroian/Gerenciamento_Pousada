package modelos.servico;
public class PasseioGrupo extends Servico{
    private int qtdMaxPessoas;

    public PasseioGrupo(int codigo, String descricao, double precoBase){
        super(codigo, descricao, precoBase);
    }

    public void exibirDados(){
        System.out.println("Descrição: " + getDescricao());
    }

    @Override
    public double calcPrecoTotal() {
        return getPrecoBase() * qtdMaxPessoas;
    }

    public int obterCodigo() {
        return getCodigo();
    }
} 
