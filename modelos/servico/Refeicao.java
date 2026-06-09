package modelos.servico;
public class Refeicao extends Servico{

    public Refeicao(int codigo, String descricao, double precoBase){
        super(codigo, descricao, precoBase);
    }

    public void exibirDados(){
        System.out.println("Descrição: " + getDescricao());
    }

    @Override
    public double calcPrecoTotal() {
        return getPrecoBase();
    }

    public int obterCodigo() {
        return getCodigo();
    }

}
