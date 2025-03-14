package poo.GetSet;

public class ContaBancariaTeste {
    public static void main(String[] args) {
        ContaBancaria contaBancaria1 = new ContaBancaria();
        ContaBancaria contaBancaria2 = new ContaBancaria();

        contaBancaria1.setTitular("Marcos Schlick");
        contaBancaria1.setSaldo(54.5);

        contaBancaria2.setTitular("William Meireles");
        contaBancaria2.setSaldo(4590.99);

        System.out.println("Titular da conta 1: " + contaBancaria1.getTitular() + " | saldo: " + contaBancaria1.getSaldo() + "$");
        System.out.println("Titular da conta 2: " + contaBancaria2.getTitular() + " | saldo: " + contaBancaria2.getSaldo() + "$");

        contaBancaria1.sacar(98);
        contaBancaria2.sacar(690);

        contaBancaria1.depositar(1000);
        contaBancaria2.depositar(1000);

        System.out.println("Titular da conta 1: " + contaBancaria1.getTitular() + " | saldo: " + contaBancaria1.getSaldo() + "$");
        System.out.println("Titular da conta 2: " + contaBancaria2.getTitular() + " | saldo: " + contaBancaria2.getSaldo() + "$");
    }
}
