import java.util.Scanner;

public class BasicCalculator {
    public void start() {
        double operand1;
        double operand2;
        String operation;
        double result;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Первое число: ");
        operand1 = Double.parseDouble(scanner.nextLine());

        System.out.print("Знак: ");
        operation = scanner.nextLine();

        System.out.print("Второе число: ");
        operand2 = Double.parseDouble(scanner.nextLine());

        switch (operation) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                result = operand1 / operand2;
                break;
            default:
                System.out.println("Неподдерживаемый опеатор.");
                System.out.println("Поддерживаемые операторы: +, -, *, /.");
                return;
        }

        System.out.println(result);
    }
}
