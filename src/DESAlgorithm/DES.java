package DESAlgorithm;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;

import static javax.crypto.SecretKeyFactory.*;

public class DES {
    public static void encryptDecrypt(String key, int cipherMode, File in, File out)
            throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException,
            IOException {

        FileInputStream fis = new FileInputStream(in);
        FileOutputStream fos = new FileOutputStream(out); //write bytes to a file

        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes()); //identify key, convert key to a bytes

        SecretKeyFactory skf = SecretKeyFactory.getInstance("DES"); //to convert keys
        SecretKey secretKey = skf.generateSecret(desKeySpec);

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");//typeOfAlgorithm/AdvancedAlgorithmStandard
        //check for what we use this method(encrypt/decrypt)
        if (cipherMode == Cipher.ENCRYPT_MODE) {
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, SecureRandom.getInstance("SHA1PRNG")); //SHA1 hash algorithm,
            // PRNG pseudo random number generator *source of randomness - SecureRandom.getInstance("SHA1PRNG")
            CipherInputStream cis = new CipherInputStream(fis, cipher);
            write(cis, fos);
        } else if (cipherMode == Cipher.DECRYPT_MODE) {
            cipher.init(Cipher.DECRYPT_MODE, secretKey, SecureRandom.getInstance("SHA1PRNG")); //SHA1 hash algorithm,
            // PRNG pseudo random number generator *source of randomness - SecureRandom.getInstance("SHA1PRNG")
            CipherOutputStream cos = new CipherOutputStream(fos, cipher);
            write(fis, cos);
        }
    }

    private static void write(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[64]; //create buffer
        int numOfBytesRead; // to store the bytes
        while ((numOfBytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, numOfBytesRead);
        }
        out.close();
        in.close();
    }

    public static void main(String[] args) {
        File plainText = new File("/Users/aru/Desktop/plain.txt");
        File encrypted = new File("/Users/aru/Desktop/encrypt.txt");
        //File decrypted = new File("/Users/aru/Desktop/decrypted.txt");
        try {
            encryptDecrypt("29", Cipher.ENCRYPT_MODE, plainText, encrypted);
            System.out.println("Encryption complete");
//            encryptDecrypt("12345678", Cipher.DECRYPT_MODE, encrypted, decrypted);
//            System.out.println("Decryption complete");
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

