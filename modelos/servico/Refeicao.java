package modelos.servico;

import java.text.DecimalFormat;

public class Refeicao extends Servico{

    public Refeicao(int codigo, String descricao, double precoBase){
        super(codigo, descricao, precoBase);
    }

    public String getTipo() {
        return "Refeição";
    }

    public void exibirDados(){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        System.out.println("Serviço: " + getTipo() + 
        "\nDescrição: " + getDescricao() + 
        "\nCódigo: " + getCodigo() + 
        "\nPreço Total: R$" + df.format(getPrecoBase()));
    }

    @Override
    public double calcPrecoTotal(int qtdDiasReserva) {
        return getPrecoBase();
    }

    public int obterCodigo() {
        return getCodigo();
    }
}
