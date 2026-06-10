package modelos;
import java.util.ArrayList;
import java.util.List;

import interfaces.Armazenavel;
import modelos.acomodacao.Acomodacao;
import modelos.servico.Servico;

public class Pousada implements Armazenavel{
    private List<Hospede> hospedes;
    private List<Acomodacao> acomodacoes;
    private List<Servico> servicos;
    private List<Reserva> reservas;

    public Pousada() {
        this.hospedes = new ArrayList<>();
        this.acomodacoes = new ArrayList<>();
        this.servicos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void lerDados(){

    }

    public void salvarDados() {
        
    }

    public List<Hospede> getHospedes() {
        return hospedes;
    }

    public void setHospedes(List<Hospede> hospedes) {
        this.hospedes = hospedes;
    }

    public List<Acomodacao> getAcomodacoes() {
        return acomodacoes;
    }

    public void setAcomodacoes(List<Acomodacao> acomodacoes) {
        this.acomodacoes = acomodacoes;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}
