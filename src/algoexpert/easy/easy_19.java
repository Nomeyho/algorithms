package algoexpert.easy;

public class easy_19 {

    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; ++i) {
            int j = i;
            while (j > 0 && array[j] < array[j - 1]) {
                swap(array, j, j - 1);
                j--;
            }
        }

        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
