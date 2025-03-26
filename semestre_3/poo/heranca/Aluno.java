package semestre_3.poo.heranca;

public class Aluno extends Pessoa{

    private int canetasRoubadas;
    private boolean carater = false;
    private double nota;
    private boolean nerd;
    private boolean preguicoso;

    public int getCanetasRoubadas() {
        return canetasRoubadas;
    }

    public void setCanetasRoubadas(int canetasRoubadas) {
        this.canetasRoubadas = canetasRoubadas;
    }

    public boolean isCarater() {
        return carater;
    }

    public void setCarater(boolean carater) {
        this.carater = carater;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public boolean isNerd() {
        return nerd;
    }

    public void setNerd(boolean nerd) {
        this.nerd = nerd;
    }

    public boolean isPreguicoso() {
        return preguicoso;
    }

    public void setPreguicoso(boolean preguicoso) {
        this.preguicoso = preguicoso;
    }

    public void fazerProva(int nota) {
        System.out.println(nota < 6 ? super.getNome() + " VOCÊ É BURROOOOOOO" : "nada mais que a obrigação...");
    }

    public void passear() {
        System.out.println("Tchau professor estou indo ao banheiro...");
    }

    public void estudar() {
        System.out.println("NÃO MENTE ALUNO SAFADO");
    }

}
