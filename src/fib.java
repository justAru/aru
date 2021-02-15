//import java.util.Scanner;
//
//public class fib {
//    static int[] dictionary;
//
//    static int fibonacci(int num) {
//        int count;
//        if (num == 0) {
//            return dictionary[0];
//        } else {
//            int f = dictionary[num];
//            if( f == 0 ){
//                f = fibonacci(num -1) + fibonacci(num-2);
//                dictionary[num] = f;
//            }
//            return f;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int num = scanner.nextInt();
//        dictionary = new int[num];
//        int answer = fibonacci(num);
//        System.out.println(answer);
//    }
//}
//
//
