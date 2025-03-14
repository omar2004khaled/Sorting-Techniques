package test.java.org.example;

import main.java.org.example.SortArray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortingComparisonTest {


        public ArrayList<int[]> Test_Insertion_Sort(int[] array)
        {
            long totalTime = 0;
            ArrayList<int[]> result = new ArrayList<>();    
            int repeat = 50 ;
            for(int i=0 ;i<repeat ;i++)
            {       System.gc();
                int[] clonedArray = array.clone();
                long startTime = System.nanoTime();
                SortArray InsertionSortArray = new SortArray(clonedArray);
                ArrayList<int[]> temp = InsertionSortArray.simpleSort(false,"InsertionSort");       
                long endTime = System.nanoTime();
                totalTime += (endTime - startTime);
                if (i == repeat-1)  
                    result = temp;
                
            }
                long averageTime = totalTime / repeat;
                System.out.println("Insertion sort: " + averageTime/1000 + " micro s");
                return result ;
        }

        public ArrayList<int[]> Test_Merge_Sort(int[] array)
        {
            long totalTime = 0;
            ArrayList<int[]> result = new ArrayList<>();    
            int repeat = 50 ;
            for(int i=0 ;i<repeat ;i++)
            {       System.gc();
                int[] clonedArray = array.clone();
                long startTime = System.nanoTime();
                SortArray MergeSortArray = new SortArray(clonedArray);
                ArrayList<int[]> temp = MergeSortArray.efficientSort(false,"MergeSort");       
                long endTime = System.nanoTime();
                totalTime += (endTime - startTime);
                if (i == repeat-1)
                result=temp ;
            }
            long averageTime = totalTime / repeat;
            System.out.println("Merge sort took: " + averageTime/1000 + " micro s");
            return result; 
        }

        public ArrayList<int[]> Test_Radix_Sort(int[] array)
        {
            System.gc();
            long totalTime = 0;
            ArrayList<int[]> result = new ArrayList<>();    
            int repeat = 50 ;
            for(int i=0 ;i<repeat ;i++)
            {
                int[] clonedArray = array.clone();
                long startTime = System.nanoTime();
                SortArray SortArrayRadix = new SortArray(clonedArray);
                ArrayList<int[]> temp = SortArrayRadix.nonComparisonSort(false,"RadixSort");
                long endTime = System.nanoTime();
                totalTime += (endTime - startTime);
                if (i == repeat-1)
                result=temp ;  
            }
            long averageTime = totalTime / repeat;
            System.out.println("Radix Sort took: " + averageTime/1000 + " micro s");
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
    @Test
    public void oneElement_array() {
        System.out.println("One element");
        int[]array = {8};
        ArrayList<int[]> result1 = Test_Insertion_Sort(array);
        ArrayList<int[]> result2 = Test_Merge_Sort(array);
        ArrayList<int[]> result3 = Test_Radix_Sort(array);

        assertArrayEquals(new int[]{8}, result1.get(0));
        assertArrayEquals(new int[]{8}, result2.get(0));
        assertArrayEquals(new int[]{8}, result3.get(0));
        System.out.println("------------------------------------------");
    }
    @Test
    public void LargeElements_array() {
        System.out.println("LargeElements_array:");
        int[]array = {70000000 , 10000000 , 20000000 , 30000000 , 90000000 , 60000000};
        ArrayList<int[]> result1 = Test_Insertion_Sort(array);
        ArrayList<int[]> result2 = Test_Merge_Sort(array);
        ArrayList<int[]> result3 = Test_Radix_Sort(array);
        
        int[] sorted_array = {10000000 , 20000000 ,30000000 ,60000000 , 70000000 , 90000000};
        assertArrayEquals(sorted_array, result1.get(0));
        assertArrayEquals(sorted_array, result2.get(0));
        assertArrayEquals(sorted_array, result3.get(0));
        System.out.println("------------------------------------------");
    }
    @Test
    public void NegativeNumbers_array() {
        System.out.println("NegativeNumbers_array:");
        int[]array = {-3, -1, -4, -2, -5};

        ArrayList<int[]> result1 = Test_Insertion_Sort(array);
        ArrayList<int[]> result2 = Test_Merge_Sort(array);
       // ArrayList<int[]> result3 = Test_Radix_Sort(array);
        
        int[] sorted_array = {-5,-4,-3,-2,-1};
        assertArrayEquals(sorted_array, result1.get(0));
        assertArrayEquals(sorted_array, result2.get(0));
        //assertArrayEquals(sorted_array, result3.get(0));
        System.out.println("------------------------------------------");
    }
    @Test
    public void SameElements_array() {
        System.out.println("SameElements_array:");
        int[]array = {5,5,5,5,5,5,5};

        ArrayList<int[]> result1 = Test_Insertion_Sort(array);
        ArrayList<int[]> result2 = Test_Merge_Sort(array);
        ArrayList<int[]> result3 = Test_Radix_Sort(array);

        assertArrayEquals(array, result1.get(0));
        assertArrayEquals(array, result2.get(0));
        assertArrayEquals(array, result3.get(0));
        System.out.println("------------------------------------------");
    }
    @Test
    public void MinMaxInteger_test() {
        System.out.println("Min/Max Integer_array:");
        int[] array = {Integer.MIN_VALUE, Integer.MAX_VALUE, 0, -1, 1, -500, 500};

        ArrayList<int[]> result1 = Test_Insertion_Sort(array);
        ArrayList<int[]> result2 = Test_Merge_Sort(array);
        //ArrayList<int[]> result3 = Test_Radix_Sort(array);

        int[] sortedArray = array.clone();
        Arrays.sort(sortedArray);

        assertArrayEquals(sortedArray, result1.get(0));
        assertArrayEquals(sortedArray, result2.get(0));
        //assertArrayEquals(sortedArray, result3.get(0));
        System.out.println("------------------------------------------");
   }
   @Test
    public void SmallSizeArray_test() {
        System.out.println("Small Size Array_array:");
        int[] array = {5, 1};

        ArrayList<int[]> result1 = Test_Insertion_Sort(array);
        ArrayList<int[]> result2 = Test_Merge_Sort(array);
        ArrayList<int[]> result3 = Test_Radix_Sort(array);

        int[] sortedArray = {1, 5};

        assertArrayEquals(sortedArray, result1.get(0));
        assertArrayEquals(sortedArray, result2.get(0));
        assertArrayEquals(sortedArray, result3.get(0));
        System.out.println("------------------------------------------");
}
   @Test
   public void RepeatingNumbers_test() {
            System.out.println("Repeating Numbers Test:");
            int[] array = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};

            ArrayList<int[]> result1 = Test_Insertion_Sort(array);
            ArrayList<int[]> result2 = Test_Merge_Sort(array);
            ArrayList<int[]> result3 = Test_Radix_Sort(array);

            assertArrayEquals(array, result1.get(0));
            assertArrayEquals(array, result2.get(0));
            assertArrayEquals(array, result3.get(0));
            System.out.println("------------------------------------------");
}
@Test
   public void smallLastElement_test() {
    System.out.println("small Last Element Test:");
    int[] array = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 1};

    ArrayList<int[]> result1 = Test_Insertion_Sort(array);
    ArrayList<int[]> result2 = Test_Merge_Sort(array);
    ArrayList<int[]> result3 = Test_Radix_Sort(array);

    int[] sortedArray = {1,1000, 2000, 3000, 4000, 5000, 6000, 7000};
  

    assertArrayEquals(sortedArray, result1.get(0));
    assertArrayEquals(sortedArray, result2.get(0));
    assertArrayEquals(sortedArray, result3.get(0));
    System.out.println("------------------------------------------");
}
  @Test
  public void AlternatingHighLow_test() {
    System.out.println("Alternating High & Low Test:");
    int[] array = {1, 100, 2, 99, 3, 98, 4, 97};

    ArrayList<int[]> result1 = Test_Insertion_Sort(array);
    ArrayList<int[]> result2 = Test_Merge_Sort(array);
    ArrayList<int[]> result3 = Test_Radix_Sort(array);

    int[] sortedArray = {1,2,3,4,97,98,99,100};
    

    assertArrayEquals(sortedArray, result1.get(0));
    assertArrayEquals(sortedArray, result2.get(0));
    assertArrayEquals(sortedArray, result3.get(0));
    System.out.println("------------------------------------------");
}
    
  
    }


