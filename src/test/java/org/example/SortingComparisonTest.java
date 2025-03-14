package test.java.org.example;

import main.java.org.example.SortArray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.Collections;

public class SortingComparisonTest {


        long startTime, endTime, duration;

        // Test insertion sort
        public ArrayList<int[]> Test_Insertion_Sort(int[] array)
        {
        int[] clonedArray = array.clone();
        startTime = System.nanoTime();
        SortArray InsertionSortArray = new SortArray(clonedArray);
        ArrayList<int[]> result = InsertionSortArray.simpleSort(false,"InsertionSort");       
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Insertion sort: " + duration + " nanoseconds.");
        return result ;
        }

        // Test QuickSort
        public ArrayList<int[]> Test_Merge_Sort(int[] array)
        {
        int[] clonedArray = array.clone();
        startTime = System.nanoTime();
        SortArray MergeSortArray = new SortArray(clonedArray);
        ArrayList<int[]> result = MergeSortArray.efficientSort(false,"MergeSort");       
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Merge sort took: " + duration + " nanoseconds.");
        return result ;
        }

        // Test BubbleSort
        public ArrayList<int[]> Test_Radix_Sort(int[] array)
        {
        int[] clonedArray = array.clone();
        startTime = System.nanoTime();
        SortArray SortArrayRadix = new SortArray(clonedArray);
        ArrayList<int[]> result = SortArrayRadix.nonComparisonSort(false,"RadixSort");
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Radix Sort took: " + duration + " nanoseconds.");
        return result ;
        }

        public int[] generateUniqueRandomArray(int size) 
        {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        Collections.shuffle(list);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
 
    @Test
    public void BestCase_test() {
        System.out.println("Best Case:");
        int[] array = new int[1000];
        for(int i=0 ;i<1000;i++)
        {
            array[i] = i ;
        }

        ArrayList<int[]> result1 = Test_Insertion_Sort(array);
        ArrayList<int[]> result2 = Test_Merge_Sort(array);
        ArrayList<int[]> result3 = Test_Radix_Sort(array);

        assertArrayEquals(array, result1.get(0));
        assertArrayEquals(array, result2.get(0));
        assertArrayEquals(array, result3.get(0));
        System.out.println("------------------------------------------");
    }

    @Test
    public void AverageCase_test() {
        System.out.println("Average case:");
        int[] array = generateUniqueRandomArray(1000);

        ArrayList<int[]> result1 = Test_Insertion_Sort(array);
        ArrayList<int[]> result2 = Test_Merge_Sort(array);
        ArrayList<int[]> result3 = Test_Radix_Sort(array);

        int[] sorted_array = new int[1000];
        for(int i=0 ;i<1000;i++)
        {
            sorted_array[i] = i ;
        }


        assertArrayEquals(sorted_array, result1.get(0));
        assertArrayEquals(sorted_array, result2.get(0));
        assertArrayEquals(sorted_array, result3.get(0));
        System.out.println("------------------------------------------");
    }
    @Test
    public void WorstCase_test() {
        System.out.println("Worst case:");
        int[] array = new int[1000];
        int[] sorted_array = new int[1000] ;

        for(int i=999 ;i >=0 ;i--)
         array[1000-i-1] = i ;

        for(int i=0; i<1000 ;i++)
         sorted_array[i] = i ; 

        ArrayList<int[]> result1 = Test_Insertion_Sort(array);
        ArrayList<int[]> result2 = Test_Merge_Sort(array);
        ArrayList<int[]> result3 = Test_Radix_Sort(array);

        assertArrayEquals(sorted_array, result1.get(0));
        assertArrayEquals(sorted_array, result2.get(0));
        assertArrayEquals(sorted_array, result3.get(0));
        System.out.println("------------------------------------------");
    }

  
    }


