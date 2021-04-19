package algoexpert.medium;

import java.util.Stack;

public class medium_14 {

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    // reverse inorder traversal (iterative)
    public int findKthLargestValueInBst(BST tree, int k) {
        BST node = tree;
        Stack<BST> stack = new Stack<>();

        while (node != null || !stack.isEmpty()) {
            // go as right as possible
            while (node != null) {
                stack.push(node);
                node = node.right;
            }

            node = stack.pop();
            k--;

            if (k == 0) {
                return node.value;
            }

            // visit left after right subtree and after parent
            node = node.left;
        }

        return -1;
    }
}