public class Main {
    public static void main(String[] args) {

        String fraseParaEncriptar = "EU ODEIO JAVA NA SEXTA";
        String chaveDeEncriptacao = "ATIVIDADE";

        Encriptador encriptador = new Encriptador(fraseParaEncriptar, chaveDeEncriptacao);

        System.out.println("FRASE ORIGINAL:");
        System.out.println(fraseParaEncriptar);
        System.out.println();

        System.out.println("PASSO 1:");
        String passo1 = encriptador.passo1();
        System.out.println(passo1);
        System.out.println("VERIFICAÇÃO: " + passo1.equals("A5T21 I15V4I5D9A15 D10E1A22T1 I14V1 I19D5A24D20E1"));
        System.out.println();

        System.out.println("PASSO 2:");
        String passo2 = encriptador.passo2();
        System.out.println(passo2);
        System.out.println("VERIFICAÇÃO: " + passo2.equals("E1D20A24D5I19 V1I14 T1A22E1D10 A15D9I5V4I15 T21A5"));
        System.out.println();

        System.out.println("PASSO 3:");
        String passo3 = encriptador.passo3();
        System.out.println(passo3);
        System.out.println("VERIFICAÇÃO: " + passo3.equals("E18D360A432D90I342 V18I252 T18A396E18D180 A270D162I90V72I270 T378A90"));
        System.out.println();

        System.out.println("PASSO 4:");
        String passo4 = encriptador.passo4();
        System.out.println(passo4);
        System.out.println("VERIFICAÇÃO: " + passo4.equals("E200D4000A4800D1000I3800 V200I2800 T200A4400E200D2000 A3000D1800I1000V800I3000 T4200A1000"));
        System.out.println();

        System.out.println("DESENCRIPTAÇÃO:");
        String desencriptacao = encriptador.desencriptar();
        System.out.println(desencriptacao);
        System.out.println("VERIFICAÇÃO: " + desencriptacao.equals(fraseParaEncriptar));
        System.out.println();
    }
}
