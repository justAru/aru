package securityCourse;

import javax.swing.*;
import java.util.Scanner;

public class RailFenceCipher {
    public static String encryption(String plainText, int key) {
        String encryptedText = "";
        boolean check = false; //чтобы проверять достигли ли мы конца обозначенным ключом
        int j = 0;
        int row = key;
        int column = plainText.length();
        char[][] matrix = new char[row][column];

        for (int i = 0; i < column; i++) { // проверяем в каком ряду находится буква
            if (j == 0 || j == key - 1)
                check = !check;

            matrix[j][i] = plainText.charAt(i); // добавляем char из plainText в matrix

            if (check)
                j++;
            else
                j--;
        }
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < column; k++) {
                if (matrix[i][k] != 0) // проверяем на ноль, после собираем по буквам
                    encryptedText += matrix[i][k];
            }
        }

        for (int i = 0; i < row; i++) {   // для проверки как выводит в массиве
            for (int k = 0; k < column; k++) {
                System.out.print(matrix[i][k] + " ");
            }
            System.out.println();
        }
        return encryptedText;
    }


    public static String decryption(String cipherText, int key) {
        String decryptedText = "";
        boolean check = false; //чтобы проверять достигли ли мы конца обозначенным ключом
        int j = 0;
        int row = key;
        int column = cipherText.length();
        char[][] matrix = new char[row][column];

        for (int i = 0; i < column; i++) { // проверяем в каком ряду находится буква
            if (j == 0 || j == key - 1)
                check = !check;

            matrix[j][i] = '*'; //заменяем буквы звездочками
            if (check)
                j++;
            else
                j--;
        }

        int index = 0;
        check = false;
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < column; k++) {
                if (matrix[i][k] == '*' && index < column) { //заменяем местоположения звездочек буквами из cipherText
                    matrix[i][k] = cipherText.charAt(index++);
                }
            }
        }
            j = 0;
            for (int i = 0; i < column; i++) {
                if (j == 0 || j == key - 1)
                    check = !check;

                decryptedText += matrix[j][i]; // собираем текст

                if (check)
                    j++;
                else
                    j--;
            }
        return decryptedText;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter plain text: ");
        String plainText = scanner.nextLine().toLowerCase();
        System.out.println("Enter the key: ");
        int key = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Encrypted text: " + encryption(plainText, key));
        String en = encryption(plainText, key);
        System.out.println("Decrypted text: " + decryption(en, key));
    }
}

