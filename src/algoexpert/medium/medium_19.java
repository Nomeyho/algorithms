package algoexpert.medium;

public class medium_19 {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class BSTHeight {
        int height;
        boolean balanced;

        BSTHeight(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        return getBalancedBinaryHeight(tree).balanced;
    }

    private BSTHeight getBalancedBinaryHeight(BinaryTree tree) {
        if (tree == null) {
            return new BSTHeight(0, true);
        }

        BSTHeight lh = getBalancedBinaryHeight(tree.left);
        BSTHeight rh = getBalancedBinaryHeight(tree.right);

        return new BSTHeight(
                1 + Math.max(lh.height, rh.height),
                lh.balanced && rh.balanced && Math.abs(lh.height - rh.height) <= 1
        );
    }
}