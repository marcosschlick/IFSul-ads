package semestre_3.poo.getters_setters;

public class CarroTeste {
    public static void main(String[] args) {
        Carro carro1 = new Carro();
        Carro carro2 = new Carro();

        carro1.setMarca("Ford");
        carro1.setModelo("Ka");
        carro1.setAno(1998);

        carro2.setMarca("Ford");
        carro2.setModelo("Corcel");
        carro2.setAno(1976);

        System.out.println("Carro 1: marca: " + carro1.getMarca() + " | modelo: " + carro1.getModelo() + " | ano: " + carro1.getAno());
        System.out.println("Carro 2: marca: " + carro2.getMarca() + " | modelo: " + carro2.getModelo() + " | ano: " + carro2.getAno());

    }
}
