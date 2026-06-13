package modelos.servico;

import java.text.DecimalFormat;

public class AlugarCarro extends Servico{
    private int qtdDias;

    public AlugarCarro(int codigo, String descricao, double precoBase, int qtdDias){
        super(codigo, descricao, precoBase);
        this.qtdDias = qtdDias;
    }

    public void exibirDados(){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        System.out.println("Descrição: " + getDescricao() + 
        "\nCódigo: " + getCodigo() + 
        "\nPreço Total: R$" + df.format(calcPrecoTotal()) +
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
