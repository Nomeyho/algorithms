package algoexpert.medium;

public class medium_4 {

    public static boolean isMonotonic(int[] array) {

        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 1; i < array.length; ++i) {
            if (array[i - 1] < array[i]) {
                isDecreasing = false;
            }

            if (array[i - 1] > array[i]) {
                isIncreasing = false;
            }

            // early stop
            if (!isIncreasing && !isDecreasing) {
                return false;
            }
        }

        return isIncreasing || isDecreasing;
    }

}
