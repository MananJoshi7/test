import java.util.Scanner;

class SumThread extends Thread {
    private int number;
    
    // Constructor to accept the number
    public SumThread(int number) {
        this.number = number;
    }
    
    @Override
    public void run() {
        try {
            // Sleep for 2 seconds to simulate some delay
            Thread.sleep(2000);
            
            // Calculate the sum of numbers from 1 to the given number
            int sum = 0;
            for (int i = 1; i <= number; i++) {
                sum += i;
            }
            
            System.out.println("Sum of numbers from 1 to " + number + " is: " + sum);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }
}

class FactorialThread extends Thread {
    private int number;
    
    // Constructor to accept the number
    public FactorialThread(int number) {
        this.number = number;
    }
    
    @Override
    public void run() {
        try {
            // Sleep for 2 seconds to simulate some delay
            Thread.sleep(2000);
            
            // Calculate the factorial of the given number
            long factorial = 1;
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
            
            System.out.println("Factorial of " + number + " is: " + factorial);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }
}

public class SumAndFactorialWithSleep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Accept the number from the user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        // Create threads for sum and factorial calculations
        SumThread sumThread = new SumThread(number);
        FactorialThread factorialThread = new FactorialThread(number);
        
        // Start the threads
        sumThread.start();
        factorialThread.start();
        
        try {
            // Wait for both threads to finish execution
            sumThread.join();
            factorialThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }
        
        sc.close(); // Close the scanner
    }
}
