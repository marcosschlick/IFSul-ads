public class Teste {
    public static void main(String[] args) {
        Elefante elefante1 = new Elefante("bramido", "cinza");
        elefante1.setNome("Trombudo");
        elefante1.setNumeroPernas(4);

        Elefante elefante2 = new Elefante("bramido", "marrom");
        elefante2.setNome("Narigudo");
        elefante2.setNumeroPernas(4);

        Gato gato1 = new Gato("mia", "preto");
        gato1.setNome("Kyuubi");
        gato1.setNumeroPernas(4);

        Gato gato2 = new Gato("mia", "branco");
        gato2.setNome("Filó");
        gato2.setNumeroPernas(4);

        Urso urso1 = new Urso("ruge", "branco");
        urso1.setNome("Fofinho");
        urso1.setNumeroPernas(4);

        Urso urso2 = new Urso("ruge", "preto");
        urso2.setNome("Ursão");
        urso2.setNumeroPernas(4);

        gato1.entregarComidaC();
        gato1.andarAnimal(100);

        gato2.entregarComidaC();
        gato2.andarAnimal(1000);

        elefante1.entregarComidaH();
        elefante1.andarAnimal(1000);

        elefante2.entregarComidaH();
        elefante2.andarAnimal(100);

        urso1.entregarComidaC();
        urso1.entregarComidaH();
        urso1.andarAnimal(100);
        urso1.andarAnimal(1000);

        urso2.entregarComidaC();
        urso2.entregarComidaH();
        urso2.andarAnimal(100);
        urso2.andarAnimal(1000);



    }
}
