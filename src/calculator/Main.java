package calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            while (true) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter a task");
                String str = scanner.nextLine();
                if (str.equals("exit")) {
                    break;
                }
                CalculateService calculation = new CalculateService();
                String result = calculation.calculation(str);
                System.out.println(result);

                if (result.equals("Вводите корректные данные")) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Произошла системная ошибка");
        }
    }
}
