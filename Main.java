import java.util.Scanner;
import modelos.*;
import modelos.acomodacao.Acomodacao;
import modelos.servico.Servico;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Pousada pousada = new Pousada();

        pousada.carregarDados();

        int opcao = 0;
        do {
            System.out.println("\n===== GERENCIAMENTO DA POUSADA =====");
            System.out.println("1. Cadastrar um hóspede");
            System.out.println("2. Exibir dados de um hóspede");
            System.out.println("3. Exibir dados de todos os hóspedes");
            System.out.println("\n4. Exibir dados de uma acomodação");
            System.out.println("5. Exibir dados de todas as acomodações");
            System.out.println("\n6. Exibir dados de um serviço");
            System.out.println("7. Exibir dados de todos os serviços");
            System.out.println("\n8. Cadastrar uma reserva");
            System.out.println("9. Adicionar serviço a uma reserva");
            System.out.println("10. Exibir dados de uma reserva");
            System.out.println("11. Exibir dados de todas as reservas");
            System.out.println("12. Exibir extrato de uma reserva");
            System.out.println("\n13. Salvar os dados dos hóspedes e reservas em um arquivo");
            System.out.println("14. Sair do sistema");
            System.out.print("\nEscolha uma opção: ");
            
            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {
                case 1: // Cadastrar um hóspede
                    System.out.print("Nome do hóspede: ");
                    String nome = teclado.nextLine();
                    
                    System.out.print("CPF do hóspede: ");
                    String cpf = teclado.nextLine();
                    
                    int idade;
                    do {
                        System.out.print("Idade do hóspede: ");
                        idade = teclado.nextInt();
                        if (idade < 0) {
                            System.out.println("Erro: A idade não pode ser negativa. Tente novamente.");
                        }
                    } while (idade < 0);
                    teclado.nextLine(); 

                    Hospede novoHospede = new Hospede(nome, cpf, idade);
                    pousada.getHospedes().add(novoHospede);
                    System.out.println("Hóspede cadastrado com sucesso!");
                    break;

                case 2: // Exibir dados de um hóspede
                    System.out.print("Digite o CPF do hóspede: ");
                    String cpfBusca = teclado.nextLine();
                    boolean hospedeEncontrado = false;
                    
                    for (Hospede h : pousada.getHospedes()) {
                        if (h.getCpf().equals(cpfBusca)) {
                            System.out.println("\n--- Dados do Hóspede ---");
                            System.out.println("Nome: " + h.getNome() + " | CPF: " + h.getCpf() + " | Idade: " + h.getIdade());
                            hospedeEncontrado = true;
                            break;
                        }
                    }
                    if (!hospedeEncontrado) System.out.println("Hóspede não encontrado.");
                    break;

                case 3: // Exibir dados de todos os hóspedes
                    System.out.println("\n--- Lista de Todos os Hóspedes ---");
                    for (Hospede h : pousada.getHospedes()) {
                        System.out.println("Nome: " + h.getNome() + " | CPF: " + h.getCpf() + " | Idade: " + h.getIdade());
                    }
                    break;

                case 4: // Exibir dados de uma acomodação
                    System.out.print("Digite o código da acomodação: ");
                    int codAcomodacaoBusca = teclado.nextInt();
                    boolean acomodacaoEncontrada = false;
                    
                    for (Acomodacao a : pousada.getAcomodacoes()) {
                        if (a.getCodigo() == codAcomodacaoBusca) {
                            a.exibirDados(); 
                            acomodacaoEncontrada = true;
                            break;
                        }
                    }
                    if (!acomodacaoEncontrada) System.out.println("Acomodação não encontrada.");
                    break;

                case 5: // Exibir dados de todas as acomodações
                    System.out.println("\n--- Lista de Todas as Acomodações ---");
                    for (Acomodacao a : pousada.getAcomodacoes()) {
                        a.exibirDados();
                        System.out.println("-------------------------");
                    }
                    break;

                case 6: // Exibir dados de um serviço
                    System.out.print("Digite o código do serviço: ");
                    int codServicoBusca = teclado.nextInt();
                    boolean servicoEncontrado = false;
                    
                    for (Servico s : pousada.getServicos()) {
                        if (s.getCodigo() == codServicoBusca) {
                            s.exibirDados();
                            servicoEncontrado = true;
                            break;
                        }
                    }
                    if (!servicoEncontrado) System.out.println("Serviço não encontrado.");
                    break;

                case 7: // Exibir dados de todos os serviços
                    System.out.println("\n--- Lista de Todos os Serviços ---");
                    for (Servico s : pousada.getServicos()) {
                        s.exibirDados();
                        System.out.println("-------------------------");
                    }
                    break;

                case 8: // Cadastrar uma reserva
                    System.out.print("Código da Nova Reserva: ");
                    int codigoReserva = teclado.nextInt();
                    teclado.nextLine();
                    
                    System.out.print("CPF do hóspede responsável: ");
                    String cpfReserva = teclado.nextLine();
                    Hospede responsavel = null;
                    for (Hospede h : pousada.getHospedes()) {
                        if (h.getCpf().equals(cpfReserva)) {
                            responsavel = h;
                            break;
                        }
                    }

                    System.out.print("Código da Acomodação: ");
                    int codAcomodacao = teclado.nextInt();
                    Acomodacao acomodacaoEscolhida = null;
                    for (Acomodacao a : pousada.getAcomodacoes()) {
                        if (a.getCodigo() == codAcomodacao) {
                            acomodacaoEscolhida = a;
                            break;
                        }
                    }

                    if (responsavel == null || acomodacaoEscolhida == null) {
                        System.out.println("Erro: hóspede ou acomodação não encontrados. Operação cancelada.");
                        break;
                    }

                    int qtdHospedes;
                    do {
                        System.out.print("Quantidade de Hóspedes: ");
                        qtdHospedes = teclado.nextInt();
                        if (qtdHospedes > acomodacaoEscolhida.getCapacidadeMax()) {
                            System.out.println("Erro: A quantidade excede a capacidade máxima (" 
                                + acomodacaoEscolhida.getCapacidadeMax() + ") da acomodação. Digite novamente.");
                        } else if (qtdHospedes <= 0) {
                            System.out.println("Erro: A reserva precisa ter pelo menos 1 hóspede.");
                        }
                    } while (qtdHospedes > acomodacaoEscolhida.getCapacidadeMax() || qtdHospedes <= 0);

                    int qtdDias;
                    do {
                        System.out.print("Quantidade de Dias: ");
                        qtdDias = teclado.nextInt();
                        if (qtdDias <= 0) {
                            System.out.println("Erro: A quantidade de dias deve ser maior que zero.");
                        }
                    } while (qtdDias <= 0);

                    Reserva novaReserva = new Reserva(codigoReserva, qtdHospedes, qtdDias, responsavel, acomodacaoEscolhida);
                    pousada.getReservas().add(novaReserva);
                    break;

                case 9: // Adicionar serviço a uma reserva
                    System.out.print("Digite o código da reserva: ");
                    int codBuscaReserva = teclado.nextInt();
                    Reserva reservaParaServico = null;
                    for (Reserva r : pousada.getReservas()) {
                        if (r.getCodigo() == codBuscaReserva) {
                            reservaParaServico = r;
                            break;
                        }
                    }

                    System.out.print("Digite o código do serviço: ");
                    int codBuscaServ = teclado.nextInt();
                    Servico servicoParaAdd = null;
                    for (Servico s : pousada.getServicos()) {
                        if (s.getCodigo() == codBuscaServ) {
                            servicoParaAdd = s;
                            break;
                        }
                    }

                    if (reservaParaServico != null && servicoParaAdd != null) {
                        reservaParaServico.contratarServico(servicoParaAdd);
                        System.out.println("Serviço adicionado à reserva com sucesso!");
                    } else {
                        System.out.println("Erro: Reserva ou Serviço não encontrados.");
                    }
                    break;

                case 10: // Exibir dados de uma reserva
                    System.out.print("Digite o código da reserva: ");
                    int codExibir = teclado.nextInt();
                    boolean reservaEncontrada = false;
                    for (Reserva r : pousada.getReservas()) {
                        if (r.getCodigo() == codExibir) {
                            System.out.println("\n--- Dados da Reserva: " + r.getCodigo() + " ---");
                            System.out.println("Acomodação: " + r.getAcomodacao().getTipo() +  " - Código: " + r.getAcomodacao().getCodigo() +
                            " | Diárias: " + r.getQtdDias() + 
                            "\nHóspedes: "+ r.getQtdHospedes() + 
                            " | Responsável: " + r.getHospede().getNome());
                            reservaEncontrada = true;
                            break;
                        }
                    }
                    if (!reservaEncontrada) System.out.println("Reserva não encontrada.");
                    break;

                case 11: // Exibir dados de todas as reservas
                    System.out.println("\n--- Lista de Todas as Reservas ---");
                    for (Reserva r : pousada.getReservas()) {
                        System.out.println("\n--- Dados da Reserva: " + r.getCodigo() + " ---");
                        System.out.println("Acomodação: " + r.getAcomodacao().getTipo() +  " - Código: " + r.getAcomodacao().getCodigo() +
                        " | Diárias: " + r.getQtdDias() + 
                        "\nHóspedes: "+ r.getQtdHospedes() + 
                        " | Responsável: " + r.getHospede().getNome());
                    }
                    break;

                case 12: // Exibir extrato de uma reserva
                    System.out.print("Digite o código da reserva que deseja conferir o extrato: ");
                    int codExtrato = teclado.nextInt();
                    boolean achouParaExtrato = false;
                    
                    for (Reserva r : pousada.getReservas()) {
                        if (r.getCodigo() == codExtrato) {
                            System.out.println("\n======= EXTRATO DA RESERVA =======\n");
                            
                            double valorAcomodacao = r.getAcomodacao().calcPrecoTotal(r.getQtdDias());
                            System.out.println("-> Tipo de acomodação: " + r.getAcomodacao().getTipo());
                            System.out.println("-> Diárias da Acomodação (" + r.getQtdDias() + " dias): R$ " + valorAcomodacao);
                            
                            if(!r.getServicos().isEmpty()){
                                System.out.println("-> Serviços Contratados:");
                                for (Servico s : r.getServicos()) {
                                    System.out.println("Tipo de serviço: " + s.getTipo() + "   - Cód " + s.getCodigo() + ": R$ " + s.calcPrecoTotal(r.getQtdDias())); 
                                }
                            }
                            

                            System.out.println("----------------------------------------");
                            System.out.println("TOTAL A PAGAR: R$ " + r.calcularPrecoTotal());
                            System.out.println("========================================");
                            
                            achouParaExtrato = true;
                            break;
                        }
                    }
                    if (!achouParaExtrato) System.out.println("Reserva não encontrada.");
                    break;

                case 13: // Salvar os dados nos arquivos
                    pousada.salvarDados();
                    break;

                case 14: // Sair
                    System.out.println("Encerrando o sistema da pousada.");
                    break;

                default:
                    System.out.println("Opção inválida! Escolha um número de 1 a 14.");
            }
        } while (opcao != 14);

        teclado.close();
    }
}