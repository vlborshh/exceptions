import java.util.Scanner;

public class dz2_1 {
    public static void main(String[] args) {

        System.out.println("Вы ввели число - " + inputFloat());

    }

    private static float inputFloat() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Ввод числа тип float: ");
                String input = scanner.nextLine();
                return Float.parseFloat(input);
            } catch (NumberFormatException e) {
                System.out.println("Введены некорректные данные");
            }
        }
    }
}
