import java.io.*;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileOperations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String inputString = sc.nextLine();
        String upperCaseString = inputString.toUpperCase();

        try (FileWriter writer = new FileWriter("output.txt", true)) {
            writer.write("Uppercase String: " + upperCaseString + "\n");
            System.out.println("String converted to uppercase and written to output.txt.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        System.out.print("Enter a double value: ");
        double doubleValue = sc.nextDouble();
        sc.nextLine();  

        String currentDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        try (FileWriter writer = new FileWriter("output.txt", true)) {
            writer.write("Double Value: " + doubleValue + "\n");
            writer.write("Application Run Date: " + currentDate + "\n");
            System.out.println("Double value and date written to output.txt.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        System.out.print("Enter the name of the file or directory to delete: ");
        String fileNameToDelete = sc.nextLine();
        File fileToDelete = new File(fileNameToDelete);

        if (fileToDelete.exists()) {
            if (fileToDelete.isDirectory()) {

                if (fileToDelete.delete()) {
                    System.out.println("Directory deleted: " + fileToDelete.getName());
                } else {
                    System.out.println("Failed to delete directory: " + fileToDelete.getName());
                }
            } else {

                if (fileToDelete.delete()) {
                    System.out.println("File deleted: " + fileToDelete.getName());
                } else {
                    System.out.println("Failed to delete file: " + fileToDelete.getName());
                }
            }
        } else {
            System.out.println("The file or directory does not exist: " + fileToDelete.getName());
        }

        sc.close();
    }
}
