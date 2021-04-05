package algoexpert;

class easy_6 {

    public static int findClosestValueInBst(BST tree, int target) {
        BST root = tree;
        int closest = tree.value;

        while (root != null) {
            if (Math.abs(target - root.value) < Math.abs(target - closest)) {
                closest = root.value;
            }

            if (target == root.value) {
                break;
            } else if (target < root.value) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return closest;
    }
    /*
    public static int findClosestValueInBst(BST tree, int target) {
        if (tree.value == target) {
            return target;
        } else if (tree.value < target) {
            if (tree.right != null) {
                return closest(
                        findClosestValueInBst(tree.right, target),
                        tree.value,
                        target
                );
            } else {
                return tree.value;
            }
        } else {
            if (tree.left != null) {
                return closest(
                        findClosestValueInBst(tree.left, target),
                        tree.value,
                        target
                );
            } else {
                return tree.value;
            }
        }
    }

    public static int closest(int a, int b, int target) {
        if (Math.abs(target - a) < Math.abs(target - b)) {
            return a;
        } else {
            return b;
        }
    }
    */

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}

