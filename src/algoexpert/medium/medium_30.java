package algoexpert.medium;

import java.util.*;

public class medium_30 {

    private static final int WHITE = 0;
    private static final int BLACK = 1;

    public static void main(String[] args) {
        int[][] result = new medium_30().removeIslands(new int[][] {
                {1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1},
                {0, 0, 1, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1}
        });
        
        for (final int[] line : result) {
            System.out.println(Arrays.toString(line));
        }
    }

    static class Index {
        int i;
        int j;

        Index(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int[][] removeIslands(int[][] matrix) {
        int I = matrix.length;
        int J = matrix[0].length;
        boolean visited[][] = new boolean[I][J];

        for (int i = 0; i < I; i++) {
            for (int j = 0; j < J; j++) {
                if (!visited[i][j] && matrix[i][j] == BLACK) {
                    removeIsland(i, j, matrix, visited);
                }
            }
        }

        return matrix;
    }

    private static void removeIsland(int i, int j, int[][] matrix, boolean[][] visited) {
        List<Index> toRemove = new ArrayList<>();

        // Find all 1 of the island
        Queue<Index> indices = new ArrayDeque<>();
        indices.add(new Index(i, j));

        while (!indices.isEmpty()) {
            Index index = indices.poll();

            if (visited[index.i][index.j] || matrix[index.i][index.j] == WHITE) {
                continue;
            }

            // Found new adjacent 1
            visited[index.i][index.j] = true;
            
            toRemove.add(index);
            List<Index> neighbors = findNeighbors(index.i, index.j, matrix);
            indices.addAll(neighbors);
        }

        // Check if any black dot is on the border
        for (Index index : toRemove) {
            if (index.i == 0 || index.i == matrix.length - 1 || index.j == 0 || index.j == matrix[0].length - 1) {
                return;
            }
        }

        // Remove the island from the grid
        for (Index index : toRemove) {
            matrix[index.i][index.j] = 0;
        }
    }

    private static List<Index> findNeighbors(int i, int j, int[][] matrix) {
        List<Index> neighbors = new ArrayList<>();

        if (i > 0) neighbors.add(new Index(i - 1, j));
        if (i < matrix.length - 1) neighbors.add(new Index(i + 1, j));
        if (j > 0) neighbors.add(new Index(i, j - 1));
        if (j < matrix[0].length - 1) neighbors.add(new Index(i, j + 1));

        return neighbors;
    }

}
