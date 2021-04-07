package algoexpert;

public class easy_20 {

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            int minIndex = findMinIndex(array, i);
            swap(array, i, minIndex);
        }

        return array;
    }

    private static int findMinIndex(int[] array, int startIndex) {
        int minIndex = startIndex;
        for (int i = startIndex + 1; i < array.length; ++i) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
