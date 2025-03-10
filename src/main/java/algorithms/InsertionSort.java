package main.java.algorithms;

import java.util.Arrays;
import java.util.ArrayList;


public class InsertionSort implements SortingAlgorithm {
    public static ArrayList<int[]> sort(int[] array, boolean returnIntermediate) {
        if (!returnIntermediate) {
            int[] tempArray = Arrays.copyOf(array, array.length);
            insertionSort(tempArray);
            ArrayList<int[]> arr = new ArrayList<int[]>();
            arr.add(tempArray) ;
            return arr ;
        } else {
            ArrayList<int[]>intermediateArrays = new ArrayList<int[]>();
            int[] tempArray = Arrays.copyOf(array, array.length);
            intermediateArrays.add(array);

            for (int i = 1; i < tempArray.length; i++) {
                int key = tempArray[i];
                int j = i - 1;
                while (j >= 0 && tempArray[j] > key) {
                    tempArray[j + 1] = tempArray[j];
                    j--;
                }
                tempArray[j + 1] = key;
                intermediateArrays.add(Arrays.copyOf(tempArray, tempArray.length));

                //intermediateArrays[i] = Arrays.copyOf(tempArray, tempArray.length);
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