//Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
//        Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?
//        Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий
//        новый массив, каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
//        Если длины массивов не равны, необходимо как-то оповестить пользователя.
//        * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый
//        массив, каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. Если
//        длины массивов не равны, необходимо как-то оповестить пользователя. Важно: При выполнении метода
//        единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.
package org.example;

public class JE_HW1 {
    public static void main(String[] args) {
        divide(1, 0);
        getElement(new int[]{1, 2, 3}, 4);
        System.out.println(parser("ee"));
        summArr(new int[]{1,2,3}, new int[]{1,2,3,4});
        divArr(new int[]{1,2,3}, new int[]{1,2,3,4});
        divArr(new int[]{1,2,3}, new int[]{1,2,0});
    }
    public static double divide(int x, int y){
        return x / y;
    }
    public static int getElement(int[] arr, int element){
        return arr[element];
    }
    public static int parser (String a) {
        return Integer.parseInt(a);
    }
    public static int[] summArr(int[] arr1, int[] arr2) throws IllegalArgumentException{
        if (arr1.length == arr2.length){
            int[] result = new int[arr1.length];
            for (int i = 0; i < arr1.length; i++) {
                result[i] = arr1[i] + arr2[i];
            }
            return result;
        } else {
            throw new IllegalArgumentException("Error. Length arr1 != length arr2.");
        }
    }
    public static int[] divArr(int[] arr1, int[] arr2) throws RuntimeException {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Массивы имеют разную длину");
        }
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            if (arr2[i] == 0){
                throw new RuntimeException("Деление на 0");
            }
            else {
                result[i] = arr1[i] / arr2[i];
            }
        }
        return result;
    }
}
