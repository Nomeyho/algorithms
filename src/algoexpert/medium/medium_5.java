package algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

public class medium_5 {
    public static List<Integer> spiralTraverse(int[][] array) {
        List<Integer> spiral = new ArrayList<Integer>();
        int verticalSize = array.length;
        int horizontalSize = array[0].length; // assumption
        int maxDepth = (int) (Math.ceil(Math.min(verticalSize, horizontalSize) / 2.0) - 1);

        for (int depth = 0; depth <= maxDepth; ++depth) {
            spiralTraverse(array,
                    verticalSize, horizontalSize,
                    depth,
                    spiral);
        }

        return spiral;
    }

    private static void spiralTraverse(int[][] array,
                                       int verticalSize,
                                       int horizontalSize,
                                       int depth,
                                       List<Integer> spiral) {
        int i, j;

        // top
        i = depth;
        for (j = depth; j <= horizontalSize - depth - 1; ++j) {
            spiral.add(array[i][j]);
        }

        // right
        j = horizontalSize - depth - 1;
        for (i = depth + 1; i <= verticalSize - depth - 1; ++i) {
            spiral.add(array[i][j]);
        }

        // bottom
        i = verticalSize - depth - 1;
        if (depth != i) { // avoid double count of horizontal lines
            for (j = horizontalSize - depth - 1 - 1; j >= depth; --j) {
                spiral.add(array[i][j]);
            }
        }

        // left
        j = depth;
        if (j != horizontalSize - depth - 1) { // avoid double count of vertical lines
            for (i = verticalSize - depth - 1 - 1; i > depth; --i) {
                spiral.add(array[i][j]);
            }
        }
    }
}
