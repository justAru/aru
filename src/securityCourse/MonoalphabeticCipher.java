package securityCourse;

import java.util.Scanner;

public class MonoalphabeticCipher {
    public static char alphabet[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
            'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ', ',', '.', '-', '@', '?', '!'};
    public static char key[] = {'M', 'N', 'B', 'V', 'C', 'X', 'Z', 'L', 'K', 'J', 'H', 'G', 'F', 'D', 'S', 'A',
            'P', 'O', 'I', 'U', 'Y', 'T', 'R', 'E', 'W', 'Q', ' ', ',', '.', '-', '@', '?', '!'};

    public static String encryption(String plainText){ // берем plainText и через цикл пробегаемся по тексту и из
        char pt[] = new char[(plainText.length())]; // текста находим соответствующую букву из alphabet
        for (int i = 0; i < plainText.length(); i++) { // после чего берем индексы и заменяем букву из alphabet буквой
            for (int j = 0; j < 32; j++) { // из key соотвeтствующего индекса
                if(plainText.charAt(i) == alphabet[j]){
                    pt[i] = key[j];
                    break;
                }
            }
        }
        return(new String(pt));
    }

    public static String decryption(String ciphertext){// decrypt работает по той же схеме но в обратную сторону
        char ct[] = new char[(ciphertext.length())];
        for (int i = 0; i < ciphertext.length(); i++) {
            for (int j = 0; j < 32; j++) {
                if(ciphertext.charAt(i) == key[j]){ //если char ciphertext-a равен ключу
                    ct[i] = alphabet[j];// происходит замена
                    break;
                }
            }
        }
        return(new String(ct));
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter plain text: ");
        String text = scanner.nextLine().toLowerCase();
        String eText = encryption(text.toLowerCase()); // toLowerCase используем так как в алфавите нет заглавных букв
        System.out.println("Encrypted text: " + eText); // и из за этого происходит ошибка при замене
        System.out.println("Decrypted text: " + decryption(eText));
    }
}
