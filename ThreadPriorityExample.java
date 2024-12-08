import java.util.Scanner;

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {

        System.out.println("Thread Name: " + getName());
        System.out.println("Thread Priority: " + getPriority());
    }
}

public class ThreadPriorityExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of threads: ");
        int numThreads = sc.nextInt();
        sc.nextLine(); 

        MyThread[] threads = new MyThread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            System.out.print("Enter name for thread " + (i + 1) + ": ");
            String name = sc.nextLine();

            int priority = 0;
            while (true) {
                System.out.print("Enter priority for thread " + (i + 1) + " (1-10): ");
                priority = sc.nextInt();
                sc.nextLine(); 
                if (priority >= 1 && priority <= 10) {
                    break; 
                } else {
                    System.out.println("Invalid priority! Please enter a value between 1 and 10.");
                }
            }

            threads[i] = new MyThread(name);
            
            threads[i].setPriority(priority);

            threads[i].start();
        }

        try {
            for (int i = 0; i < numThreads; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }

        sc.close();  
    }
}
