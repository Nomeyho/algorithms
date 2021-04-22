package algoexpert.medium;

public class medium_18 {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        if (node.right != null) {
            // successor is the left-most value in right subtree
            return leftMost(node.right);
        }

        if (node.parent != null && node.parent.left == node) {
            // it has no right subtree, so the successor is the parent
            return node.parent;
        }

        if (node.parent != null && node.parent.right == node) {
            // first ancestor having a left child
            return leftAncestor(node);
        }

        return null;
    }

    private BinaryTree leftMost(BinaryTree node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    private BinaryTree leftAncestor(BinaryTree node) {
        while (node.parent != null) {
            if (node.parent.left == node) {
                return node.parent;
            }

            node = node.parent;
        }

        return null;
    }
}