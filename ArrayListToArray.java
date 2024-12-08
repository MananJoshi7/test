import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListToArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create an ArrayList to store integers
        ArrayList<Integer> numbers = new ArrayList<>();

        // Accept the number of elements from the user
        System.out.print("Enter the number of elements you want to add to the ArrayList: ");
        int n = sc.nextInt();

        // Add elements to the ArrayList
        for (int i = 0; i < n; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers.add(sc.nextInt());
        }

        // Convert ArrayList to array
        Integer[] numArray = new Integer[numbers.size()];
        numArray = numbers.toArray(numArray);

        // Display the elements of the array
        System.out.println("\nContents of the Array:");
        for (int i = 0; i < numArray.length; i++) {
            System.out.println("Element " + (i + 1) + ": " + numArray[i]);
        }

        // Calculate the sum of the numbers in the array
        int sum = 0;
        for (int num : numArray) {
            sum += num;
        }

        // Display the sum of the elements
        System.out.println("\nSum of the elements: " + sum);

        sc.close(); // Close the scanner
    }
}