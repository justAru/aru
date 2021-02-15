
import javax.crypto.Cipher;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.*;
import java.util.Base64;
import java.util.Scanner;

import static java.nio.charset.StandardCharsets.UTF_8;

public class DSA{
        public static KeyPair generateKeys() throws Exception {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(2048, new SecureRandom());
            KeyPair pair = generator.generateKeyPair();

            return pair;
        }

        public static KeyPair getKeyPairFromKeyStore() throws Exception {
            //Generated with:

            InputStream ins = DSA.class.getResourceAsStream("/keystore.jks");

            KeyStore keyStore = KeyStore.getInstance("JCEKS");
            keyStore.load(ins, "s2cret0".toCharArray());
            KeyStore.PasswordProtection keyPassword = new KeyStore.PasswordProtection("s2cret0".toCharArray()); //keyPassword

            KeyStore.PrivateKeyEntry privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry("myk", keyPassword);

            java.security.cert.Certificate cert = keyStore.getCertificate("myk");
            PublicKey publicKey = cert.getPublicKey();
            PrivateKey privateKey = privateKeyEntry.getPrivateKey();

            return new KeyPair(publicKey, privateKey);
        }

    public static String Hashing(String input, String algorithm) {
        try {
            MessageDigest msgDigest = MessageDigest.getInstance(algorithm);

            byte[] inputDigest = msgDigest.digest(input.getBytes());

            BigInteger inputDigestBigInt = new BigInteger(1, inputDigest);

            String hashtext = inputDigestBigInt.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        // Catch block to handle the scenarios when an unsupported message digest algorithm is provided.
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

        public static String encrypt(String plainText, PublicKey publicKey) throws Exception {
            Cipher encryptCipher = Cipher.getInstance("RSA");
            encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);

            byte[] cipherText = encryptCipher.doFinal(plainText.getBytes(UTF_8));

            return Base64.getEncoder().encodeToString(cipherText);
        }

        public static String decrypt(String cipherText, PrivateKey privateKey) throws Exception {
            byte[] bytes = Base64.getDecoder().decode(cipherText);

            Cipher decriptCipher = Cipher.getInstance("RSA");
            decriptCipher.init(Cipher.DECRYPT_MODE, privateKey);

            return new String(decriptCipher.doFinal(bytes), UTF_8);
        }

        public static String sign(String plainText, PrivateKey privateKey) throws Exception {
            Signature privateSignature = Signature.getInstance("SHA256withRSA");
            privateSignature.initSign(privateKey);
            privateSignature.update(plainText.getBytes(UTF_8));

            byte[] signature = privateSignature.sign();

            return Base64.getEncoder().encodeToString(signature);
        }

        public static boolean verify(String plainText, String signature, PublicKey publicKey) throws Exception {
            Signature publicSignature = Signature.getInstance("SHA256withRSA");
            publicSignature.initVerify(publicKey);
            publicSignature.update(plainText.getBytes(UTF_8));

            byte[] signatureBytes = Base64.getDecoder().decode(signature);

            return publicSignature.verify(signatureBytes);
        }

        public static void main(String... argv) throws Exception,NoSuchAlgorithmException {
            KeyPair pair = generateKeys();


            System.out.println("Enter message: ");
            Scanner scanner = new Scanner(System.in);
            String msg = scanner.next();
            System.out.println("Hash" + Hashing(msg, "MD5"));
            String message = Hashing(msg, "MD5");
            String cipherText = encrypt(message, pair.getPublic());
            System.out.println("Encrypted message:" + cipherText);
            String decipheredMessage = decrypt(cipherText, pair.getPrivate());
            System.out.println("Decrypted message:" + decipheredMessage);

            if (decipheredMessage.equals(message)){
                System.out.println("Hashes are equal!");
            } else {
                System.out.println("Error!");
            }

            String signature = sign("Dastan Kuatbek", pair.getPrivate());//sign message

            //Let's check the signature
            boolean isCorrect = verify("Dastan Kuatbek", signature, pair.getPublic());
            System.out.println("Verify signature: " + isCorrect);
        }
    }

