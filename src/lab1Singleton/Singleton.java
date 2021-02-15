package lab1Singleton;
import java.io.*;

class Singleton {
    private static Singleton instance;
    public String a;

    private Singleton(String a){

    }

    public static Singleton getInstance(String a){
        if(instance == null){
            instance = new Singleton(a);
        }
        return instance;
    }
}

class Main {
    public static void main(String args[]) throws IOException {

        Singleton first = Singleton.getInstance("Aru");
        Singleton second = Singleton.getInstance("Erasyl");
        Singleton third = Singleton.getInstance("Nargiza");
        Singleton forth = Singleton.getInstance("Adilet");
        Singleton fifth = Singleton.getInstance("Madiyar");

        String fileName = "temp.txt";

        try {
            FileWriter fileWriter =
                    new FileWriter(fileName);

            BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);

            bufferedWriter.write("My name is "+ first + "\n");
            bufferedWriter.write("My name is "+ second + "\n" );
            bufferedWriter.write("My name is "+ third + "\n");
            bufferedWriter.write("My name is "+ forth + "\n");
            bufferedWriter.write("My name is "+ fifth + "\n");

            bufferedWriter.newLine();
            bufferedWriter.write("We are writing");
            bufferedWriter.write(" the text to the file.");

            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                    "Error writing to file '"
                            + fileName + "'");
        }

        String fileNameRead = "temp.txt";

        String line = null;

        try {
            FileReader fileReader =
                    new FileReader(fileNameRead);

            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }
    }
}
