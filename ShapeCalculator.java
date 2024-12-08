import java.util.Scanner;

interface Shape {
    double calculateArea();
    double calculateCircumference();
    double calculateVolume();
}

abstract class Shape3D implements Shape {

    public void displayDetails() {
        System.out.println("Area: " + calculateArea());
        System.out.println("Circumference: " + calculateCircumference());
        System.out.println("Volume: " + calculateVolume());
    }
}

final class Circle extends Shape3D {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    public double calculateVolume() {
        return 0; 
    }
}

final class Rectangle extends Shape3D {
    private double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double calculateArea() {
        return length * width;
    }

    public double calculateCircumference() {
        return 2 * (length + width);
    }

    public double calculateVolume() {
        return 0;  
    }
}

final class Sphere extends Shape3D {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double calculateArea() {
        return 4 * Math.PI * radius * radius;
    }

    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    public double calculateVolume() {
        return (4.0 / 3) * Math.PI * Math.pow(radius, 3);
    }
}

public class ShapeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter radius for Circle: ");
        double circleRadius = sc.nextDouble();
        Circle circle = new Circle(circleRadius);
        System.out.println("Circle Details:");
        circle.displayDetails();

        System.out.print("\nEnter length and width for Rectangle: ");
        double rectLength = sc.nextDouble();
        double rectWidth = sc.nextDouble();
        Rectangle rectangle = new Rectangle(rectLength, rectWidth);
        System.out.println("Rectangle Details:");
        rectangle.displayDetails();

        System.out.print("\nEnter radius for Sphere: ");
        double sphereRadius = sc.nextDouble();
        Sphere sphere = new Sphere(sphereRadius);
        System.out.println("Sphere Details:");
        sphere.displayDetails();

        sc.close();
    }
}
