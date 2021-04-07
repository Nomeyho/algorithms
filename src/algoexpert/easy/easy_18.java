package algoexpert.easy;

public class easy_18 {

    public static int[] bubbleSort(int[] array) {
        int end = array.length - 1;
        boolean swapped = true;

        while (swapped) {
            swapped = false;

            for (int i = 0; i < end; ++i) {
                if (array[i] > array[i + 1]) {
                    swapped = true;
                    swap(array, i, i + 1);
                }
            }

            end--;
        }

        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
