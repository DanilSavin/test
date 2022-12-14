import java.util.Scanner;

public class Calculator {
    public static void main(String [] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        word=word.replaceAll(" ","");
    word = word.replace("\"","");
    String [] data;
    char action;
    if (word.contains("+")){
        data=word.split("\\+");
        action='+';
    } else if (word.contains("-")) {
        data = word.split("-");
        action = '-';
    } else if (word.contains("*")) {
        data=word.split("\\*");
        action = '*';
    } else if (word.contains("/")){
        data = word.split("/");
        action = '/';
    } else {
        throw new Exception("неверный знак");
    }
    if (action == '*' || action == '/') {
        if (data[1].contains("\"")) throw new Exception("ошибка");
    }
    for (int i=0;i< data.length;i++){
        data[i]=data[i].replace("\"","");
    }
if (action == '+'){
    System.out.println(data[0]+data[1]);
} else if (action == '*') {
    int result = Integer.parseInt(data[1]);
    for (int i = 0; i < result; i++) {
        System.out.print(data[0]);
    }
} else if (action == '-') {
    int index = data[0].indexOf(data[1]);
    if (index == -1){
        System.out.println(data[0]);
    } else {
        String result = data[0].substring(0, index);
        result = result + data[0].substring(index + data[1].length());
        System.out.println(result);
    }
    } else {
        int div = data[0].length() / Integer.parseInt(data[1]);
String result = data[0].substring(0,div);
System.out.println(result);
    }
}

    }

