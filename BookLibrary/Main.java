import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Boolean running = true;
        int action;

        while(running){
            System.out.println("View books");
            System.out.println("Search");            
            System.out.println("Add book");            
            System.out.println("Exit. 6");       
            action = Integer.parseInt(sc.nextLine());

            switch (action) {
                case 1:
                    System.out.println("View books");
                    System.out.println("Search");            
                    System.out.println("Add book");            
                    System.out.println("Exit. 6");     
                    Book book = new Book(null, null, action, action)

                case 6:
                    running = false;
                    break;
                default:
                    break;
            }
            sc.close();
        }
    }
}

