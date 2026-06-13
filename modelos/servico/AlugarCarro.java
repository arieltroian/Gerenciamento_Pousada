package modelos.servico;
public class AlugarCarro extends Servico{
    private int qtdDias;

    public AlugarCarro(int codigo, String descricao, double precoBase, int qtdDias){
        super(codigo, descricao, precoBase);
        this.qtdDias = qtdDias;
    }

    public void exibirDados(){
        System.out.println("Descrição: " + getDescricao() + 
        "\nCódigo: " + getCodigo() + 
        "\nPreço Total: R$ " + calcPrecoTotal() +
        "\nQuantidade de dias: " + qtdDias);
    }

    @Override
    public double calcPrecoTotal() {
        return getPrecoBase() * qtdDias;
    }

    public int obterCodigo() {
        return getCodigo();
    }
}
