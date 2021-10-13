package _6kyu;

import java.util.Arrays;

public class SortTheOdd {
    public static int[] sortArray(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == 0 || array[i]%2 == 0) {
                continue;
            }
            for (int j = i + 1; j < array.length; j++) {
                if(array[i]>array[j] && array[j]%2 != 0){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;

//        // Sort the odd numbers only
//        final int[] sortedOdd = Arrays.stream(array).filter(e -> e % 2 == 1).sorted().toArray();
//
//        // Then merge them back into original array
//        for (int j = 0, s = 0; j < array.length; j++) {
//            if (array[j] % 2 == 1) array[j] = sortedOdd[s++];
//        }
//
//        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(SortTheOdd.sortArray(new int[]{7, 1})));
        System.out.println(Arrays.toString(SortTheOdd.sortArray(new int[]{5, 8, 6, 3, 4})));
        System.out.println(Arrays.toString(SortTheOdd.sortArray(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})));

    }
}
