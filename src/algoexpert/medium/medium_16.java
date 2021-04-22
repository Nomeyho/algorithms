package algoexpert.medium;

public class medium_16 {
    public static void invertBinaryTree(BinaryTree tree) {
        if (tree == null) {
            return;
        }

        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);

        BinaryTree tmp = tree.left;
        tree.left = tree.right;
        tree.right = tmp;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

}