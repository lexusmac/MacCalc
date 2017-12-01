package com.company;

import java.util.Scanner;

public class Fib {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
            int num = getInt();
            int result = calc(num);
            System.out.println("Результат: " + result);
    }

    public static int getInt(){
        System.out.println("Введите число:");
        int num;
        if(scanner.hasNextInt()){
            num = scanner.nextInt();
        } else {
            System.out.println("Вы ввели не целое числа. Попробуйте еще раз.");
            scanner.next();
            num = getInt();
        }
        return num;
    }

//    public static int calc(int num){
//            int result = num*(num+1)/2;
//            return result;
    static int calc(int num){
        if (num == 0) return 0;
        if (num == 1) return 1;
        int result = (calc(num-1)+calc(num-2));
        return result;
    }
}
