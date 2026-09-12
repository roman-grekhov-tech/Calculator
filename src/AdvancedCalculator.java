import java.util.Scanner;

public class AdvancedCalculator {
    double operand1;
    double operand2;
    String operation;
    double result;
    boolean hasFirstOperand;

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int inputCode = readInputs(scanner);
            if (inputCode == 1) {
                cancel();
                continue;
            }
            if (inputCode == 2) {
                break;
            }

           int calculationCode = makeCalculation();
           if (calculationCode == 1) {
                System.out.println("Делить на ноль нельзя");
                cancel();
                continue;
            }
           if (calculationCode == 2) {
               System.out.println("Неподдерживаемый опеатор.");
               System.out.println("Поддерживаемые операторы: +, -, *, /.");
               cancel();
               continue;
           }

            System.out.println(result);
            this.operand1 = result;
            this.hasFirstOperand = true;
        }
    }

    private int readInputs(Scanner scanner) {
        if (!hasFirstOperand) {
            while (true) {
                System.out.print("Число: ");
                String input1 = scanner.nextLine();
                int command1 = checkCommands(input1);
                if (command1 != 0) return command1;
                try {
                    operand1 =  Double.parseDouble(input1);
                    break;
                } catch (NumberFormatException e){
                    System.out.println("Ошибка! Нужно ввести число");
                }
            }

        }

        System.out.print("Операция: ");
        String input2 = scanner.nextLine();
        int command2 = checkCommands(input2);
        if (command2 != 0) return command2;
        operation = input2;

        while (true) {
            System.out.print("Число: ");
            String input3 = scanner.nextLine();
            int command3 = checkCommands(input3);
            if (command3 != 0) return command3;
            try {
                operand2 =  Double.parseDouble(input3);
                break;
            } catch (NumberFormatException e){
                System.out.println("Ошибка! Нужно ввести число");
            }
        }

        return 0;
    }

    private int makeCalculation() {
        switch (operation.toLowerCase()) {
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
                if (operand2 == 0) {
                    return 1;
                }
                result = operand1 / operand2;
                break;
            default:
                return 2;
        }

        return 0;
    }

    private void cancel() {
        this.operand1 = 0;
        this.operand2 = 0;
        this.operation = "";
        this.result = 0;
        this.hasFirstOperand = false;
    }

    private int checkCommands(String s) {
        if (s.equalsIgnoreCase("c")) return 1;
        if (s.equalsIgnoreCase("s")) return 2;
        return 0;
    }
}
