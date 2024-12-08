import java.util.GregorianCalendar;
import java.util.Scanner;

public class GregorianCalendarExample {
    public static void main(String[] args) {
        // Create a GregorianCalendar object for the current date and time
        GregorianCalendar calendar = new GregorianCalendar();

        // Display current date and time in default locale and time zone
        System.out.println("Current Date and Time: " + calendar.getTime());

        // Get the current year
        int currentYear = calendar.get(GregorianCalendar.YEAR);

        // Check if the current year is a leap year
        boolean isLeapYear = calendar.isLeapYear(currentYear);
        
        // Display whether the current year is a leap year
        if (isLeapYear) {
            System.out.println(currentYear + " is a leap year.");
        } else {
            System.out.println(currentYear + " is not a leap year.");
        }
    }
}
