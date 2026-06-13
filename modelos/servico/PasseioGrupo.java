package modelos.servico;

import java.text.DecimalFormat;

public class PasseioGrupo extends Servico{
    private int qtdMaxPessoas;

    public PasseioGrupo(int codigo, String descricao, double precoBase, int qtdMaxPessoas){
        super(codigo, descricao, precoBase);
        this. qtdMaxPessoas = qtdMaxPessoas;
    }

    public void exibirDados(){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        System.out.println("Descrição: " + getDescricao() + 
        "\nCódigo: " + getCodigo() + 
        "\nPreço Total: R$" + df.format(calcPrecoTotal()) + 
        "\nQuantidade máxima de pessoas: " + qtdMaxPessoas);
    }

    @Override
    public double calcPrecoTotal() {
        return getPrecoBase() * qtdMaxPessoas;
    }

    public int obterCodigo() {
        return getCodigo();
    }
} 
