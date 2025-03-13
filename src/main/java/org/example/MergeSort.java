package main.java.org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    public static ArrayList<int[]> sort(int[] array, boolean returnIntermediate) {
        ArrayList<int[]> intermediateArrays = new ArrayList<>();
        if (returnIntermediate)
            intermediateArrays.add(Arrays.copyOf(array, array.length));

        mergeSort(array, 0, array.length-1, intermediateArrays, returnIntermediate);

        if (!returnIntermediate)
            intermediateArrays.add(Arrays.copyOf(array, array.length));
        return intermediateArrays;
    }

    private static void mergeSort(int[] array, int left, int right, ArrayList<int[]> intermediateArrays, boolean returnIntermediate) {
        if (left < right) {
            int mid = (left + right)/2;
            mergeSort(array, left, mid, intermediateArrays, returnIntermediate);
            mergeSort(array, mid+1, right, intermediateArrays, returnIntermediate);
            merge(array,left,mid,right);

            if (returnIntermediate)
                intermediateArrays.add(Arrays.copyOf(array, array.length));
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int interval[] = new int[right - left +1];
        int i = left;
        int j = mid+1;
        int k = 0;
        while(i <= mid && j <= right){
            if(array[i] <= array[j]){
                interval[k++] = array[i++];
            }
            else{
                interval[k++] = array[j++];
            }            
        }
        while(i <= mid){
            interval[k++] = array[i++];
        }
        while(j <= right){
            interval[k++] = array[j++];
        }
        i =left;
        for(int m = 0; i <= right ; m++){
            array[i++] = interval[m];
        }
    }
}