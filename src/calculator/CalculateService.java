package calculator;

import java.text.DecimalFormat;

public class CalculateService {

    public String calculation(String str) {

        String[] arrayStrings = Helper.getStringsArray(str);
        String operator = Helper.getOperator(str);

        if (Validation.isNumbers(arrayStrings)) {
            int[] arrayInt = Helper.getArrayInt(arrayStrings);

            if (Validation.isValidOperatorAndNumbers(arrayInt, operator)) {
                double number = Calculation.makeCalculate(arrayInt, operator);

                if (number % 1 == 0) {
                    int num = (int) number;
                    return Integer.toString(num);
                } else {
                    DecimalFormat df = new DecimalFormat("####0.00");
                    return df.format(number);
                }
            }
        }

        if (Validation.isRomeNumbers(arrayStrings)) {
            int[] arrInt = Helper.getRomeArrayInt(arrayStrings);

            if (Validation.isValidOperatorAndNumbers(arrInt, operator)) {
                double number = Calculation.makeCalculate(arrInt, operator);

                if (number % 1 == 0) {
                    return Helper.convertToRomeNumber((int) number);
                } else {
                    DecimalFormat df = new DecimalFormat("####0.00");
                    return Helper.convertToRomeNumber(Double.parseDouble(df.format(number)));
                }
            }
        }

        return "Вводите корректные данные";
    }
}
