import java.io.Serializable;

public class Cliente implements Serializable {
    private String nome;
    private int numeroDeConta;
    private double saldo;

    public Cliente(String nome, int numeroDeConta) {
        this.nome = nome;
        this.numeroDeConta = numeroDeConta;
        this.saldo = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroDeConta() {
        return numeroDeConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.printf(" [~] Depósito realizado com sucesso. \n [~] Saldo atual: %.2f%n", saldo);
        } else {
            System.out.println(" [~] Valor de depósito inválido.");
        }
    }

    public void levantar(double valor) {
        if (valor > 0 && saldo >= valor) {
            saldo -= valor;
            System.out.printf(" [~] Levantamento realizado com sucesso. \n [~] Saldo atual: %.2f%n", saldo);
        } else {
            System.out.println(" [~] Valor de levantamento inválido ou saldo insuficiente.");
        }
    }

    public void consultarSaldo() {
        System.out.printf("\n [~] Titular: %s, \n [~] Número da Conta: %d,\n [~] Saldo: %.2f%n", nome, numeroDeConta, saldo);
    }

    @Override
    public String toString() {
        return "\n [~] Nome: " + nome + ",\n [~] Número da Conta: " + numeroDeConta+"\n";
    }
}
