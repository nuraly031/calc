import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner data = new Scanner(System.in);

        System.out.println("Введите арифметическое выражение (например, 2 + 3):");
        String input = data.nextLine();

        try {
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String calc(String input) {
        String[] tokens = input.split(" ");

        if (tokens.length != 3) {
            throw new IllegalArgumentException("Неверный формат ввода. //т.к. строка не является математической операцией Введите выражение в формате a + b.");
        }

        try {
            int operand1 = Integer.parseInt(tokens[0]);
            int operand2 = Integer.parseInt(tokens[2]);
            char operator = tokens[1].charAt(0);

            if (operand1 < 1 || operand1 > 10 || operand2 < 1 || operand2 > 10) {
                throw new IllegalArgumentException("Числа должны быть от 1 до 10 включительно.");
            }

            int result;
            switch (operator) {
                case '+':
                    result = operand1 + operand2;
                    break;
                case '-':
                    result = operand1 - operand2;
                    break;
                case '*':
                    result = operand1 * operand2;
                    break;
                case '/':
                    if (operand2 == 0) {
                        throw new IllegalArgumentException("Деление на ноль недопустимо.");
                    }
                    result = operand1 / operand2;
                    break;
                default:
                    throw new IllegalArgumentException("Недопустимая арифметическая операция: " + operator);
            }

            return String.valueOf(result);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Некорректные числа. Введите целые числа от 1 до 10 включительно.");
        }
    }
}
