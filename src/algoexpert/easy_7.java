package algoexpert;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class easy_7 {

    public static List<Integer> branchSums(BinaryTree root) {
        final ArrayList<Integer> branchSums = new ArrayList<>();
        final Stack<BinaryTree> nodes = new Stack<>();
        nodes.add(root);
        int sum = 0;

        while (!nodes.isEmpty()) {
            BinaryTree node = nodes.pop();
            sum += node.value;

            if (node.left == null && node.right == null) {
                branchSums.add(sum);
                sum -= node.value;
            }

            if (node.right != null) nodes.add(node.right);
            if (node.left != null) nodes.add(node.left);
        }

        return branchSums;
    }
    
    /*
    public static List<Integer> branchSums(BinaryTree root) {
        final ArrayList<Integer> branchSums = new ArrayList<>();
        branchSumsRec(root, 0, branchSums);
        return branchSums;
    }

    public static void branchSumsRec(BinaryTree root, int sum, ArrayList<Integer> branchSums) {
        sum += root.value;

        if (root.left == null && root.right == null) {
            branchSums.add(sum);
        }

        if (root.left != null) {
            branchSumsRec(root.left, sum, branchSums);
        }
        if (root.right != null) {
            branchSumsRec(root.right, sum, branchSums);
        }
    }
     */

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}

