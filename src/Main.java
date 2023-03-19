/**
 * Searching and sorting program project to practice skills we have learned in Programming Languages 3 course.
 *
 * @author Jingjing Yang
 * @version 1.0
 */

import java.util.Queue;
import java.util.Scanner;
import java.util.Random;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        //  make a menu based user interface
        String choice = "0";
        // this menu is to be able to rerun any function as many times as wanted and only after choosing Quit the user will exit the application
        while (!choice.equals("q")) {
            System.out.print("\nMenu of Searching and Sorting Testbed.\n" +
                    "1)  Linear searching\n" +
                    "2)  Binary searching\n" +
                    "3)  O(n^2) type of sorting\n" +
                    "4)  O(n*log(n)) type of sorting\n" +
                    "5)  Sorting performance\n\n" +
                    "q/Q) Quit\n\n" +
                    "Your choice:  ");

            Scanner scan = new Scanner(System.in);
            choice = scan.nextLine().toLowerCase();

            switch (choice) {
                case "1":
                    doLinearSearching();
                    break;
                case "2":
                    doBinarySearching();
                    break;
                case "3":
                    doInsertationSorting();
                    break;
                case "4":
                    doQuickSorting();
                    break;
                case "5":
                    printPerformance();
                    break;
                case "q":
                    System.out.println("Quiting...");
                    break;
                default:
                    System.out.println("Invalid input! Please try again...");
                    break;
            }
        }
    }

    public static void doLinearSearching() {
        Integer[] data = new Integer[10];
        for (int i = 0; i < data.length; i++) {
            // the searched list contains items from 0 to 9
            data[i] = i; // Autoboxing from int to Integer
        }
        System.out.print("In the list are values 0, ..., 9; which value woudld you like to search with linear search? ");
        Scanner scan = new Scanner(System.in);
        Integer target = scan.nextInt();// Autoboxing from int to Integer
        // The application says if given value was found or not.
        System.out.println(Searching.linearSearch(data, 0, data.length - 1, target) ? "\nFound" : "\nNot found");
    }

    public static void doBinarySearching() {
        Integer[] data = new Integer[10];
        for (int i = 0; i < data.length; i++) {
            // the searched list contains items from 0 to 9
            data[i] = i; // Autoboxing from int to Integer
        }
        System.out.print("In the list are values 0, ..., 9; which value woudld you like to search with binary search? ");
        Scanner scan = new Scanner(System.in);
        Integer target = scan.nextInt();// Autoboxing from int to Integer
        // The application says if given value was found or not.
        System.out.println(Searching.binarySearch(data, 0, data.length - 1, target) ? "\nFound" : "\nNot found");
    }

    public static void doInsertationSorting() {
        Integer[] data2 = new Integer[10];

        // create instance of Random class
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            // Generate random integers in range -99 to 99
            // the sorted list contains a random set of ten integers
            data2[i] = rand.nextInt(199) - 99;// Autoboxing from int to Integer
        }

        // Data is output before and after sorting
        System.out.println("\nData set before insertion sorting: ");
        Sorting.printArrayList(data2);
        System.out.println("\n\nData set after insertion sorting: ");
        Sorting.insertionSort(data2);
        Sorting.printArrayList(data2);
        System.out.println();
    }

    public static void doQuickSorting() {
        Integer[] data2 = new Integer[10];

        // create instance of Random class
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            // Generate random integers in range -99 to 99
            // the sorted list contains a random set of ten integers
            data2[i] = rand.nextInt(199) - 99;// Autoboxing from int to Integer
        }

        // Data is output before and after sorting
        System.out.println("\nData set before quicksort: ");
        Sorting.printArrayList(data2);
        System.out.println("\n\nData set after quicksort: ");
        Sorting.quickSort(data2);
        Sorting.printArrayList(data2);
        System.out.println();
    }

    public static void printPerformance() {
        String[] method = new String[11];//declare a 11 rows array to hold explanation for each row
        method[0] = "";
        method[1] = "bubbleSort,random,comparisons";
        method[2] = "bubbleSort,random,ms";
        method[3] = "insertionSort,random,comparisons";
        method[4] = "insertionSort,random,ms";
        method[5] = "mergeSort,random,comparisons";
        method[6] = "mergeSort,random,ms";
        method[7] = "quickSort,random,comparisons";
        method[8] = "quickSort,random,ms";
        method[9] = "selectionSort,random,comparisons";
        method[10] = "selectionSort,random,ms";

        int[][] p = new int[11][10];//declare a 11 rows 10 columns multiDimensional Arrays to hold number of comparisons and milliseconds

        // assigning values
        for (int i = 1; i <= 10; i++) {
            p[0][i - 1] = 1000 * i;
            // sort items of sizes n, 2*n, … , 10*n

            p[2][i - 1] = Timing.getBubbleTime(i);
            p[1][i - 1] = Sorting.counter;

            p[4][i - 1] = Timing.getInsertionTime(i);
            p[3][i - 1] = Sorting.counter;

            p[6][i - 1] = Timing.getMergeTime(i);
            p[5][i - 1] = Sorting.counter;

            p[8][i - 1] = Timing.getQuickTime(i);
            p[7][i - 1] = Sorting.counter;

            p[10][i - 1] = Timing.getSelectionTime(i);
            p[9][i - 1] = Sorting.counter;
        }

        // print the performance form
        for (int k = 0; k < 11; k++) {
            System.out.printf("%-35s", method[k]);
            for (int m = 0; m < 10; m++) {
                System.out.printf("%-10d", p[k][m]);
            }
            System.out.println();
        }
    }
}
