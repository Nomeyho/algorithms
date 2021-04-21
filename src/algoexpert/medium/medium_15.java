package algoexpert.medium;

import java.util.ArrayList;

public class medium_15 {

    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    static class Index {
        int value; // shared across recursive calls

        Index(int value) {
            this.value = value;
        }

        void increment() {
            this.value++;
        }
    }

    public BST reconstructBst(ArrayList<Integer> array) {
        return reconstructBst(array, new Index(0), Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private BST reconstructBst(ArrayList<Integer> array, Index index, int min, int max) {
        if (index.value >= array.size()) {
            return null;
        }

        int value = array.get(index.value);
        if (value < min || value >= max) {
            return null;
        }

        BST node = new BST(value);
        index.increment();
        node.left = reconstructBst(array, index, min, value);
        node.right = reconstructBst(array, index, value, max);
        return node;
    }

    /*
    // O(n^2) time
    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        BST root = new BST(preOrderTraversalValues.get(0));
        reconstructBst(root, preOrderTraversalValues, 1, preOrderTraversalValues.size() - 1);
        return root;
    }

    // Note: more elegant solution by returning the BST node
    private void reconstructBst(BST node,
                                ArrayList<Integer> array,
                                int start,
                                int end) {
        if (start > end) {
            return;
        }

        int rightChildIndex = -1;
        for (int i = start; i <= end; ++i) { // O(n^2) because of this loop
            if (array.get(i) >= node.value) {
                rightChildIndex = i;
                break;
            }
        }

        if (rightChildIndex == -1) {
            // no right child
            node.left = new BST(array.get(start));
            reconstructBst(node.left, array, start + 1, end);
        } else {
            if (start == rightChildIndex) {
                // no left child
                node.right = new BST(array.get(rightChildIndex));
                reconstructBst(node.right, array, rightChildIndex + 1, end);
            } else {
                node.left = new BST(array.get(start));
                node.right = new BST(array.get(rightChildIndex));
                reconstructBst(node.left, array, start + 1, rightChildIndex - 1);
                reconstructBst(node.right, array, rightChildIndex + 1, end);
            }
        }
    }
     */
}