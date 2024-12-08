import java.util.LinkedList;
import java.util.Iterator;
import java.util.Scanner;

class Address {
    String name;
    String city;
    String state;

    public Address(String name, String city, String state) {
        this.name = name;
        this.city = city;
        this.state = state;
    }

    public void displayAddress() {
        System.out.println("Name: " + name + ", City: " + city + ", State: " + state);
    }
}

class Maillist {
    LinkedList<Address> addressList;

    public Maillist() {
        addressList = new LinkedList<>();
    }

    public void addAddress(Address address) {
        addressList.add(address);
    }

    public void displayAddresses() {
        Iterator<Address> iterator = addressList.iterator();

        if (!iterator.hasNext()) {
            System.out.println("No addresses to display.");
        } else {
            while (iterator.hasNext()) {
                iterator.next().displayAddress();
            }
        }
    }
}


public class AddressBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Maillist maillist = new Maillist(); 
        
        System.out.print("Enter the number of addresses to add: ");
        int n = 0;
        
        while (true) {
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n <= 0) {
                    System.out.println("Please enter a positive number of addresses.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Address " + (i + 1) + ":");

            System.out.print("Enter name: ");
            String name = sc.nextLine();
            
            System.out.print("Enter city: ");
            String city = sc.nextLine();
            
            System.out.print("Enter state: ");
            String state = sc.nextLine();

            Address address = new Address(name, city, state);
            maillist.addAddress(address);  
        }

        System.out.println("\nAddress List:");
        maillist.displayAddresses();
        
        sc.close(); 
    }
}
