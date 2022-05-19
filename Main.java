import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = new Scanner(System.in).nextLine();
        String[] operation = str.split(" ");
        System.out.println(operation);
        if (operation.length!=3){
            throw new IllegalStateException("ошибка кол-во символов");
        }
        boolean firstNumber = toRoman(operation[0]);
        boolean secondNumber= toRoman(operation[2]);
        int a = 0;
        int b = 0;
        boolean convertToRoman = false;
        if (firstNumber && secondNumber){
            a = Integer.parseInt(operation[0]);
            b = Integer.parseInt(operation[2]);
        } else {
             convertToRoman = true;
            a = toArabic(operation[0]);
            b = toArabic(operation[2]);
        }

        if(secondNumber){
            b = Integer.parseInt(operation[2]);
        }else {
            b = toArabic(operation[2]);
        }
        if (a < 0 && a > 10 || b < 0 && b > 10) {
            throw new IllegalStateException("не правильно введены данные");}
        String oper = operation[1];
        int c = calculate(a, b, oper);
        if (convertToRoman){
            String romanNumeral = IntegerToRomanNumeral(c);
            System.out.println(romanNumeral);
        } else {
            System.out.println(c);
        }
    }
    public static int calculate(int a, int b, String operation) {

        switch (operation) {
            case "+":
                return a + b;

            case "-":
                return a - b;

            case "*":
                return a * b;

            case "/":
                return a / b;

            default:
                System.out.println("неверная операция");
                throw new IllegalStateException();
        }
    }
public static boolean toRoman(String number) {
    try {
        Integer.parseInt(number);
        return true;
    } catch (NumberFormatException number2) {
        return false;

    }
}
public static int toArabic(String arabicNumber){
        switch (arabicNumber){
            case "X":
                return 10;
            case"IX":
                return 9;
            case "VIII":
                return 8;
            case"VII":
                return 7;
            case "VI":
                return 6;
            case "V":
                return 5;
            case "IV":
                return 4;
            case "III":
                return 3;
            case"II":
                return 2;
            case "I":
                return 1;
            default:
                System.out.println();
                throw new IllegalStateException("неверный символ");

        }
}
    public static String IntegerToRomanNumeral(int input) {
        if (input < 1 || input > 3999)
            return "неверная цифра";
        String s = "";
        while (input >= 1000) {
            s += "M";
            input -= 1000;        }
        while (input >= 900) {
            s += "CM";
            input -= 900;
        }
        while (input >= 500) {
            s += "D";
            input -= 500;
        }
        while (input >= 400) {
            s += "CD";
            input -= 400;
        }
        while (input >= 100) {
            s += "C";
            input -= 100;
        }
        while (input >= 90) {
            s += "XC";
            input -= 90;
        }
        while (input >= 50) {
            s += "L";
            input -= 50;
        }
        while (input >= 40) {
            s += "XL";
            input -= 40;
        }
        while (input >= 10) {
            s += "X";
            input -= 10;
        }
        while (input >= 9) {
            s += "IX";
            input -= 9;
        }
        while (input >= 5) {
            s += "V";
            input -= 5;
        }
        while (input >= 4) {
            s += "IV";
            input -= 4;
        }
        while (input >= 1) {
            s += "I";
            input -= 1;
        }
        return s;

    }

}


