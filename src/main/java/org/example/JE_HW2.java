package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JE_HW2 {
    public static void main(String[] args) {
//        floatDigit();
        task2(new int[]{1,2,3,4,5,6,7,8}, 2,2);
        task2(new int[]{1,2,3,4,5,6,7,8}, 9,2);
        task2(new int[]{1,2,3,4,5,6,7,8}, 9,0);
        task3();
        task4();
    }
    public static void floatDigit(){
        boolean flag = true;
        while (flag){
            System.out.println("Введите дробное число: ");
            Scanner scanner = new Scanner(System.in);
            try {
                float num = scanner.nextFloat();
                System.out.println(num);
                flag = false;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка. Вы ввели не дробное число.");
            }
        }
    }

//    Задание 2
    public static void task2(int [] arr, int i, int d){
            if (d == 0){
                System.out.println("Ошибка. На ноль делить нельзя.");
                return;
            } else if (i > arr.length) {
                System.out.println("Ошибка. Нет столько элементов в массиве.");
                return;
            }
        double catchedRes1 = arr[i] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
    }

//    Задание 3
    public static void task3(){

            int a = 90;
            int b = 3;
            if (b != 0){
                System.out.println(a / b);
            }else {
                System.out.println("Ошибка. На ноль делить нельзя.");
            }
            printSum(23, 234);
            int[] abc = { 1, 2 };
            if (abc.length >= 3){
                abc[3] = 9;
            } else {
                System.out.println("Ошибка. Мало элементов массива.");
            }
    }
    public static void printSum(Integer a, Integer b) throws NullPointerException{
        if (a != null && b != null){
            System.out.println(a + b);
        } else {
            throw new NullPointerException("Ошибка. Числа не могут ровняться null.");
        }
    }
    public static void task4(){
        boolean flag = true;
        while (flag){
            System.out.println("Введите что-нибудь: ");
            Scanner scanner = new Scanner(System.in);
                String str = scanner.nextLine();
                if (str == ""){
                    System.out.println("Ошибка. Нельзя вводить пустую строку.");
                } else {
                    System.out.println(str);
                    flag = false;
                }
        }
    }
}
