package algoexpert.very_hard;

import java.util.Arrays;

public class very_hard_28 {

    public static void main(final String[] args) {
        int[] array = mergeSort(new int[]{8, 5, 2, 9, 5, 6, 3});
        System.out.println(Arrays.toString(array));
    }

    // Space complexity can be improved to O(n) instead of 0(log n)
    // by passing a temporary array through the recursive calls
    public static int[] mergeSort(int[] array) {
        return mergeSort(array, 0, array.length - 1);
    }

    private static int[] mergeSort(int[] array, int start, int end) {
        if (start == end) {
            return new int[]{array[start]};
        }

        int mid = (start + end) / 2;
        int[] leftArray = mergeSort(array, start, mid);
        int[] rightArray = mergeSort(array, mid + 1, end);
        return merge(leftArray, rightArray);
    }

    private static int[] merge(int[] leftArray, int[] rightArray) {
        int[] sortedArray = new int[leftArray.length + rightArray.length];
        int i = 0;
        int left = 0;
        int right = 0;

        while (left < leftArray.length && right < rightArray.length) {
            if (leftArray[left] <= rightArray[right]) {
                sortedArray[i] = leftArray[left];
                left++;
            } else {
                sortedArray[i] = rightArray[right];
                right++;
            }
            i++;
        }

        // One of the half-array hasn't been fully processed yet
        while (left < leftArray.length) {
            sortedArray[i] = leftArray[left];
            left++;
            i++;
        }

        while (right < rightArray.length) {
            sortedArray[i] = rightArray[right];
            right++;
            i++;
        }

        return sortedArray;
    }
}
