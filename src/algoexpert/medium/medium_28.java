package algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

public class medium_28 {
    private static final int LAND = 0;
    private static final int WATER = 1;

    public static List<Integer> riverSizes(int[][] matrix) {
        int I = matrix.length;
        int J = matrix[0].length;
        boolean[][] visited = new boolean[I][J];
        ArrayList<Integer> lengths = new ArrayList<Integer>();

        for (int i = 0; i < I; i++) {
            for (int j = 0; j < J; j++) {
                if (!visited[i][j] && matrix[i][j] == WATER) {
                    int len = visitRiver(i, j, matrix, visited);
                    lengths.add(len);
                }
            }
        }

        return lengths;
    }

    private static int visitRiver(int i, int j, int[][] matrix, boolean[][] visited) {
        if (visited[i][j] || matrix[i][j] == LAND) {
            return 0;
        }

        int length = 1;
        visited[i][j] = true;

        if (i > 0) { // left
            length += visitRiver(i - 1, j, matrix, visited);
        }

        if (i < matrix.length - 1) { // right
            length += visitRiver(i + 1, j, matrix, visited);
        }

        if (j > 0) { // top
            length += visitRiver(i, j - 1, matrix, visited);
        }

        if (j < matrix[0].length - 1) { // bottom
            length += visitRiver(i, j + 1, matrix, visited);
        }

        return length;
    }
}
