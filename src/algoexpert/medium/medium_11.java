package algoexpert.medium;

public class medium_11 {

    public static void main(final String[] args) {
        BST _10 = new BST(10);
        BST _15 = new BST(15);
        BST _5 = new BST(5);
        BST _10bis = new BST(10);

        BST root = _10;
        _10.left = _5;
        _10.right = _15;
        _5.right = _10bis;

        boolean result = validateBst(root);
        System.out.println(result);
    }

    public static boolean validateBst(BST root) {
        return root.validate(null, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public boolean validate(BST parent, int min, int max) {
            if (this.value >= max || this.value < min) {
                return false;
            }

            if (this.left != null && !this.left.validate(this, min, Math.min(max, this.value))) {
                return false;
            }

            if (this.right != null && !this.right.validate(this, Math.max(min, this.value), max)) {
                return false;
            }

            return true;
        }
    }
}