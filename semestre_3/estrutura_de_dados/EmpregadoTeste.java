package semestre_3.estrutura_de_dados;

public class EmpregadoTeste {
    public static void main(String[] args) {
        Empregado[] empregados = {new Empregado(), new Empregado()};
        empregados[0].setNome("Marcos");
        empregados[0].setSobrenome("Schlick");
        empregados[0].setSalarioMensal(987);
        empregados[1].setNome("William");
        empregados[1].setSobrenome("Meireles");
        empregados[1].setSalarioMensal(5987);

        imprimirEmpregados(empregados);

        aumento(empregados);
        System.out.println("Após o aumento:");
        imprimirEmpregados(empregados);
    }

    private static double getSalarioAnual(Empregado empregado) {
        double salarioAnual = empregado.getSalarioMensal() * 13;
        return salarioAnual;
    }

    private static void aumento(Empregado[] empregados) {
        for (Empregado empregado: empregados){
            empregado.setSalarioMensal(empregado.getSalarioMensal() * 1.1);
        }
    }

    private static void imprimirEmpregados(Empregado[] empregados) {
        for (Empregado empregado: empregados){
            System.out.println(empregado.getNome() + " " + empregado.getSobrenome() + " recebe anualmente " + getSalarioAnual(empregado) + " reais.");
        }
    }
}
