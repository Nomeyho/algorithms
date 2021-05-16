package algoexpert.hard;

public class hard_7 {
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    public boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree) {
        if (find(nodeOne, nodeTwo.value) && find(nodeTwo, nodeThree.value)) {
            return true;
        }

        if (find(nodeThree, nodeTwo.value) && find(nodeTwo, nodeOne.value)) {
            return true;
        }

        return false;
    }

    private static boolean find(BST node, int value) {
        while (node != null) {
            if (node.value < value) {
                node = node.right;
            } else if (node.value > value) {
                node = node.left;
            } else {
                return true;
            }
        }
        return false;
    }
}
