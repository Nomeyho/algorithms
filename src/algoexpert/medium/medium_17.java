package algoexpert.medium;

public class medium_17 {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class Max {
        int value = Integer.MIN_VALUE;
    }

    public int binaryTreeDiameter(BinaryTree tree) {
        Max max = new Max();
        binaryTreeDiameter(tree, max);
        return max.value;
    }

    private int binaryTreeDiameter(BinaryTree tree, Max max) {
        int leftLength = tree.left == null ? 0 : 1 + binaryTreeDiameter(tree.left, max);
        int rightLength = tree.right == null ? 0 : 1 + binaryTreeDiameter(tree.right, max);
        int length = leftLength + rightLength;

        if (length > max.value) {
            max.value = length;
        }

        return Math.max(leftLength, rightLength);
    }
}