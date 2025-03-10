package main.java.algorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort implements SortingAlgorithm {
    public static ArrayList<int[]> sort(int[] array, boolean returnIntermediate) {
        if (!returnIntermediate) {
            int[] tempArray = Arrays.copyOf(array, array.length);
            mergeSort(tempArray, 0, tempArray.length - 1);
            ArrayList<int[]> arr = new ArrayList<int[]>();
            arr.add(tempArray) ;
            return arr ;
        } else {
            ArrayList<int[]>intermediateArrays = new ArrayList<int[]>();
            intermediateArrays.add(array);
            int[] tempArray = Arrays.copyOf(array, array.length);
            mergeSort(tempArray, 0, tempArray.length - 1, intermediateArrays);
            return intermediateArrays;
        }
    }

    private static void mergeSort(int[] array, int left, int right) {            //with no intermediates arrays
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void mergeSort(int[] array, int left, int right, ArrayList<int[]> intermediateArrays) {
        if (left < right) {
            int mid = left +(right-left)  / 2;
            mergeSort(array, left, mid, intermediateArrays);
            mergeSort(array, mid + 1, right, intermediateArrays);
            merge(array, left, mid, right);
            
            intermediateArrays.add(Arrays.copyOf(array, array.length));

        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k] = array[i];
                k++;
                i++;
            } else {
                temp[k] = array[j];
                k++;
                j++;
            }
        }

        while (i <= mid) {
            temp[k] = array[i];
            k++;
            i++;
        }

        while (j <= right) {
            temp[k] = array[j];
            k++;
            j++;
        }

        System.arraycopy(temp, 0, array, left, temp.length);
    }
}

