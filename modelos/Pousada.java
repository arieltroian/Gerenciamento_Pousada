package modelos;
import java.util.ArrayList;
import java.util.List;

import interfaces.Armazenavel;
import modelos.acomodacao.Acomodacao;
import modelos.servico.Servico;
import persistencia.GerenciadorArquivos;

public class Pousada {
    private List<Hospede> hospedes;
    private List<Acomodacao> acomodacoes;
    private List<Servico> servicos;
    private List<Reserva> reservas;
    private Armazenavel gerenciadorArquivos;

    public Pousada() {
        this.hospedes = new ArrayList<>();
        this.acomodacoes = new ArrayList<>();
        this.servicos = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.gerenciadorArquivos = new GerenciadorArquivos();
    }

    public void carregarDados(){
        try {
            this.acomodacoes = gerenciadorArquivos.lerAcomodacoes("dados/acomodacoes.txt");
            this.servicos = gerenciadorArquivos.lerServicos("dados/servicos.txt");
            this.hospedes = gerenciadorArquivos.lerHospedes("dados/hospedes.txt");
            this.reservas = gerenciadorArquivos.lerReservas("dados/reservas.txt", this.hospedes, this.acomodacoes);
            
            System.out.println("\nTodos os dados foram carregados no sistema com sucesso.");       
        } catch (RuntimeException e) {
            System.out.println("\nNão foi possível carregar os dados: " + e.getMessage());
        }
    } 

    public void salvarDados() {
        try {
            gerenciadorArquivos.salvarHospedes(this.hospedes, "dados/hospedes.txt");
            gerenciadorArquivos.salvarReservas(this.reservas, "dados/reservas.txt");
            System.out.println("\nTodos os dados foram salvos no sistema com sucesso.");
        } catch(RuntimeException e) {
            System.out.println("\nNão foi possível salvar os dados: " + e.getMessage());
        }
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
