package com.Calc;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static final String ANSI_GREEN = "\u001b[32m";
    public static void main(String[] args) {
        String word = "первое";
        int number1 = getInt(word);
        word = "второе";
        int number2 = getInt(word);
        char operation = getOperation();
        int result = calc(number1,number2,operation);
        System.out.println("Результат выбранной операции: "+ ANSI_GREEN + result);
    }

    public static int getInt(String word){
        System.out.println("Введите " + word + " число:");
        int num;
        if(scanner.hasNextInt()){
            num = scanner.nextInt();
        } else {
            System.out.println("Вы ввели не целое числа. Попробуйте еще раз.");
            scanner.next();
            num = getInt(word);
        }
        return num;
    }

    public static char getOperation(){
        System.out.println("Введите одну из операций: -, +, *, / ");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы ввели не целое число. Попробуйте еще раз.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    public static int calc(int number1, int number2, char operation){
        int result;
        switch (operation){
            case '+':
                result = number1+number2;
                break;
            case '-':
                result = number1-number2;
                break;
            case '*':
                result = number1*number2;
                break;
            case '/':
                result = number1/number2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод: -, +, *, / ");
                result = calc(number1, number2, getOperation());
        }
        return result;
    }
}
