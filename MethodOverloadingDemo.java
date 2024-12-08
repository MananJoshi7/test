import java.util.Scanner;

class Calculator {

    public int addfunc(int a, int b) {
        return a + b;
    }

    public double addfunc(double a, double b) {
        return a + b;
    }
}

public class MethodOverloadingDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        // Input for integer addition
        System.out.print("Enter first integer: ");
        int int1 = sc.nextInt();
        System.out.print("Enter second integer: ");
        int int2 = sc.nextInt();

        int intResult = calc.addfunc(int1, int2);
        System.out.println("Sum of integers: " + intResult);

        System.out.print("Enter first double: ");
        double double1 = sc.nextDouble();
        System.out.print("Enter second double: ");
        double double2 = sc.nextDouble();

        double doubleResult = calc.addfunc(double1, double2);
        System.out.println("Sum of doubles: " + doubleResult);

        sc.close();
    }
}
