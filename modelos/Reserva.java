package modelos;

import java.util.ArrayList;
import java.util.List;

import modelos.acomodacao.Acomodacao;
import modelos.servico.Servico;

public class Reserva {
    private int codigo;
    private int qtdHospedes;
    private int qtdDias;
    private Hospede hospede;
    private Acomodacao acomodacao;
    private List<Servico> servicos;

    public Reserva(int codigo, int qtdHospedes, int qtdDias, Hospede hospede, Acomodacao acomodacao){
        this.codigo = codigo;
        this.qtdHospedes = qtdHospedes;
        this.qtdDias = qtdDias;
        this.hospede = hospede;
        this.acomodacao = acomodacao;
        this.servicos = new ArrayList<>();
    }

    public void contratarServico(Servico servico){
        this.servicos.add(servico);
    }

    public void removerServico(Servico servico){
        this.servicos.remove(servico);
    }

    public double calcularPrecoTotal() {
        double totalServicos = 0;

        double totalAcomodacao = this.acomodacao.calcPrecoTotal(this.qtdDias);

        for(Servico servico : this.servicos) {
            totalServicos += servico.calcPrecoTotal();
        }

        return totalAcomodacao + totalServicos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQtdHospedes() {
        return qtdHospedes;
    }

    public void setQtdHospedes(int qtdHospedes) {
        this.qtdHospedes = qtdHospedes;
    }

    public int getQtdDias() {
        return qtdDias;
    }

    public void setQtdDias(int qtdDias) {
        this.qtdDias = qtdDias;
    }

    public Hospede getHospede () {
        return hospede;
    }

    public Hospede setHospede(Hospede hospede) {
        return this.hospede = hospede;
    }

    public Acomodacao getAcomodacao() {
        return acomodacao;
    }

    public void setAcomodacao(Acomodacao acomodacao) {
        this.acomodacao = acomodacao;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

} 
