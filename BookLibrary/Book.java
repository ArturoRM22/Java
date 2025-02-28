import java.util.Scanner;
// Class definition
public class Book {
    // Attributes (instance variables)
    String title;
    String author;
    int isbn;
    int copies;

    public Book(String title, String author, int isbn, int copies) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.copies = copies;
    }

    public void createBook() {
        System.out.println("Registrar libro");
        Scanner sc = new Scanner(System.in);
        System.out.println("Title");
        title = sc.nextLine();
        System.out.println("Author");
        author = sc.nextLine();
        System.out.println("ISBN");
        isbn = Integer.parseInt(sc.nextLine());
        System.out.println("copies");
        copies = Integer.parseInt(sc.nextLine());
    }

    public void display() {
        System.out.println(title);
    }
}
