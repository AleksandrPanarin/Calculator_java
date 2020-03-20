package calculator;

public class Calculation {

    public static int sum(int num1, int num2) {
        return num1 + num2;
    }

    public static int subtraction(int num1, int num2) {
        return num1 - num2;
    }

    public static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public static double divide(int num1, int num2) {
        return (double) num1 / (double) num2;
    }

    public static double makeCalculate(int[] arrayInt, String operator) {
        switch (operator) {
            case "+":
                return Calculation.sum(arrayInt[0], arrayInt[1]);
            case "-":
                return Calculation.subtraction(arrayInt[0], arrayInt[1]);
            case "*":
                return Calculation.multiply(arrayInt[0], arrayInt[1]);
            default:
                return Calculation.divide(arrayInt[0], arrayInt[1]);
        }
    }
}
