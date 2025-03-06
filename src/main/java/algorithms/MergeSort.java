package main.java.algorithms;

import java.util.Arrays;

public class MergeSort implements SortingAlgorithm {
    public static int[][] sort(int[] array, boolean returnIntermediate) {
        if (!returnIntermediate) {
            // Only return the final sorted array
            int[] tempArray = Arrays.copyOf(array, array.length);
            mergeSort(tempArray, 0, tempArray.length - 1);
            return new int[][] { tempArray };
        } else {
            // Return intermediate arrays
            int[][] intermediateArrays = new int[array.length][];
            int[] tempArray = Arrays.copyOf(array, array.length);
            mergeSort(tempArray, 0, tempArray.length - 1, intermediateArrays);
            return intermediateArrays;
        }
    }

    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void mergeSort(int[] array, int left, int right, int[][] intermediateArrays) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid, intermediateArrays);
            mergeSort(array, mid + 1, right, intermediateArrays);
            merge(array, left, mid, right);

            // Store the intermediate array
            intermediateArrays[left] = Arrays.copyOf(array, array.length);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = array[i++];
        }

        while (j <= right) {
            temp[k++] = array[j++];
        }

        System.arraycopy(temp, 0, array, left, temp.length);
    }
}