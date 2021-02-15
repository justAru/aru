package lab3;

import java.util.Scanner;


public class mainClass {

    public static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        else
            return GCD(b, a%b);
    }

    public static int inverse(int p, int m){
            p = p % m;
            for (int x = 1; x < m; x++)
                if ((p * x) % m == 1)
                    return x;
            return 1;
    }

    public static void task3(int a, int b, String str){
        if (str.equals("mod")) {
            while (a < 0) {
                a += b;
            }
            System.out.println(a + "mod" + b);
        }else {
            System.out.println("Error");
        }
    }




    public static void printMenu() {
        System.out.println("\n<-------------- Menu --------------->");
        System.out.println("|    <1> GCD                         |");
        System.out.println("|    <2> Inverse                     |");
        System.out.println("|    <3> task3                       |");
        System.out.println("|    <0> Exit                        |");
        System.out.println("<------------------------------------->");
    }

    public static void processUserChoice(int userChoice) {
        switch (userChoice) {
            case 1:
                Scanner scanner = new Scanner(System.in);
                System.out.println("Inter a for GCD: ");
                int a = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter b: ");
                int b = scanner.nextInt();
                System.out.println(GCD(a, b));
                break;
            case 2:
                Scanner in = new Scanner(System.in);
                System.out.println("Inter p for inverse: ");
                int p = in.nextInt();
                in.nextLine();
                System.out.println("Enter b: ");
                int m = in.nextInt();
                System.out.println(inverse(p, m));
                break;
            case 3:
                Scanner scan = new Scanner(System.in);
                System.out.println("Inter variables in format: -18 mod 5(Example) ");
                String string = scan.nextLine();
                String [] str2;
                str2 = string.split(" ");
                int ar = Integer.parseInt(str2[0]);
                int br = Integer.parseInt(str2[2]);
                String str = str2[1];
                task3(ar, br, str);
                break;
            default:
                System.out.println("\nChoose from 0 - 3!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        while (true) {
            System.out.print("\nChoose the point from main menu: ");
            int userChoice = scanner.nextInt();
            scanner.nextLine();
            if (userChoice == 0)
                break;
            processUserChoice(userChoice);
        }
        System.out.println("\nGood-bye!");
    }
}
