package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path of the input file: ");
        String filePath = scanner.nextLine();

        try {
            int[] array = readArrayFromFile(filePath);
            SortArray sortArray = new SortArray(array);
            System.out.println("Array initialized successfully!");

            while (true) {
                System.out.println("\nMain Menu:");
                System.out.println("1. Simple Sort (Insertion Sort - O(n²))");
                System.out.println("2. Efficient Sort (Merge Sort - O(n log n))");
                System.out.println("3. Non-Comparison Sort (Radix Sort - O(n))");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                while(choice > 4 || choice <1)
                 {
                    System.out.print("\u001B[31mPlease enter valid option (1,2,3,4): \u001B[0m");
                    choice = scanner.nextInt() ;
                 }

                if (choice == 4)
                    break;

                System.out.print("Return intermediate arrays? (y/n): ");
                char temp = scanner.next().charAt(0);
                while(temp != 'y' && temp != 'n')
                {
                    System.out.print("\u001B[31mPlease enter valid option (y/n): \u001B[0m");
                    temp = scanner.next().charAt(0);
                }
                boolean returnIntermediate ;
                if(temp == 'y')
                 returnIntermediate = true;
                else
                 returnIntermediate = false; 
                long TimeElapsed; 
                long start ;
                long finish;
                ArrayList<int[]> result = new ArrayList<int[]>();
                switch (choice) {
                    case 1:
                        start = System.nanoTime();
                        result = sortArray.simpleSort(returnIntermediate);
                        finish = System.nanoTime();
                        TimeElapsed = (finish-start)/1000 ;
                        break;
                    case 2:
                        start = System.nanoTime();
                        result = sortArray.efficientSort(returnIntermediate);
                        finish = System.nanoTime();
                        TimeElapsed = (finish-start)/1000 ;
                        break;
                    case 3:
                        start = System.nanoTime();
                        result = sortArray.nonComparisonSort(returnIntermediate);
                        finish = System.nanoTime();
                        TimeElapsed = (finish-start)/1000 ;
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        continue;
                }

                if(returnIntermediate)
                 {
                System.out.println("Intermediate arrays:");
                for (int[] arr : result) 
                    System.out.println(Arrays.toString(arr));
                System.out.println("Final sorted array :");    
                System.out.println(Arrays.toString(result.getLast()));    
                }
                 else
                 {
                    System.out.println("Final sorted array :");
                    System.out.println(Arrays.toString(result.getFirst()));
                 }
                System.out.println("\u001B[34mTime Taken = " + TimeElapsed + " µs\u001B[0m");
                System.out.println("============================");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }

    private static int[] readArrayFromFile(String filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        String line = scanner.nextLine().trim();
        String[] elements = line.split(",");            //ignore commas
        int[] array = new int[elements.length];
        for (int i = 0; i < elements.length; i++) {
            array[i] = Integer.parseInt(elements[i].trim()); //ignore spaces
        }
        scanner.close();
        return array;
    }
}