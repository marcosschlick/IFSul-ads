public enum DiaSemana {
    SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO;

    public boolean ehDiaUtil() {
        return this != SABADO && this != DOMINGO;
    }
}
