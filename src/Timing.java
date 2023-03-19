import java.util.Random;

public class Timing {
    private static Integer[] setData(int i) {
        // create instance of Random class
        Random rand = new Random();

        Integer[] data = new Integer[1000 * i];

        // assigning values
        for (int j = 0; j < data.length; j++) {
            // arrange a random set of ten integers (each between some reasonable range) to be sorted
            // for example, when data set size is 1000, random integers are generated from -9999 to 9999
            data[j] = rand.nextInt(2000 * i - 1) - 1000 * i + 1;// Autoboxing from int to Integer
        }
        return data;
    }
//==========================================================================================

    public static <T extends Comparable<T>> int getBubbleTime(int i) {
        Integer[] data = setData(i);
        long start = System.currentTimeMillis();
        Sorting.bubbleSort(data);
        long end = System.currentTimeMillis();

        return (int) (end - start);
    }

    public static <T extends Comparable<T>> int getInsertionTime(int i) {
        Integer[] data = setData(i);
        long start = System.currentTimeMillis();
        Sorting.insertionSort(data);
        long end = System.currentTimeMillis();

        return (int) (end - start);
    }

    public static <T extends Comparable<T>> int getMergeTime(int i) {
        Integer[] data = setData(i);
        long start = System.currentTimeMillis();
        Sorting.mergeSort(data);
        long end = System.currentTimeMillis();

        return (int) (end - start);
    }

    public static <T extends Comparable<T>> int getQuickTime(int i) {
        Integer[] data = setData(i);
        long start = System.currentTimeMillis();
        Sorting.quickSort(data);
        long end = System.currentTimeMillis();

        return (int) (end - start);
    }

    public static <T extends Comparable<T>> int getSelectionTime(int i) {
        Integer[] data = setData(i);
        long start = System.currentTimeMillis();
        Sorting.selectionSort(data);
        long end = System.currentTimeMillis();

        return (int) (end - start);
    }
}
