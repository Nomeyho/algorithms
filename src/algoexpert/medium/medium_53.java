package algoexpert.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class medium_53 {

    static class Index {
        final int i;
        final int j;
        final int iteration;

        Index(int i, int j, int iteration) {
            this.i = i;
            this.j = j;
            this.iteration = iteration;
        }
    }

    public int minimumPassesOfMatrix(int[][] matrix) {
        Queue<Index> indices = new ArrayDeque<>();
        int result = -1;

        // Start with positive values
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > 0) {
                    indices.add(new Index(i, j, 0));
                }
            }
        }

        // BFS
        while (!indices.isEmpty()) {
            Index index = indices.remove();

            for (Index neighbor : getNeighbor(index, matrix)) {
                if (matrix[neighbor.i][neighbor.j] < 0) {
                    indices.add(neighbor);
                    matrix[neighbor.i][neighbor.j] *= -1;
                }
            }

            result = Math.max(result, index.iteration);
        }

        // Do we still have negative value?
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < 0) {
                    return -1;
                }
            }
        }

        return result;
    }

    private static List<Index> getNeighbor(Index index, int[][] matrix) {
        List<Index> neighbors = new ArrayList<>();

        // left
        if (index.i > 0) {
            neighbors.add(new Index(index.i - 1, index.j, index.iteration + 1));
        }

        // right
        if (index.i + 1 < matrix.length) {
            neighbors.add(new Index(index.i + 1, index.j, index.iteration + 1));
        }

        // top
        if (index.j > 0) {
            neighbors.add(new Index(index.i, index.j - 1, index.iteration + 1));
        }

        // bottom
        if (index.j + 1 < matrix[0].length) {
            neighbors.add(new Index(index.i, index.j + 1, index.iteration + 1));
        }

        return neighbors;
    }
}
