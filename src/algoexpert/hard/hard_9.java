package algoexpert.hard;

import java.util.*;

public class hard_9 {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    // 0(n) time and space complexity
    // See AlgoExpert for a different approach
    public ArrayList<Integer> findNodesDistanceK(BinaryTree tree, int target, int k) {
        Map<BinaryTree, BinaryTree> parents = populateParents(tree);
        BinaryTree targetNode = find(tree, target);

        ArrayList<Integer> result = new ArrayList<>();
        Set<BinaryTree> visited = new HashSet<>();
        findNodesDistanceK(targetNode, k, parents, result, visited);

        return result;
    }

    private static void findNodesDistanceK(BinaryTree node,
                                           int remainingDistance,
                                           Map<BinaryTree, BinaryTree> parents,
                                           ArrayList<Integer> result,
                                           Set<BinaryTree> visited) {
        if (node == null || visited.contains(node)) {
            return;
        } else if (remainingDistance == 0) {
            result.add(node.value);
        }

        visited.add(node);
        findNodesDistanceK(parents.get(node), remainingDistance - 1, parents, result, visited);
        findNodesDistanceK(node.left, remainingDistance - 1, parents, result, visited);
        findNodesDistanceK(node.right, remainingDistance - 1, parents, result, visited);
    }

    // O(n) time & 0(d) space
    private static BinaryTree find(BinaryTree node, int target) {
        Stack<BinaryTree> stack = new Stack<>();
        stack.add(node);

        while (!stack.isEmpty()) {
            node = stack.pop();

            if (node.value == target) {
                return node;
            }

            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
        }

        return null;
    }

    // O(n) time & 0(n) space
    private static Map<BinaryTree, BinaryTree> populateParents(BinaryTree tree) {
        Map<BinaryTree, BinaryTree> parents = new HashMap<>();
        populateParentsHelper(null, tree, parents);
        return parents;
    }

    private static void populateParentsHelper(BinaryTree parent,
                                              BinaryTree node,
                                              Map<BinaryTree, BinaryTree> parents) {
        if (node == null) {
            return;
        }

        parents.put(node, parent);
        populateParentsHelper(node, node.left, parents);
        populateParentsHelper(node, node.right, parents);
    }
}
