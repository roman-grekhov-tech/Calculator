import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();

            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    BasicCalculator basicCalculator = new BasicCalculator();
                    basicCalculator.start();
                    return;
                case "2":
                    AdvancedCalculator advancedCalculator = new AdvancedCalculator();
                    advancedCalculator.start();
                    return;
                case "0":
                    return;
                default:
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println();
        System.out.println("1. Базовый калькулятор");
        System.out.println("2. Калькулятор со звездочкой");
        System.out.println("------------------------------");
        System.out.println("0. Выход");
        System.out.println();
        System.out.print("Выберите вариант (0-2): ");
    }
}
