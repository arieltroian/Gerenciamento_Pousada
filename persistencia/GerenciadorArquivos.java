package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import interfaces.Armazenavel;
import modelos.Hospede;
import modelos.Reserva;
import modelos.acomodacao.Acomodacao;
import modelos.acomodacao.Chale;
import modelos.acomodacao.Quarto;
import modelos.acomodacao.Suite;
import modelos.servico.AlugarCarro;
import modelos.servico.PasseioGrupo;
import modelos.servico.Refeicao;
import modelos.servico.Servico;

public class GerenciadorArquivos implements Armazenavel{

    @Override
    public List<Acomodacao> lerAcomodacoes(String arquivo){
        List<Acomodacao> acomodacoesLidas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                if(dados[0].equalsIgnoreCase("QUARTO")) {
                    int codigo = Integer.parseInt(dados[1]);
                    int capacidade = Integer.parseInt(dados[2]);
                    double preco = Double.parseDouble(dados[3]);

                    acomodacoesLidas.add(new Quarto(codigo, capacidade, preco));
                }

                else if(dados[0].equalsIgnoreCase("CHALE")) {
                    int codigo = Integer.parseInt(dados[1]);
                    int capacidade = Integer.parseInt(dados[2]);
                    double preco = Double.parseDouble(dados[3]);
                    double taxaAquecimento = Double.parseDouble(dados[4]);
                    double taxaLimpeza = Double.parseDouble(dados[5]);

                    acomodacoesLidas.add(new Chale(codigo, capacidade, preco, taxaAquecimento, taxaLimpeza));
                }

                else if(dados[0].equalsIgnoreCase("SUITE")) {
                    int codigo = Integer.parseInt(dados[1]);
                    int capacidade = Integer.parseInt(dados[2]);
                    double preco = Double.parseDouble(dados[3]);
                    double taxaHidromassagem = Double.parseDouble(dados[4]);
                    double adicionalServico = Double.parseDouble(dados[5]);

                    acomodacoesLidas.add(new Suite(codigo, capacidade, preco, taxaHidromassagem, adicionalServico));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler acomodações: " + e.getMessage());
        }
        return acomodacoesLidas;
    }

    @Override
    public List<Servico> lerServicos(String arquivo) {
        List<Servico> servicosLidos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                if(dados[0].equalsIgnoreCase("REFEICAO")) {
                    int codigo = Integer.parseInt(dados[1]);
                    String descricao = dados[2];
                    double preco = Double.parseDouble(dados[3]);

                    servicosLidos.add(new Refeicao(codigo, descricao, preco));
                }

                else if(dados[0].equalsIgnoreCase("PASSEIO")) {
                    int codigo = Integer.parseInt(dados[1]);
                    String descricao = dados[2];
                    double preco = Double.parseDouble(dados[3]);
                    int qtdMaxPessoas = Integer.parseInt(dados[4]);

                    servicosLidos.add(new PasseioGrupo(codigo, descricao, preco, qtdMaxPessoas));
                }

                else if(dados[0].equalsIgnoreCase("ALUGARCARRO")) {
                    int codigo = Integer.parseInt(dados[1]);
                    String descricao = dados[2];
                    double preco = Double.parseDouble(dados[3]);
                    int qtdDias = Integer.parseInt(dados[4]);

                    servicosLidos.add(new AlugarCarro(codigo, descricao, preco, qtdDias));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler serviços: " + e.getMessage());
        }
        return servicosLidos;
    }

    @Override
    public List<Hospede> lerHospedes(String arquivo) {
        List<Hospede> hospedesLidos = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");
                String nome = dados[0];
                String cpf = dados[1];
                int idade = Integer.parseInt(dados[2]);

                hospedesLidos.add(new Hospede(nome, cpf, idade));
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler hóspedes: " + e.getMessage());
        }
        return hospedesLidos;
    }

    @Override
    public List<Reserva> lerReservas(String arquivo, List<Hospede> hospedes, List<Acomodacao> acomodacoes) {
        List<Reserva> reservasLidas = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(";");

                int codigo = Integer.parseInt(dados[0]);
                String cpfCadastrado = dados[1];
                int codigoAcomodacaoCadastrada = Integer.parseInt(dados[2]);
                int qtdHospedes = Integer.parseInt(dados[3]);
                int qtdDias = Integer.parseInt(dados[4]);

                Hospede hospedeEncontrado = null;
                for (Hospede h : hospedes) {
                    if (h.getCpf().equals(cpfCadastrado)) {
                        hospedeEncontrado = h;
                        break;
                    }
                }
                Acomodacao acomodacaoEncontrada = null;
                for (Acomodacao a : acomodacoes) {
                    if (a.getCodigo() == codigoAcomodacaoCadastrada) {
                        acomodacaoEncontrada = a;
                        break;
                    }
                }
                if (hospedeEncontrado != null && acomodacaoEncontrada != null) {
                    Reserva novaReserva = new Reserva(codigo, hospedeEncontrado, acomodacaoEncontrada, qtdHospedes, qtdDias);
                    reservasLidas.add(novaReserva);
                } else {
                    System.out.println("Aviso: Ignorando reserva " + codigo + " pois Hóspede ou Acomodação não existem mais no sistema.");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler reservas: " + e.getMessage());
        }
        return reservasLidas;
    }

    @Override
    public void salvarHospedes(List<Hospede> hospedes, String arquivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for(Hospede h : hospedes) {
                bw.write(h.getNome() + ";" + h.getCpf() + ";" + h.getIdade());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar hóspedes: " + e.getMessage());
        }
    }

    @Override
    public void salvarReservas(List<Reserva> reservas, String arquivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for(Reserva r : reservas) {
                bw.write(r.getCodigo() + ";" + r.getQtdHospedes() + ";" + r.getQtdDias() + r.getHospede() + r.getAcomodacao());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar reservas: " + e.getMessage());
        }
    }
}
