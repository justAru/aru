package DESAlgorithm;
import java.io.*;
import java.util.Scanner;
    class BF{
        //called function
        public static int bruteforce(String text,String tobematched){
            int length = text.length();//length of the text
            int plength = tobematched.length();//length of the pattern;
//loop condition
            for(int i=0;i<length-plength;i++){
//initialization of j
                int j=0;
                while((j < plength) && (text.charAt(i+j) == tobematched.charAt(j))){
                    j++;
                }
                if(j == plength){
                    return i;
                }
            }
            return -1;
        }
        public static void main(String[] args){
            BF obj = new BF();
            Scanner sc =  new Scanner(System.in);
//text
            String text = "8RT0pgkTC2yMlKZO+GwU+4QX99Ojjvf4RyIoeR4hNarbb6tp+BXv +wz+0ho7hsCvhiFDiu5ls+Cr8YBocwwDI/t1wEx+rs1lknQ8nSX6LcHtI RzlFIVzAcKgTHsAIfZfZCzTLWJCYsKG0O49RGH0tw==";
//word that want to be matched in the text
            String tobematched = "easily";
//calling the function
            int position = obj.bruteforce(text,tobematched);
            int endindex = position+1;
//condition to check whether the pattern is matched are not
            if(position == -1){
                System.out.println("Pattern is not matched in the text");
            }else{
                System.out.println("Found at position:" + (position+1));
                System.out.println("End at the position:" + (endindex + tobematched.length()));
            }
        }
    }
