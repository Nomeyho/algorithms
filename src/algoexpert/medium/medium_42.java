package algoexpert.medium;

public class medium_42 {

    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        // Start point (top right)
        int i = 0; // discard above
        int j = matrix[0].length - 1; // discarded right

        // Move down if target is greater
        // Move left if target is smaller
        while (i < matrix.length && j >= 0) {
            int value = matrix[i][j];
            if (target == value) {
                return new int[]{i, j};
            } else if (target < value) {
                j--;
            } else {
                i++;
            }
        }

        return new int[]{-1, -1};
    }

      /*
    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        int I = matrix.length;
        int J = matrix[0].length;

        // Find rows & cols
        int i = 0;
        while (i < I && target >= matrix[i][0]) i++;
        int j = 0;
        while (j < J && target >= matrix[0][j]) j++;
        i--;
        j--;

        // Try row
        for (int bi = i; bi >= 0; bi--) {
            if (matrix[bi][j] == target) {
                return new int[] {bi, j};
            } else if (matrix[bi][j] < target) {
                break;
            }
        }

        // Try column
        for (int bj = j; bj >= 0; bj--) {
            if (matrix[i][bj] == target) {
                return new int[] {i, bj};
            } else if (matrix[i][bj] < target) {
                break;
            }
        }

        return new int[] {-1, -1};
    }
       */
}
