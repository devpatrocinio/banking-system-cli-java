package sistemabancariojava.model.entities;

import sistemabancariojava.model.util.Logger;

import java.util.*;

public class Banco {

    private String nome;
    private String ag;
    private final List<ContaBancaria> contas = new ArrayList<>();

    public Banco(String nome, String ag) {
        this.nome = nome;
        this.ag = ag;
    }

    public ContaBancaria criarNovaConta(String nConta, String titular) {
        ContaBancaria novaConta = new ContaBancaria(new Banco(this.getNome(), this.ag), nConta, titular, new Logger());
        this.adicionarConta(novaConta);

        return novaConta;
    }

    public ContaBancaria criarNovaConta(String nConta, String titular, double saldoInicial) {
        ContaBancaria novaConta = new ContaBancaria(new Banco(this.getNome(), this.ag), nConta, titular, saldoInicial, new Logger());
        this.adicionarConta(novaConta);

        return novaConta;
    }

    public void adicionarConta(ContaBancaria acc) {
        this.contas.add(acc);
    }

    public <T extends ContaBancaria> void operar(T acc) {
        System.out.println("* Conta " + acc.getBanco().getAg() + "/" + acc.getnConta() + " - " + "Banco " + acc.getBanco().getNome() + " *\n");

        Scanner scanner = new Scanner(System.in);
        String operacaoEscolhida;
        loop:
        while (true) {
            System.out.println("* OPERAÇÕES DA CONTA *");
            System.out.println("0 - Voltar ao menu principal");
            System.out.println("1 - Depósito");
            System.out.println("2 - Saque");
            System.out.println("3 - Informações da conta");
            System.out.println("---------------------------------------------------------------------------");

            try {
                operacaoEscolhida = scanner.next().trim();

                switch (operacaoEscolhida) {
                    case "0":
                        System.out.println("Fechando menu de operações da conta.");
                        System.out.println("---------------------------------------------------------------------------");
                        break loop;
                    case "1":
                        System.out.println("* DEPÓSITO *");
                        System.out.print("Insira o valor de depósito: ");
                        acc.depositar(scanner.nextDouble());
                        System.out.println("---------------------------------------------------------------------------");
                        break;
                    case "2":
                        System.out.println("* SAQUE *");

                        System.out.print("Insira o valor do saque: ");
                        acc.sacar(scanner.nextDouble());
                        System.out.println("---------------------------------------------------------------------------");
                        break;
                    case "3":
                        System.out.println("* INFORMAÇÕES DA CONTA *");

                        System.out.println(acc);
                        System.out.println("---------------------------------------------------------------------------");
                        break;
                    default:
                        System.out.println("Operação inválida.");
                        System.out.println("---------------------------------------------------------------------------");
                        break;
                }

            } catch (InputMismatchException e) {
                acc.getLogger().logEvento("Valor inválido inserido.");
                System.out.println("---------------------------------------------------------------------------");
            }
        }
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAg() {
        return ag;
    }

    public void setAg(String ag) {
        this.ag = ag;
    }

    public List<ContaBancaria> getContas() {
        return contas;
    }
}
