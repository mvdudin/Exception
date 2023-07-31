import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            String result = prompt("Введите строку: ");
            System.out.print(result);
        }
        catch (Exception e){
            System.out.print(e);
        }
    }
    public static  String prompt(String message) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        String result = in.nextLine();
        if ( result.isEmpty() )
            throw new Exception("Пустая строка");
        else
          return result;
    }
}