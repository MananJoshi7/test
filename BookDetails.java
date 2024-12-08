import java.util.Scanner;


class Publisher {
    protected String publisherName;
    protected int publisherId;

    public void getdata(Scanner sc) {
        System.out.print("Enter Publisher Name: ");
        publisherName = sc.nextLine();
        System.out.print("Enter Publisher ID: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid Publisher ID: ");
            sc.next(); 
        }
        publisherId = sc.nextInt();
        sc.nextLine(); 
    }

    public void showdata() {
        System.out.println("Publisher Name: " + publisherName);
        System.out.println("Publisher ID: " + publisherId);
    }
}


class Book extends Publisher {
    private String bookName;
    private int bookId;
    private String authorName;


    @Override
    public void getdata(Scanner sc) {
        super.getdata(sc); 
        System.out.print("Enter Book Name: ");
        bookName = sc.nextLine();
        System.out.print("Enter Book ID: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid Book ID: ");
            sc.next(); 
        }
        bookId = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter Author Name: ");
        authorName = sc.nextLine();
    }

    @Override
    public void showdata() {
        super.showdata(); 
        System.out.println("Book Name: " + bookName);
        System.out.println("Book ID: " + bookId);
        System.out.println("Author Name: " + authorName);
    }
}

public class BookDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book book = new Book();

        System.out.println("Enter details for the book and publisher:");
        book.getdata(sc);

        System.out.println("\nBook and Publisher Details:");
        book.showdata();

        sc.close();
    }
}
