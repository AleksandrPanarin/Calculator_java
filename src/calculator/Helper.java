package calculator;

import java.util.HashMap;

public class Helper {

    public static String[] getStringsArray(String str) {
        if (str.split("\\+").length == 2) {
            String strings[] = str.split("\\+");
            return strings;
        }
        if (str.split("-").length == 2) {
            String strings[] = str.split("-");
            return strings;
        }
        if (str.split("\\*").length == 2) {
            String strings[] = str.split("\\*");
            return strings;
        }
        if (str.split("/").length == 2) {
            String strings[] = str.split("/");
            return strings;
        }
        String strings[] = {null, null};
        return strings;
    }

    public static String getOperator(String str) {
        if (str.split("\\+").length == 2) {
            return "+";
        }
        if (str.split("-").length == 2) {
            return "-";
        }
        if (str.split("\\*").length == 2) {
            return "*";
        }
        if (str.split("/").length == 2) {
            return "/";
        }
        return "null";
    }

    public static int[] getArrayInt(String[] numbers) {
        int[] array = {Integer.parseInt(numbers[0].trim()), Integer.parseInt(numbers[1].trim())};
        return array;
    }

    public static int[] getRomeArrayInt(String[] numbers) {
        HashMap romeNumbers = getRomeNumbers();
        int[] array = {(int) romeNumbers.get(numbers[0].trim().toUpperCase()), (int) (romeNumbers.get(numbers[1].trim().toUpperCase()))};
        return array;
    }

    public static HashMap getRomeNumbers() {
        HashMap<String, Integer> romNumbers = new HashMap<String, Integer>();
        romNumbers.put("0", 0);
        romNumbers.put("I", 1);
        romNumbers.put("II", 2);
        romNumbers.put("III", 3);
        romNumbers.put("IV", 4);
        romNumbers.put("V", 5);
        romNumbers.put("VI", 6);
        romNumbers.put("VII", 7);
        romNumbers.put("VIII", 8);
        romNumbers.put("IX", 9);
        romNumbers.put("X", 10);
        romNumbers.put("XX", 20);
        romNumbers.put("XXX", 30);
        romNumbers.put("XL", 40);
        romNumbers.put("L", 50);
        romNumbers.put("LX", 60);
        romNumbers.put("LXX", 70);
        romNumbers.put("LXXX", 80);
        romNumbers.put("XC", 90);
        romNumbers.put("C", 100);
        return romNumbers;
    }

    public static HashMap getReverseRomeNumbers() {

        HashMap<Integer, String> romeNumbers = new HashMap<>();
        HashMap<String, Integer> romeNumArray = getRomeNumbers();

        for (HashMap.Entry<String, Integer> entry : romeNumArray.entrySet()) {
            romeNumbers.put(entry.getValue(), entry.getKey());
        }
        return romeNumbers;
    }

    public static String convertToRomeNumber(int num) {
        HashMap romeNumbers = getReverseRomeNumbers();
        String mines = (num < 0) ? "-" : "";

        if (num == 100) {
            return (String) mines + romeNumbers.get(Math.abs(num));
        }
        if (num <= 10) {
            return (String) mines + romeNumbers.get(Math.abs(num));
        } else {
            String str = Integer.toString(num);
            String[] arrOfStr = str.split("");
            return convertArrayToString(arrOfStr);
        }
    }

    public static String convertToRomeNumber(double num) {
        String str = Double.toString(num);
        String[] arrStringAll = str.split("\\.");
        String[] intArray = arrStringAll[0].split("");
        String[] floatArray = arrStringAll[1].split("");

        String intString = convertArrayToString(intArray);
        String floatString = convertArrayToString(floatArray);

        return intString + "." + floatString;
    }

    public static String convertArrayToString(String[] array) {
        StringBuilder builder = new StringBuilder();
        HashMap romeNumbers = getReverseRomeNumbers();

        for (int i = 0; i < array.length; i++) {
            if (i == 0 && array.length > 1) {
                builder.append((String) romeNumbers.get(Integer.parseInt(array[i] + "0")));
            } else {
                builder.append((String) romeNumbers.get(Integer.parseInt(array[i])));
            }
        }
        return builder.toString();
    }
}
