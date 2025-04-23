public class PortaTeste {
    public static void main(String[] args) {
        Porta porta1 = new Porta();
        System.out.print("Porta 1: ");
        porta1.imprimir();

        Porta porta2 = new Porta(true, "azul", 210, 130, 12);
        System.out.print("Porta 2: ");
        porta2.imprimir();

        Porta porta3 = new Porta();
        porta3.setCor("Verde");
        porta3.setDimensaoX(234);
        porta3.setDimensaoY(125);
        porta3.setDimensaoZ(20);
        porta3.setAberta(true);
        System.out.print("Porta 3: ");
        porta3.imprimir();

        System.out.println("Porta 1:" + porta1.estaAberta());
        System.out.println("Porta 2:" + porta2.estaAberta());
        System.out.println("Porta 3:" + porta3.estaAberta());

        System.out.print("Porta 1: ");
        porta1.pintar("Roxo");
        System.out.print("Porta 2 ");
        porta2.pintar("Preto");
        System.out.print("Porta 3: ");
        porta3.pintar("Preto");

        System.out.print("Porta 1: ");
        porta1.imprimir();
        System.out.print("Porta 2: ");
        porta2.imprimir();
        System.out.print("Porta 3: ");
        porta3.imprimir();

        System.out.print("Porta 1: ");
        porta1.abrir();
        System.out.print("Porta 2: ");
        porta2.abrir();
        System.out.print("Porta 3: ");
        porta3.abrir();

        System.out.print("Porta 1: ");
        porta1.fechar();
        System.out.print("Porta 2: ");
        porta2.fechar();
        System.out.print("Porta 3: ");
        porta3.abrir();
    }
}
