package calculator;

import java.util.HashMap;

public class Validation {

    public static boolean isNumbers(String[] numbers) {

        try {
            Integer.parseInt(numbers[0].trim());
            Integer.parseInt(numbers[1].trim());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isValidNumbers(int num1, int num2) {

        return (num1 <= 10 && num1 >= 1 && num2 <= 10 && num2 >= 1);
    }

    public static boolean isRomeNumbers(String[] numbers) {
        if (numbers[0] == null || numbers[1] == null) {
            return false;
        }

        HashMap romeNumbers = Helper.getRomeNumbers();
        String string1 = numbers[0].trim().toUpperCase();
        String string2 = numbers[1].trim().toUpperCase();

        return (romeNumbers.containsKey(string1) && romeNumbers.containsKey(string2));
    }

    public static boolean isValidOperator(String operator) {
        switch (operator) {
            case "+":
            case "-":
            case "*":
            case "/":
                return true;
            default:
                return false;
        }
    }

    public static boolean isValidOperatorAndNumbers(int[] arrayInt, String operator) {
        return (isValidNumbers(arrayInt[0], arrayInt[1]) && isValidOperator(operator));
    }
}
