package sistemabancariojava.app;

import sistemabancariojava.model.entities.Banco;
import sistemabancariojava.model.entities.ContaBancaria;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        Banco bancoPicpay = new Banco("PicPay", "1010");
        Banco bancoInter = new Banco("Inter", "0090");
        Banco bancoNubank = new Banco("Nubank", "0512");

        loop:
        while (true) {
            System.out.println();
            System.out.println("* MENU PRINCIPAL *");
            System.out.println();
            System.out.println("0 - Encerrar programa");
            System.out.println("1 - Selecionar banco");
            System.out.println("---------------------------------------------------------------------------");

            String opcaoMenuPrincipal = scanner.nextLine();

            if (opcaoMenuPrincipal.equals("0")) {
                System.out.println("Encerrando programa..");
                System.out.println("---------------------------------------------------------------------------");
                break loop;
            } else if (opcaoMenuPrincipal.equals("1")) {
                System.out.println();
                System.out.println("Bancos disponíveis:\n");
                System.out.printf("1 - PicPay - (%d) contas cadastradas%n", bancoPicpay.getContas().size());
                System.out.printf("2 - Inter - (%d) contas cadastradas%n", bancoInter.getContas().size());
                System.out.printf("3 - Nubank - (%d) contas cadastradas%n", bancoNubank.getContas().size());
                System.out.println("---------------------------------------------------------------------------");

                String bancoEscolhido = scanner.nextLine();
                switch (bancoEscolhido) {
                    case "1": {
                        while (true) {
                            System.out.println();
                            System.out.println("Bem vindo ao banco " + bancoPicpay.getNome() + "!\n");
                            System.out.println("0 - Voltar ao menu principal");
                            System.out.println("1 - Criar nova conta");
                            System.out.println("2 - Exibir contas");
                            System.out.println("---------------------------------------------------------------------------");

                            String opcaoEscolhida = scanner.nextLine();

                            if (opcaoEscolhida.equals("0")) {
                                break;
                            }
                            if (opcaoEscolhida.equals("1")) {
                                System.out.println();
                                System.out.println("-- Cadastro --");
                                System.out.print("Nº da conta: ");
                                String nConta = scanner.nextLine();
                                System.out.print("Nome do titular: ");
                                String titular = scanner.nextLine();
                                System.out.print("Saldo inicial: ");
                                double saldoInicial = scanner.nextDouble();
                                scanner.nextLine();
                                ContaBancaria novaConta = bancoPicpay.criarNovaConta(nConta, titular, saldoInicial);

                                System.out.println();
                                System.out.println("Conta " + novaConta.getnConta() + " criada com sucesso!");
                                System.out.println("---------------------------------------------------------------------------");
                                bancoPicpay.operar(novaConta);
                                break;
                            }
                            if (opcaoEscolhida.equals("2")) {
                                System.out.println();
                                if (bancoPicpay.getContas().isEmpty()) {
                                    System.out.println("Nenhuma conta cadastrada no banco.");
                                    System.out.println("---------------------------------------------------------------------------");
                                } else {
                                    System.out.println("-- Contas -- ");
                                    System.out.println("---------------------------------------------------------------------------");
                                    List<ContaBancaria> list = bancoPicpay.getContas();
                                    int ultimaPosicaoLista = list.size() - 1;
                                    for (int i = 0; i < list.size(); i++) {
                                        System.out.println(list.get(i));
                                        if(i != ultimaPosicaoLista && list.size() > 1) {
                                            System.out.println("---------------");
                                        }
                                    }

//                                    for (ContaBancaria c : bancoPicpay.getContas()) {
//                                        System.out.println(c);
//                                        System.out.println("---------------");
//                                    }
                                    System.out.println("---------------------------------------------------------------------------");
                                }
                                break;
                            } else {
                                System.out.println();
                                System.out.println("Opção inválida.");
                                System.out.println("---------------------------------------------------------------------------");
                            }
                        }

                        break;
                    }
                    case "2": {
                        while (true) {
                            System.out.println();
                            System.out.println("Bem vindo ao banco " + bancoInter.getNome() + "!\n");
                            System.out.println("0 - Voltar ao menu principal");
                            System.out.println("1 - Criar nova conta");
                            System.out.println("2 - Exibir contas");
                            System.out.println("---------------------------------------------------------------------------");

                            String opcaoEscolhida = scanner.nextLine();

                            if (opcaoEscolhida.equals("0")) {
                                break;
                            }
                            if (opcaoEscolhida.equals("1")) {
                                System.out.println();
                                System.out.println("-- Cadastro --");
                                System.out.print("Nº da conta: ");
                                String nConta = scanner.nextLine();
                                System.out.print("Nome do titular: ");
                                String titular = scanner.nextLine();
                                System.out.print("Saldo inicial: ");
                                double saldoInicial = scanner.nextDouble();
                                scanner.nextLine();


                                ContaBancaria novaConta = bancoInter.criarNovaConta(nConta, titular, saldoInicial);

                                System.out.println();
                                System.out.println("Conta " + novaConta.getnConta() + " criada com sucesso!");
                                System.out.println("---------------------------------------------------------------------------");
                                bancoInter.operar(novaConta);
                                break;
                            }
                            if (opcaoEscolhida.equals("2")) {
                                System.out.println();
                                if (bancoInter.getContas().isEmpty()) {
                                    System.out.println("Nenhuma conta cadastrada no banco.");
                                    System.out.println("---------------------------------------------------------------------------");
                                } else {
                                    System.out.println("-- Contas -- ");
                                    System.out.println("---------------------------------------------------------------------------");

                                    List<ContaBancaria> list = bancoInter.getContas();
                                    int ultimaPosicaoLista = list.size() - 1;
                                    for (int i = 0; i < list.size(); i++) {
                                        System.out.println(bancoInter.getContas().get(i));
                                        if(i != ultimaPosicaoLista && list.size() > 1) {
                                            System.out.println("---------------");
                                        }
                                    }
//                                    for (ContaBancaria c : bancoInter.getContas()) {
//                                        System.out.println(c);
//                                        System.out.println("---------------");
//                                    }
                                    System.out.println("---------------------------------------------------------------------------");
                                }
                                break;
                            }
                        }

                        break;
                    }

                    case "3": {
                        while (true) {
                            System.out.println();
                            System.out.println("Bem vindo ao banco " + bancoNubank.getNome() + "!\n");
                            System.out.println("0 - Voltar ao menu principal");
                            System.out.println("1 - Criar nova conta");
                            System.out.println("2 - Exibir contas");
                            System.out.println("---------------------------------------------------------------------------");

                            String opcaoEscolhida = scanner.nextLine();

                            if (opcaoEscolhida.equals("0")) {
                                break;
                            }
                            if (opcaoEscolhida.equals("1")) {
                                System.out.println();
                                System.out.println("-- Cadastro --");
                                System.out.print("Nº da conta: ");
                                String nConta = scanner.nextLine();
                                System.out.print("Nome do titular: ");
                                String titular = scanner.nextLine();
                                System.out.print("Saldo inicial: ");
                                double saldoInicial = scanner.nextDouble();
                                scanner.nextLine();
                                ContaBancaria novaConta = bancoNubank.criarNovaConta(nConta, titular, saldoInicial);

                                System.out.println();
                                System.out.println("Conta " + novaConta.getnConta() + " criada com sucesso!");
                                System.out.println("---------------------------------------------------------------------------");
                                bancoNubank.operar(novaConta);
                                break;
                            }
                            if (opcaoEscolhida.equals("2")) {
                                System.out.println();
                                if (bancoNubank.getContas().isEmpty()) {
                                    System.out.println("Nenhuma conta cadastrada no banco.");
                                    System.out.println("---------------------------------------------------------------------------");
                                } else {
                                    System.out.println("-- Contas -- ");
                                    System.out.println("---------------------------------------------------------------------------");
                                    List<ContaBancaria> list = bancoNubank.getContas();
                                    int ultimaPosicaoLista = list.size() - 1;
                                    for (int i = 0; i < list.size(); i++) {
                                        System.out.println(bancoNubank.getContas().get(i));
                                        if(i != ultimaPosicaoLista && list.size() > 1) {
                                            System.out.println("---------------");
                                        }
                                    }
//                                    for (ContaBancaria c : bancoNubank.getContas()) {
//                                        System.out.println(c);
//                                        System.out.println("---------------");
//                                    }
                                    System.out.println("---------------------------------------------------------------------------");
                                }
                                break;
                            }
                        }

                        break;
                    }
                    default: {
                        System.out.println("\nOpção inválida.");
                        System.out.println("---------------------------------------------------------------------------");
                    }


                }
            } else {
                System.out.println("\nOpção inválida.");
                System.out.println("---------------------------------------------------------------------------");
            }
        }
    }
}
