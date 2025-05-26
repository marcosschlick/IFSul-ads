import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataNascimento {
    private LocalDate data;
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public DataNascimento(int dia, int mes, int ano) {
        this.data = LocalDate.of(ano, mes, dia);
    }

    @Override
    public String toString() {
        return DTF.format(data);
    }
}