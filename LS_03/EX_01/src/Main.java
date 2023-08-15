import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter user data");
            try {
                 User user = new User(scanner.nextLine());
                 if (user.getECode() != -1)
                     System.out.printf("Wrong number of user attribute. Expected %d. Input %d", 6, user.getECode());
                 else {
                     user.saveToFile();
                     break;
                 }
            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}