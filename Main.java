import java.util.Scanner;


class SuperClass {

    protected int x;

    public void setX(int value) {
        x = value;
    }

    public void show() {
        System.out.println("Value of x in SuperClass: " + x);
    }
}

// Subclass
class SubClass extends SuperClass {

    private int x;

    public void setX(int value) {
        this.x = value; 
    }

    @Override
    public void show() {
        super.show(); 
        System.out.println("Value of x in SubClass: " + this.x); 
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        SuperClass superClass = new SuperClass();
        SubClass subClass = new SubClass();
        
        System.out.print("Enter value of x for SuperClass: ");
        int superClassX = sc.nextInt();
        superClass.setX(superClassX);

        System.out.print("Enter value of x for SubClass: ");
        int subClassX = sc.nextInt();
        subClass.setX(subClassX);

        System.out.println("\nDisplaying values of x:");
        superClass.show();  
        subClass.show();    

        sc.close();
    }
}
