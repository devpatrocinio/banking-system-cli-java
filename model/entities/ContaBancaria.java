package sistemabancariojava.model.entities;

import sistemabancariojava.model.util.Logger;

public class ContaBancaria {

    private static final int MAX_CARACTERES_NOME = 12;

    private String nConta;
    private String titular;
    private double saldo = 0.0;

    private Logger logger;

    private Banco banco;

    public ContaBancaria() {

    }

    public ContaBancaria(Banco banco, String nConta, String titular, Logger logger) {
        if (titular == null || titular.isBlank()) {
            throw new RuntimeException("Erro na criação da conta: A conta deve ter um titular.");
        }

        this.banco = banco;
        this.titular = (titular.trim().length() > MAX_CARACTERES_NOME) ? titular.trim().substring(0, MAX_CARACTERES_NOME) : titular;
        this.nConta = nConta;
        this.logger = logger;
    }

    public ContaBancaria(Banco banco, String nConta, String titular, double saldoInicial, Logger logger) {
        if (titular == null || titular.isBlank()) {
            throw new RuntimeException("Erro na criação da conta: A conta deve ter um titular.");
        }

        this.banco = banco;
        this.titular = (titular.trim().length() > MAX_CARACTERES_NOME) ? titular.trim().substring(0, MAX_CARACTERES_NOME) : titular;
        this.nConta = nConta;
        this.saldo = saldoInicial;
        this.logger = logger;
    }

    public String getnConta() {
        return this.nConta;
    }

    public void setnConta(String nConta) {
        this.nConta = nConta;
    }

    public String getTitular() {
        return this.titular;
    }

    public void setTitular(String titular) {
        if (titular == null || titular.isBlank()) {
            throw new RuntimeException("Erro ao definir nome, o nome do titular não pode ser vazio.");
        }

        this.titular = (titular.trim().length() > MAX_CARACTERES_NOME) ? titular.trim().substring(0, MAX_CARACTERES_NOME) : titular;
    }

    public Logger getLogger() {
        return logger;
    }

    public Banco getBanco() {
        return this.banco;
    }

    public double mostrarSaldo() {
        return this.saldo;
    }

    public void depositar(double quantia) {
        if (quantia < 1) {
            System.out.println();
            this.logger.logEvento("Erro na operação, o valor mínimo de depósito é R$ 1.00.");
            this.logger.logEvento("Saldo atual: R$" + String.format("%.2f", mostrarSaldo()));
            return;
        }

        this.saldo += quantia;
        System.out.println();
        this.logger.logEvento("Depósito no valor de R$" + String.format("%.2f", quantia) + " realizado com sucesso.");
        this.logger.logEvento("Saldo atual: R$" + String.format("%.2f", mostrarSaldo()));
    }

    public void sacar(double quantia) {
        if (quantia <= 0) {
            System.out.println();
            this.logger.logEvento("O valor de saque é inválido.");
            this.logger.logEvento("Saldo atual: R$" + String.format("%.2f", mostrarSaldo()));
            return;
        }
        if (quantia > this.saldo) {
            System.out.println();
            this.logger.logEvento("Erro na operação, o valor de saque não pode ser maior do que o saldo.");
            this.logger.logEvento("Saldo atual: R$" + String.format("%.2f", mostrarSaldo()));
            return;
        }

        this.saldo -= quantia;
        System.out.println();
        this.logger.logEvento("Saque no valor de R$" + String.format("%.2f", quantia) + " realizado com sucesso.");
        this.logger.logEvento("Saldo atual: R$" + String.format("%.2f", mostrarSaldo()));
    }

    @Override
    public String toString() {
        return "Banco: " + banco.getNome() + "\n" +
                "Conta " + banco.getAg() + "/" + nConta + ":\n" +
                "Titular: " + titular + "\n" +
                "Saldo: R$" + String.format("%.2f", saldo);
    }
}
