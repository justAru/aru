import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void findLogin(String username){
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader("users.txt"));
            String str;
            while((str = br.readLine()) != null){
                String [] arr = str.split(" ");
                if(arr[0].equals(username)){
                    System.out.println("There is such a user");
                }
            }
            System.out.println("Login is available for user");
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        finally {
            try {
                br.close();
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static void saveUser(String username, String password){
        File file = null;
        try{
            file = new File("users.txt");
            if(file.createNewFile())
                System.out.println("File has been created" );
            PrintWriter pw = new PrintWriter(new FileWriter("users.txt", true));
            String str = username + " " + password;
            pw.println(str);
            pw.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> lists = new HashMap<String, String>();
        String username, password;

        while(true) {
            System.out.println("\n//////////////////////////");
            System.out.println("//<------1.Log in------>//");
            System.out.println("//<------2.Sign up----->//");
            System.out.println("//<------0.Exit-------->//");
            System.out.println("//////////////////////////");
            System.out.println("\nChoose: ");
            int userChoice = scanner.nextInt();
            scanner.nextLine();
            if (userChoice == 0)
                break;
            switch(userChoice){
                case 1:
                    System.out.println("<----Log in---->");
                    System.out.println("Enter username: ");
                    username = scanner.nextLine();
                    System.out.println("Enter password: ");
                    password = scanner.nextLine();
                    findLogin(username);
                    if(lists.containsKey(username) && password.equals(lists.get(password))){
                        System.out.println("Good job!");
                        break;
                    } else {
                        System.out.println("Wrong data! Please check it!");
                    }
                    break;
                case 2:
                    System.out.println("<----Sign up---->");
                    System.out.println("Enter username: ");
                    username = scanner.nextLine();
                    System.out.println("Enter password: ");
                    password = scanner.nextLine();
                    while(true){
                        if(lists.containsKey(username)== false){
                            System.out.println("Enter password again: ");
                            password = scanner.nextLine();
                            lists.put(username, password);
                            saveUser(username, password);
                            System.out.println("New user added successfully!");
                            break;
                        } else if(lists.containsKey(username) == true){
                            System.out.println("This user exist in my system! Please try again.");
                            username = scanner.nextLine();
                        } else {
                            System.out.println(lists.entrySet());
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("Please choice from 0-2!");
            }
            System.out.println("\nGood-bye!");
        }

    }
}