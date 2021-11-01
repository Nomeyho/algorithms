package algoexpert.hard;

public class hard_15 {

    public static void main(String[] args) {
        int[] array = new int[]{-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
        System.out.println(new hard_15().indexEqualsValue(array));
    }

    public int indexEqualsValue(int[] array) {
        return indexEqualsValue(array, 0, array.length - 1);
    }

    public int indexEqualsValue(int[] array, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (array[mid] == mid) {
            if (mid == 0) {
                return 0;
            } else if (array[mid - 1] < mid - 1) {
                return mid;
            } else {
                return indexEqualsValue(array, start, mid - 1);
            }
        } else if (array[mid] < mid) {
            return indexEqualsValue(array, mid + 1, end);
        } else {
            return indexEqualsValue(array, start, mid - 1);
        }
    }
}
