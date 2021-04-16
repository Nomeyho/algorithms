package algoexpert.medium;

import java.util.List;

public class medium_13 {
    public static BST minHeightBst(List<Integer> array) {
        return minHeightBstHelper(null, array, 0, array.size());
    }

    public static BST minHeightBstHelper(BST tree, List<Integer> array, int start, int end) {
        if (start >= end) {
            return null;
        }

        int middle = (start + end) / 2;
        int value = array.get(middle);

        if (tree == null) {
            tree = new BST(value);
        } else {
            tree.insert(value);
        }

        minHeightBstHelper(tree, array, start, middle); // [start, middle[
        minHeightBstHelper(tree, array, middle + 1, end); // [middle + 1, end[
        return tree;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
}