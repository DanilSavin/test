
import java.util.Scanner;
public class Example {
    static String[] data;
    static char action;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите выражение");
        String expression = sc.nextLine();
        stringSplite(expression);
        stringAction();
    }
    private static void stringAction() throws Exception {
        if (action == '+') {
            print(data[0] + data[1]);
        } else if (action == '*') {;
            String result = data[0].repeat(number(data[1]));
            print(result);
        } else if (action == '-') {
            int index = data[0].indexOf(data[1]);
            if (index == -1) {
                print(data[0]);
            } else {
                String result = data[0].substring(0, index);
                result = result + data[0].substring(index + data[1].length());
                print(result);
            }
        } else {
            int div = data[0].length() / number(data[1]);
            String result = data[0].substring(0, div);
            print(result);
        }
    }
    private static void stringSplite(String expression) throws Exception {
        if (expression.contains("+")) {
            action = '+';
            check(expression);
            data = expression.split("\\+");
            check2(data[0]);
            check2(data[1]);
            operation();
//            isAlpha(data[0]);
//            isAlpha(data[1]);
        } else if (expression.contains("-")) {
            action = '-';
            check(expression);
            data = expression.split("-");
            check2(data[0]);
            check2(data[1]);
            operation();
//            isAlpha(data[0]);
//            isAlpha(data[1]);
        } else if (expression.contains("*")) {
            action = '*';
            check(expression);
            data = expression.split("\\*");
            check2(data[0]);
            string2();
            operation();
//            isAlpha(data[0]);
        } else if (expression.contains("/")) {
            action = '/';
            check(expression);
            data = expression.split("/");
            check2(data[0]);
            string2();
            operation();
//            isAlpha(data[0]);
        } else {
            throw new Exception("неверный знак");
        }
    }
    public static void print(String text) {
        if (text.length() >= 40) {
            System.out.println("\"" + text + "..." + "\"");
        } else {
            System.out.println("\"" + text + "\"");
        }
    }
    public static void check(String expression) throws Exception {
        int numb = expression.indexOf(action);
        if (!((' ' == expression.charAt(numb - 1)) && (' ' == expression.charAt(numb + 1)))) {
            throw new Exception("Должен быть пробел");
        }
    }
    public static void check2(String expression) throws Exception {
        if (!('\"' == expression.charAt(0)) && !('\"' == expression.charAt(expression.length() - 1))) {
            throw new Exception("строки должны быть в кавычках");
        }
        if (expression.length() > 12){
            throw new Exception("неверное количество символов");
        }
    }
    public static int number(String expression) throws Exception {
        String trimStr = expression.trim();
        int numb = Integer.parseInt(trimStr);
        if (numb >= 10){
            throw new Exception("неверное число");
        }
        return numb;
    }
//        public static void isAlpha(String expression) throws Exception {
//            if (!(expression  != null && expression.matches("^[a-zA-Z]*$"))){
//                throw new Exception("ошибка строк");
//            }
//        }
        public static void operation(){
            data[0]= data[0].replaceAll("\"","").replaceAll(" ","");
            data[1] = data[1].replaceAll("\"","").replaceAll(" ","");
        }
        public static void string2() throws Exception {
                if (data[1].contains("\"")) throw new Exception("Строчку можно делить или умножать только на число");
        }
        }


