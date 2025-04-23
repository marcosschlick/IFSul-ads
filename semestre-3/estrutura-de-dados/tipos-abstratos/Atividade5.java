import java.util.ArrayList;
import java.util.Date;

class Document {
    private ArrayList<String> authors;
    private Date date;
    private int aux;

    public String getAuthors() {
        return authors.toString();
    }

    public void addAuthor(String name) {
        this.authors.add(name);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAux() {
        return aux;
    }

    public void setAux(int aux) {
        this.aux = aux;
    }
}

class Book extends Document{
    private String title;

    public Book(String title, Date date) {
        this.title = title;
        this.setDate(date);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

class EMail extends Document{
    private String subject;
    private String[] to;

    public EMail(String subject, Date date) {
        this.subject = subject;
        this.setDate(date);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }
}

public class Atividade5 {

    public static void main(String[] args) {
        Date date = new Date();

        Book book = new Book("Java Programming", date);
        book.addAuthor("John Doe");

        System.out.println("Book Title: " + book.getTitle());
        System.out.println("Author: " + String.join(", ", book.getAuthors()));
        System.out.println("Date: " + book.getDate());


    }
}