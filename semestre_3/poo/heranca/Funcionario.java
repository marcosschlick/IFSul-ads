package semestre_3.poo.heranca;

import java.util.Random;

public class Funcionario extends Pessoa{

    private double salario;
    private String cargo;
    private int cargaHorariaDiaria;
    private String setor;
    private String codigo;

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getCargaHorariaDiaria() {
        return cargaHorariaDiaria;
    }

    public void setCargaHorariaDiaria(int cargaHorariaDiaria) {
        this.cargaHorariaDiaria = cargaHorariaDiaria;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void trabalhar(int horas) {
        System.out.println(super.getNome() + " trabalhou por " + horas + " horas.");
    }

    public void darAtestado() {
        Random random = new Random();
        int funcionou = random.nextInt(2);
        System.out.println(funcionou == 1 ? super.getNome() + " pode faltar ao trabalho" : "ESSE ATESTADO É FALSO SEU COMÉDIA");
    }

    public void receberAumento(double porcentagem) {
        double aux = porcentagem / 100 + 1;
        this.salario *= aux;
        System.out.println(super.getNome() + " após o aumento seu salário é " + this.salario + " reais.");
    }
}
