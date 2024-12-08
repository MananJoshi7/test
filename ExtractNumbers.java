import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        

        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        

        String regex = "-?\\d+(\\.\\d+)?";  
        
        Pattern pattern = Pattern.compile(regex);
        
        Matcher matcher = pattern.matcher(input);
        
        System.out.println("Numbers found in the string:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }

        sc.close(); 
    }
}
