import lab1Singleton.Singleton;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        Singleton.getSingleton().write("Erasyl");
        Singleton.getSingleton().write("Erlik");
        Singleton.getSingleton().write("Akbilek");
        Singleton.getSingleton().close();
        Singleton.getSingleton().read();
        Singleton.getSingleton().read();
        Singleton.getSingleton().read();

//        while(true){
//            System.out.println("1. Write");
//            System.out.println("2. Read");
//            System.out.println("0. Exit");
//            int choice = in.nextInt();
//
//
//            switch (choice){
//                case 1:
//                        System.out.println("Enter name: ");
//                        String name = in.next();
//                        Singleton.getSingleton().write(name);
//                    break;
//                case 2:
//                        System.out.println("There are list of names: ");
//                        Singleton.getSingleton().read();
//                    break;
//                case 0:
//                    System.out.println("EXIT");
//                    return;
//                default:
//                    System.out.println("1. Incorrect choice! Please try again!");
//                    break;
//            }
//
//
//        }
    }
}
