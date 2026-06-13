package modelos.servico;

import java.text.DecimalFormat;

public class AlugarCarro extends Servico{
    public AlugarCarro(int codigo, String descricao, double precoBase){
        super(codigo, descricao, precoBase);
    }

    public void exibirDados(){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        System.out.println("Descrição: " + getDescricao() + 
        "\nCódigo: " + getCodigo() + 
        "\nPreço da diária: R$" + df.format(getPrecoBase()));
    }

    @Override
    public double calcPrecoTotal(int qtdDiasReserva) {
        return getPrecoBase() * qtdDiasReserva;
    }

    public int obterCodigo() {
        return getCodigo();
    }
}
