import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double result;
        do {
            try {
                result = Double.parseDouble(prompt("Введите дробное число: "));
                break;
            }
            catch (NumberFormatException e){
            }
        } while (true);
        System.out.print(result);
    }
    public static  String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}