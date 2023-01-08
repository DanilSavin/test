import java.util.Arrays;
import java.util.Scanner;
public class newCalc {
    static String[] data;
    private static final String action = String.valueOf('+');
    private static final String action2 = String.valueOf('-');
    private static final String action3 = String.valueOf('*');
    private static final String action4 = String.valueOf('/');
    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение");
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        data = expression.split(" ");
        checkQuotes(expression);
        int numb = 0;
        numb = getNumb(numb);
        operation(numb, data);
    }
    private static String[] operation( int numb, String[] data) {
        if (Arrays.asList(data).contains(action)) {
            print(data[0] + data[2]);
        }
        if (Arrays.asList(data).contains(action2)) {
            int index = data[0].indexOf(data[2]);
            if (index == -1) {
                print(data[0]);
            } else {
                String result = data[0].substring(0, index);
                result = result + data[0].substring(index + data[2].length());
                print(result);
            }
        } else if (Arrays.asList(data).contains(action3)) {
            String result = data[0].repeat(numb);
            print(result);
        } else if (Arrays.asList(data).contains(action4)) {
            int div = data[0].length() / Integer.parseInt(data[2]);
            String result = data[0].substring(0, div);
            print(result);
        }
        return data;
    }
    private static int getNumb(int numb) throws Exception {
        if (data[1].equals(action) || data[1].equals(action2)) {
            if (!('\"' == data[2].charAt(0)) || !('\"' == data[2].charAt(data[2].length() - 1))) {
                throw new Exception("строки должны быть в кавычках");
            } else if (data[0].length() >= 10 || data[2].length() >= 10) {
                throw new Exception("неверная длинна строк");
            }
        } else if (data[1].equals(action3) || data[1].equals(action4)) {
            numb = Integer.parseInt(data[2]);
            if (numb >=10) {
                throw new Exception("число должно быть меньше или равно 10");
            }
        }else {
            throw new Exception("неверный оперант");
        }
        return numb;
    }
    private static void checkQuotes(String expression) throws Exception {
        if (!(expression.contains(" "))) {
            throw new Exception("выражение должно быть с пробелом");
        }
        if (!('\"' == data[0].charAt(0)) || !('\"' == data[0].charAt(data[0].length() - 1))) {
            throw new Exception("строки должны быть в кавычках");
        }
    }
    public static void print(String text) {
        text = text.replaceAll("\"", "");
        if (text.length() >= 40) {
            System.out.println("\"" + text +"..." + "\"" );
        } else {
            System.out.println("\"" + text + "\"");
        }
    }
}






