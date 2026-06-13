package interfaces;

import java.util.List;

import modelos.Hospede;
import modelos.Reserva;
import modelos.acomodacao.Acomodacao;
import modelos.servico.Servico;

public interface Armazenavel {
    public List<Acomodacao> lerAcomodacoes(String arquivo);
    public List<Servico> lerServicos(String arquivo);
    public List<Hospede> lerHospedes(String arquivo);
    public List<Reserva> lerReservas(String arquivo, List<Hospede> hospedes, List<Acomodacao> acomodacoes);

    public void salvarHospedes(List<Hospede> hospedes, String arquivo);
    public void salvarReservas(List<Reserva> reservas, String arquivo);
}
