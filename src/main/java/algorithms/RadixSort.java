package main.java.algorithms;

import java.util.Arrays;
import java.util.ArrayList;

public class RadixSort implements SortingAlgorithm {
    public static ArrayList<int[]> sort(int[] array, boolean returnIntermediate) {
        if (!returnIntermediate) {
            int[] tempArray = Arrays.copyOf(array, array.length);
            radixSort(tempArray);
            ArrayList<int[]> arr = new ArrayList<int[]>();
            arr.add(tempArray) ;
            return arr ;
        } else {
            ArrayList<int[]>intermediateArrays = new ArrayList<int[]>();
            int[] tempArray = Arrays.copyOf(array, array.length);
            radixSort(tempArray, intermediateArrays);
            return intermediateArrays;
        }
    }

    private static void radixSort(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);
        }
    }

    private static void radixSort(int[] array, ArrayList<int[]> intermediateArrays) {
        int max = Arrays.stream(array).max().getAsInt();
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);
            //intermediateArrays[exp] = Arrays.copyOf(array, array.length);
            intermediateArrays.add(array);
        }
    }

    private static void countingSort(int[] array, int exp) {
        int[] output = new int[array.length];
        int[] count = new int[10];

        for (int value : array) {
            count[(value / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, array, 0, array.length);
    }
}