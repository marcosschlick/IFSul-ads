package poo.GetSet;

public class ContaBancaria {
    private String titular;
    private double saldo;

    public void depositar(double valor) {
        this.saldo += valor;
        System.out.println("(" + this.titular + ") Após o depósito de " + valor + "$ o saldo ficou " + this.saldo + "$");
    }

    public void sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("(" + this.titular + ") Após o saque de " + valor + "$ o saldo ficou " + this.saldo + "$");
        } else {
            System.out.println("(" + this.titular + ") Saque não efetuado por falta de saldo");
        }
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
