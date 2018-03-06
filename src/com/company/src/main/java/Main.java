package com.Calc;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static final String ANSI_GREEN = "\u001b[32m";
    public static void main(String[] args) {
        String word = "первое";
        double number1 = getDouble(word);
        word = "второе";
        double number2 = getDouble(word);
        char operation = getOperation();
        double result = calc(number1,number2,operation);
        System.out.println("Результат выбранной операции: "+ ANSI_GREEN + result);
    }

    public static double getDouble(String word){
        System.out.println("Введите " + word + " число:");
        double num;
        if(scanner.hasNextDouble()){
            num = scanner.nextDouble();
        } else {
            System.out.println("Вы ввели не целое числа либо без ',' . Попробуйте еще раз.");
            scanner.next();
            num = getDouble(word);
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

    public static double calc(double number1, double number2, char operation) {
        double result;
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
                if (number2 == 0){
                    throw new IllegalArgumentException("Cannot divide by 0!");
                }
                result = number1 / number2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод: -, +, *, / ");
                result = calc(number1, number2, getOperation());
        }
        return result;
    }
}
