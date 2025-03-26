/*
Criar um algoritmo em java para a seguinte descrição:

Classe: Porta

Atributos: aberta, cor, dimensaoX, dimensaoY, dimensaoZ

Métodos: void abre(); void fecha(); void pinta(String s); boolean estaAberta()

Crie o construtor, abra e feche a porta. Pinte-a de diversas cores, altere suas dimensões e use o método estaAberta() para verificar se ela está aberta. Crie um método para exibir todos os dados da porta.
                                                                                                     */
package semestre_3.poo.getters_setters;

public class Porta {
    private boolean aberta = false;
    private String cor = "Marrom madeira";
    private int dimensaoX = 100;
    private int dimensaoY = 200;
    private int dimensaoZ = 10;

    public Porta() {
    }

    public Porta(boolean aberta, String cor, int dimensaoX, int dimensaoY, int dimensaoZ) {
        this.aberta = aberta;
        this.cor = cor;
        this.dimensaoX = dimensaoX;
        this.dimensaoY = dimensaoY;
        this.dimensaoZ = dimensaoZ;
    }

    public void abrir() {
        if(this.aberta) {
            System.out.println("A porta já está aberta.");
        } else {
            this.aberta = true;
            System.out.println("A porta foi aberta.");
        }
    }

    public void fechar() {
        if(!this.aberta) {
            System.out.println("A porta já está fechada.");
        } else {
            this.aberta = true;
            System.out.println("A porta foi fechada.");
        }
    }


    public void pintar(String color){
        this.cor = color;
    }

    public void imprimir() {
        System.out.println("A porta tem " + dimensaoX + "cm de largura por " + dimensaoY + "cm de altura e " + dimensaoZ + "cm de profundidade, ela tem a cor " + this.cor + " e está " + this.estaAberta() + ".");
    }


    public String estaAberta() {
        return (this.aberta ? "aberta" : "fechada");
    }

    public boolean isAberta() {
        return aberta;
    }

    public void setAberta(boolean aberta) {
        this.aberta = aberta;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getDimensaoX() {
        return dimensaoX;
    }

    public void setDimensaoX(int dimensaoX) {
        this.dimensaoX = dimensaoX;
    }

    public int getDimensaoY() {
        return dimensaoY;
    }

    public void setDimensaoY(int dimensaoY) {
        this.dimensaoY = dimensaoY;
    }

    public int getDimensaoZ() {
        return dimensaoZ;
    }

    public void setDimensaoZ(int dimensaoZ) {
        this.dimensaoZ = dimensaoZ;
    }
}
