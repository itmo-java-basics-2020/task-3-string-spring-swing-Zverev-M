package ru.itmo.java;

import java.util.Arrays;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0){
            return new int[0];
        }

        int[] newArray = new int[inputArray.length];
        newArray[0] = inputArray[inputArray.length - 1];

        for (int i = 0; i < inputArray.length - 1; i++) {
            newArray[i + 1] = inputArray[i];
        }
        return newArray;
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     *
     * Если входной массив пуст или равен null - вернуть 0
     *
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0){
            return 0;
        }

        if (inputArray.length == 1){
            return inputArray[0];
        }

        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for (int i = 0; i < inputArray.length; i++){
            if (inputArray[i] > max1){
                max2 = max1;
                max1 = inputArray[i];
            }
            else if (inputArray[i] > max2){
                max2 = inputArray[i];
            }
        }
        return max1 * max2;
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     *
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if (input == null || input.length() == 0){
            return 0;
        }

        input = input.toUpperCase();
        int k = 0;
        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) == 'A' || input.charAt(i) == 'B'){
                k++;
            }
        }

        return (int)(k * 100 / input.length());
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null){
            return false;
        }
        for (int i = 0; i < input.length() / 2; i++){
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        int k = 1;
        String str = "";
        if (input == null || input.length() == 0){
            return "";
        }
        char currentSymbol = input.charAt(0);

        for (int i = 1; i < input.length(); i++){
            if (input.charAt(i) == currentSymbol){
                k++;
            }
            else{
                str = str + currentSymbol + k;
                k = 1;
                currentSymbol = input.charAt(i);
            }
        }

        return str + currentSymbol + k;
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if ((one == null || two == null) || (one.equals("") && two.equals(""))){
            return false;
        }
        char[] oneArray = one.toCharArray();
        char[] twoArray = two.toCharArray();

        Arrays.sort(oneArray);
        Arrays.sort(twoArray);

        one = new String(oneArray);
        two = new String(twoArray);
        return one.equals(two);
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null || s.equals("")){
            return false;
        }
        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);

        for (int i = 1; i < s.length(); i++){
            if (sArray[i] == sArray[i - 1]){
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     *
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if (m == null){
            return new int[0][0];
        }

        int[][] newMatrix = new int[m.length][m.length];
        for (int i = 0; i < m.length; i++){
            for (int j = 0; j < m.length; j++){
                newMatrix[i][j] = m[j][i];
            }
        }
        return newMatrix;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     *
     * Запрещается пользоваться функций join
     *
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if (inputStrings == null || inputStrings.length == 0){
            return "";
        }
        if (separator == null){
            separator = ' ';
        }

        String res = "";
        for (int i = 0; i < inputStrings.length - 1; i++){
            res += inputStrings[i] + separator;
        }

        return res + inputStrings[inputStrings.length - 1];
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        int k = 0;
        if (inputStrings == null || prefix == null){
            return k;
        }

        for (int i = 0; i < inputStrings.length; i++){
            if (inputStrings[i].startsWith(prefix)){
                k++;
            }
        }
        return k;
    }
}
