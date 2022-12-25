
import java.sql.SQLOutput;
import java.util.Scanner;
public class Calc {
    public static char action;
    public static String[] data;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение [\"a\" + \"b\", \"a\" - \"b\", \"a\" * x, \"a\" / x] где a и b - строки а x - число  от 1 до 10 включительно  + Enter ");
        String word = sc.nextLine();
        word = changeString(word);
        word = stringSplit(word);
    }
    public static String stringSplit(String word) throws Exception {
        if (word.contains("+")) {
            data = word.split("\\+");
            action = '+';
        } else if (word.contains("-")) {
            data = word.split("-");
            action = '-';
        } else if (word.contains("*")) {
            data = word.split("\\*");
            action = '*';
        } else if (word.contains("/")) {
            data = word.split("/");
            action = '/';
        } else {
            throw new Exception("неверный знак");
        }
        stringAction(data, action);
        return word;
    }

    private static String[] stringAction(String[] data, char action) throws Exception {
        if (action == '*' || action == '/') {
            if ((Integer.parseInt(data[1]) > 10) || Integer.parseInt(data[1]) < 0) {
                throw new Exception("Неверное число");
            }
        } else if ( action == '*' || action == '/') {
            if (data[1].contains("\"")) throw new Exception("Строчку можно делить или умножать только на число");
        }
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
        }
        if (action == '+') {
            printIn(data[0] + data[1]);
        } else if (action == '*') {
            int numb = Integer.parseInt(data[1]);
            String result = "";
            for (int i = 0; i < numb; i++) {
                result = result + data[0];
            }
            printIn(result);
        } else if (action == '-') {
            int index = data[0].indexOf(data[1]);
            if (index == -1) {
                printIn(data[0]);
            } else {
                String result = data[0].substring(0, index);
                result = result + data[0].substring(index + data[1].length());
                printIn(result);
            }
        } else {
            int div = data[0].length() / Integer.parseInt(data[1]);
            String result = data[0].substring(0, div);
            printIn(result);
        }
        return data;
    }
    private static void printIn(String text) {
        System.out.print("\"" + text + "\"");
        if (text.length() >= 40){
            System.out.println(text + "...");
        }
    }
    public static  String changeString(String word) {
        word = word.replaceAll(" ", "");
        word = word.replaceAll("\"", "");
        return word;
    }
}
