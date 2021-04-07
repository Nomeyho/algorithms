package algoexpert.easy;

public class easy_16 {

    public static int binarySearch(int[] array, int target) {
        int start = 0;
        int end = array.length;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (target < array[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }
    
    /*
    public static int binarySearch(int[] array, int target) {
        return binarySearchRec(array, 0, array.length, target);
    }

    // [start; end[ 
    public static int binarySearchRec(int[] array, int start, int end, int target) {
        final int mid = start + ((end - start) / 2);

        if (array[mid] == target) {
            return mid;
        } else if (target < array[mid]) {
            return binarySearchRec(array, 0, mid, target);
        } else {
            return binarySearchRec(array, mid + 1, end, target);
        }
    }
     */
}
