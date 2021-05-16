package algoexpert.hard;

public class hard_8 {
    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class MaxSumAcc {
        int value = Integer.MIN_VALUE;
    }

    public static int maxPathSum(BinaryTree tree) {
        MaxSumAcc maxSumAcc = new MaxSumAcc();
        maxPathSum(tree, maxSumAcc);
        return maxSumAcc.value;
    }

    private static int maxPathSum(BinaryTree tree, MaxSumAcc maxSumAcc) {
        if (tree == null) {
            return 0;
        }

        int leftPathLength = maxPathSum(tree.left, maxSumAcc);
        int rightPathLength = maxPathSum(tree.right, maxSumAcc);
        int maxPathLength = tree.value
                + Math.max(leftPathLength, 0) // only take left & right path if > 0
                + Math.max(rightPathLength, 0);

        if (maxPathLength > maxSumAcc.value) {
            maxSumAcc.value = maxPathLength;
        }

        return tree.value + Math.max(leftPathLength, rightPathLength);
    }
}
