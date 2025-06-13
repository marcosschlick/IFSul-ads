public class Main4 {
    public static void main(String[] args) {
        DiaSemana dia1 = DiaSemana.TERCA;
        DiaSemana dia2 = DiaSemana.SABADO;

        System.out.println(dia1.name() + " é dia útil? " + dia1.ehDiaUtil());
        System.out.println(dia2.name() + " é dia útil? " + dia2.ehDiaUtil());
    }
}
