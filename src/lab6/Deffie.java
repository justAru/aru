package lab6;

import java.math.BigInteger;
import java.util.Scanner;

public class Deffie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter q: ");
        BigInteger q = new BigInteger(scanner.next());
        System.out.println("Enter a: ");
        BigInteger a = new BigInteger(scanner.next());
        scanner.nextLine();

        System.out.println("Enter XA: ");
        BigInteger xa = new BigInteger(scanner.next());
        System.out.println("Enter XB: ");
        BigInteger xb = new BigInteger(scanner.next());
        scanner.nextLine();

        BigInteger YA,YB,K1,K2;
        YA = a.modPow(xa, q);
        YB = a.modPow(xb, q);
        K1 = YA.modPow(xb, q);
        K2 = YB.modPow(xa, q);

        System.out.println("Key1 = " + K1);
        System.out.println("Key2 = " + K2);
    }
}
