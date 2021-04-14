package algoexpert.medium;

public class medium_8 {

    public static void main(final String[] args) {
        int result = new medium_8().firstDuplicateValue(new int[]{1, 1, 2, 3, 3, 2, 2});
        System.out.println(result);
    }

    // Goal: O(1) space
    // Idea: set array[v] = -array[v] when encountering array[i] = v 
    public int firstDuplicateValue(int[] array) {

        for (int i = 0; i < array.length; ++i) {
            int value = array[i];
            int index = index(value);

            if (array[index] < 0) {
                return index + 1;
            }

            array[index] *= -1;
        }

        return -1;
    }

    private static int index(int n) {
        return Math.abs(n) - 1;
    }
}
