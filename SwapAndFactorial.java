import java.util.Scanner;

public class SwapAndFactorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Swapping without third variable
        System.out.print("Enter two numbers to swap: ");
        int num1 = sc.nextInt(), num2 = sc.nextInt();
        System.out.println("Before: num1 = " + num1 + ", num2 = " + num2);

        num1 = num1 + num2;
        num2 = num1 - num2;
        num1 = num1 - num2;
        System.out.println("After: num1 = " + num1 + ", num2 = " + num2);

        // Factorial calculation
        System.out.print("\nEnter a number for factorial: ");
        int num = sc.nextInt();
        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }

        System.out.println("Factorial of " + num + " is: " + factorial);
    }
}
