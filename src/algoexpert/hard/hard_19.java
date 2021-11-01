package algoexpert.hard;

public class hard_19 {
    public static int[] searchForRange(int[] array, int target) {
        int[] result = new int[]{-1, -1};
        searchForRange(array, target, 0, array.length - 1, result, true);
        searchForRange(array, target, 0, array.length - 1, result, false);
        return result;
    }

    public static void searchForRange(int[] array, int target, int start, int end, int[] result, boolean dir) {
        if (start > end) {
            return;
        }

        int mid = start + (end - start) / 2;
        if (array[mid] == target) {
            if (dir) {
                if (mid == 0 || array[mid - 1] != target) {
                    result[0] = mid;
                } else {
                    // might have more on the left
                    searchForRange(array, target, start, mid - 1, result, dir);
                }
            } else {
                if (mid == array.length - 1 || array[mid + 1] != target) {
                    result[1] = mid;
                } else {
                    // might have more on the right
                    searchForRange(array, target, mid + 1, end, result, dir);
                }
            }
        } else if (array[mid] < target) {
            // keep looking on right side
            searchForRange(array, target, mid + 1, end, result, dir);
        } else {
            // keep looking on left side
            searchForRange(array, target, start, mid - 1, result, dir);
        }
    }
}
