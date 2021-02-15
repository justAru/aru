package lab6;
import java.io.*;
import java.math.*;
import java.security.SecureRandom;
//import java.util.*;

public class ElGhamal {
    BigInteger p;  //primeNumber
    BigInteger g;
    BigInteger k;  //privateKey
    BigInteger y;
    BigInteger M;
    BigInteger r;
    BigInteger a;
    BigInteger S;
    private SecureRandom random = null;

    public ElGhamal() throws IOException{
        FileReader();
    }

    public void FileReader() throws IOException
    {
        File file = new File("/Users/aru/Desktop/prkey.txt");
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        String str = fileReader.readLine();
        str = str.substring(2);
        k = new BigInteger(str);
        String str1 = fileReader.readLine();
        str1 = str1.substring(2);
        p = new BigInteger(str1);
        String str2 = fileReader.readLine();
        str2 = str2.substring(2);
        g = new BigInteger(str2);
        String str3 = fileReader.readLine();
        str3 = str3.substring(2);
        y = new BigInteger(str3);
        //System.out.println("" + k);   

    }
    public void encryption(String md) {
        byte [] tobyte = md.getBytes();
        BigInteger M = new BigInteger(tobyte);
        while(true)
        {
            random = new SecureRandom();
            r = new BigInteger(15, random);
            if(p.subtract(BigInteger.ONE).gcd(r).equals(BigInteger.ONE)&&r.compareTo(p) == -1)
            {
                break;
            }
        }
        a = g.modPow(r, p);
        BigInteger temp1,temp2;
        temp1 = M.subtract(a.multiply(k)).mod(p.subtract(BigInteger.ONE));
        temp2 = r.modInverse(p.subtract(BigInteger.ONE));
        S = temp1.multiply(temp2).mod(p.subtract(BigInteger.ONE));
    }


    public static void main(String[] args) throws IOException
    {
        ElGhamal get = new ElGhamal();
        get.FileReader();
        get.M = new BigInteger("456");
        get.encryption("40");

        System.out.println("p");
        System.out.println(get.p.toString());
        System.out.println("g");
        System.out.println(get.g.toString());
        System.out.println("k");
        System.out.println(get.k.toString());
        System.out.println("r");
        System.out.println(get.r.toString());
        System.out.println("S");
        System.out.println(get.S.toString());
        System.out.println("a");
        System.out.println(get.a.toString());
        System.out.println("y");
        System.out.println(get.y.toString());
    }

}   