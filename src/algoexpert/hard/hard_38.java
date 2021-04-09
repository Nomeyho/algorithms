package algoexpert.hard;

import java.util.Arrays;

public class hard_38 {

    public static void main(final String[] args) {
        int[] array = heapSort(new int[]{8, 5, 2, 9, 5, 6, 3});
        System.out.println(Arrays.toString(array));
    }

    public static int[] heapSort(int[] array) {
        buildMaxHeap(array);

        for (int i = 1; i <= array.length; i++) {
            // place greatest element at final position
            swap(array, 0, array.length - i);
            // restore heap invariant
            maxHeapify(array, 0, array.length - i);
        }

        return array;
    }

    private static void buildMaxHeap(int[] array) {
        for (int i = leafIndex(array.length); i >= 0; --i) {
            maxHeapify(array, i, array.length);
        }
    }

    // FIXME: coud be done iteratively
    private static void maxHeapify(int[] array, int i, int len) {
        int left = 2 * i;
        int right = 2 * i + 1;

        if (right < len && array[right] > array[i] && array[right] > array[left]) {
            // has right child AND is bigger
            swap(array, i, right);
            maxHeapify(array, right, len);
        } else if (left < len && array[left] > array[i]) {
            swap(array, i, left);
            maxHeapify(array, left, len);
        }
    }

    private static int leafIndex(int size) {
        return (int) ((size / 2) + 0.5);
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
