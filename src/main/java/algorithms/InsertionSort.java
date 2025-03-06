package main.java.algorithms;

import java.util.Arrays;

public class InsertionSort implements SortingAlgorithm {
    public static int[][] sort(int[] array, boolean returnIntermediate) {
        if (!returnIntermediate) {
            // Only return the final sorted array
            int[] tempArray = Arrays.copyOf(array, array.length);
            insertionSort(tempArray);
            return new int[][] { tempArray };
        } else {
            // Return intermediate arrays
            int[][] intermediateArrays = new int[array.length][];
            int[] tempArray = Arrays.copyOf(array, array.length);

            for (int i = 1; i < tempArray.length; i++) {
                int key = tempArray[i];
                int j = i - 1;
                while (j >= 0 && tempArray[j] > key) {
                    tempArray[j + 1] = tempArray[j];
                    j--;
                }
                tempArray[j + 1] = key;

                // Store the intermediate array
                intermediateArrays[i] = Arrays.copyOf(tempArray, tempArray.length);
            }

            return intermediateArrays;
        }
    }

    private static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }
}