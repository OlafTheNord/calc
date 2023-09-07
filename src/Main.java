import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalStateException{
        System.out.println(calc());
    }
    public static String calc (){
        String result;
        char arifSym;
        int number1;
        int number2;
        int result1;

        // Получаем выражение
        Scanner exInput = new Scanner(System.in);
        System.out.println("Input expression: ");
        String expression = exInput.nextLine();

        // Разбиваем на элементы по пробелу
        String [] elements = expression.split(" ");

        // Преобразуем текст в операнд
        arifSym = strToChar(elements[1]);

        // Преобразуем римские в арабские
        number1 = romToNumber(elements[0]);
        number2 = romToNumber(elements[2]);
        if (number1 > 0 && number2 > 0){
            result1 = calculate(number1, number2, arifSym);
            String romeRes = numToRome(result1);
            result = "Result = " + romeRes;
        } else {
            number1 = araToNum(elements[0]);
            number2 = araToNum(elements[2]);
            result1 = calculate(number1, number2, arifSym);
            result = "Result = " + result1;
        }

        return result;
    }
    static int romToNumber(String roman){
        // Конвертер в римские цифры
        switch (roman){
            case "I" -> {
                return 1;
            }
            case "II" -> {
                return 2;
            }
            case "III" -> {
                return 3;
            }
            case "IV" -> {
                return 4;
            }
            case "V" -> {
                return 5;
            }
            case "VI" -> {
                return 6;
            }
            case "VII" -> {
                return 7;
            }
            case "VIII" -> {
                return 8;
            }
            case "IX" -> {
                return 9;
            }
            case "X" -> {
                return 10;
            }
            default -> {
                return -1;
            }
        }
    }
    static int araToNum(String arabic){
        // Число в строку
        int number;
        number = Integer.parseInt(arabic);
        if (number < 1 || number > 10){
            throw new IllegalStateException("Ошибка ввода данных");
        }
        return number;
    }
    static int calculate(int num1, int num2, char exp){
        // Калькулятор
        int result = 0;
        switch (exp){
            case '+' -> {
                result = num1 + num2;
            }
            case '-' -> {
                result = num1 - num2;
            }
            case '*' -> {
                result = num1 * num2;
            }
            case '/' -> {
                try {
                    result = num1 / num2;
                } catch (Exception e) {
                    throw new RuntimeException("Ошибка ввода данных");
                }
            }
        }
        return result;
    }
    static String numToRome(int num){
        String res;
        String [] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        try {
            res = roman[num - 1];
        } catch (Exception e) {
            throw new RuntimeException("Ошибка ввода данных");
        }
        return res;
    }
    static char strToChar(String charset){
        // Проверяем что за действие
        char arif;
        switch (charset) {
            case "+" -> arif = '+';
            case "-" -> arif = '-';
            case "*" -> arif = '*';
            case "/" -> arif = '/';
            default -> throw new IllegalStateException("Ошибка ввода данных");
        }
        return arif;
    }
}

// внес корректировки после отправки из-за проверки на ошибки повторно