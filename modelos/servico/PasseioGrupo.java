package modelos.servico;

import java.text.DecimalFormat;

public class PasseioGrupo extends Servico{
    private int qtdMaxPessoas;

    public PasseioGrupo(int codigo, String descricao, int qtdMaxPessoas, double precoBase){
        super(codigo, descricao, precoBase);
        this. qtdMaxPessoas = qtdMaxPessoas;
    }

    public String getTipo() {
        return "Passeio em grupo";
    }

    public void exibirDados(){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        double precoTotalPasseio = getPrecoBase() * this.qtdMaxPessoas;

        System.out.println("Descrição: " + getDescricao() + 
        "\nCódigo: " + getCodigo() + 
        "\nQuantidade máxima de pessoas: " + qtdMaxPessoas +
        "\nPreço Total: R$" + df.format(precoTotalPasseio)); 
    }

    @Override
    public double calcPrecoTotal(int qtdDiasReserva) {
        return getPrecoBase() * qtdMaxPessoas;
    }

    public int obterCodigo() {
        return getCodigo();
    }
} 
