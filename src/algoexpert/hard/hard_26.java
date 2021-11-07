package algoexpert.hard;

public class hard_26 {
    public static int shiftedBinarySearch(int[] array, int target) {
        return shiftedBinarySearch(array, 0, array.length - 1, target);
    }

    private static int shiftedBinarySearch(int[] array, int start, int end, int target) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;
        if (target == array[mid]) {
            return mid;
        }

        if (array[mid] >= array[start]) {
            // left part is sorted
            if (target >= array[start] && target <= array[mid]) {
                // explore left
                return shiftedBinarySearch(array, start, mid - 1, target);
            } else {
                // explore right
                return shiftedBinarySearch(array, mid + 1, end, target);
            }
        } else {
            // right part is sorted
            if (target >= array[mid] && target <= array[end]) {
                // explore right
                return shiftedBinarySearch(array, mid + 1, end, target);
            } else {
                // explore left
                return shiftedBinarySearch(array, start, mid - 1, target);
            }
        }
    }
}
