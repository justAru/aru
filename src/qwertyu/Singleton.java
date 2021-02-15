import java.io.*;
import static java.lang.System.*;
import java.util.*;

public class Singleton {
    private static Singleton singleton;
    File file1 = new File("lists.txt");
    FileWriter fw = new FileWriter(file1);
    PrintWriter pw = new PrintWriter(fw);
    Scanner scan = new Scanner(file1);


    public static synchronized Singleton getSingleton() throws IOException {
        if(singleton == null ){
            singleton = new Singleton();
        }
        return singleton;
    }
    private Singleton() throws IOException {

    }

    public void write(String name) {
        pw.println(name);
    }
    public void close(){
        pw.close();
    }

    public void read() throws IOException {
        while (scan.hasNextLine()){
            System.out.println(scan.nextLine());
        }
    }
}
