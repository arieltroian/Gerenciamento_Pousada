package modelos.servico;

import java.text.DecimalFormat;

public class Refeicao extends Servico{

    public Refeicao(int codigo, String descricao, double precoBase){
        super(codigo, descricao, precoBase);
    }

    public void exibirDados(){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        System.out.println("Descrição: " + getDescricao() + 
        "\nCódigo: " + getCodigo() + 
        "\nPreço Total: R$" + df.format(calcPrecoTotal()));
    }

    @Override
    public double calcPrecoTotal() {
        return getPrecoBase();
    }

    public int obterCodigo() {
        return getCodigo();
    }
}
