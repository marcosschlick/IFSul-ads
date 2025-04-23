public class Pessoa {

    private String nome;
    private int altura;
    private int idade;
    private double peso;
    private boolean temPet;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean isTemPet() {
        return temPet;
    }

    public void setTemPet(boolean temPet) {
        this.temPet = temPet;
    }

    public void comer(String comida) {
        System.out.println("HMMMMMMMMMMM, Estou comendo uma " + comida + " deliciosa!!!!" );
    }

    public void passearComPet() {
        System.out.println(temPet ? "Passeando com o meu pet..." : "COMO VOCÊ TENTA FAZER ALGUEM QUE NÃO TEM PET PASSEAR COM UM??????");
    }

    public void fazerAniversario() {
        this.idade ++;
        System.out.println(idade < 100 ? this.nome + " fez " + this.idade + " anos" : this.nome + " morreu :( :(");
    }

}
