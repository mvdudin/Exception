import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            int a = 90;
            int b = 0;
            System.out.println(a / b);
        } catch (ArithmeticException ex) {
            System.out.println("Деление на ноль!");
        }
        try {
            printSum(23, 234);
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        }
        try {
            int[] abc = {1, 2};
            abc[3] = 9;
        }
        catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        }
        catch (NullPointerException ex) {
        System.out.println("Указатель не может указывать на null!");
        }
    }
    public static void printSum(Integer a, Integer b) throws NullPointerException {
        System.out.println(a + b);
    }
}