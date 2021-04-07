package algoexpert.easy;

import java.util.Stack;

class easy_8 {

    public static int nodeDepths(BinaryTree root) {
        final Stack<DepthBinaryTree> stack = new Stack<>();
        stack.add(new DepthBinaryTree(root, 0));
        int sum = 0;
        
        while (!stack.isEmpty()) {
            DepthBinaryTree node = stack.pop();
            sum += node.depth;
            
            if(node.binaryTree.left != null) {
                stack.push(new DepthBinaryTree(node.binaryTree.left, node.depth + 1));
            }

            if(node.binaryTree.right != null) {
                stack.push(new DepthBinaryTree(node.binaryTree.right, node.depth + 1));
            }
        }
        
        return sum;
    }
    
    /*
    public static int nodeDepths(BinaryTree root) {
        return nodeDepthsRec(root, 0);
    }

    public static int nodeDepthsRec(BinaryTree root, int depth) {
        if (root == null) {
            return 0;
        }

        return depth
                + nodeDepthsRec(root.left, depth + 1)
                + nodeDepthsRec(root.right, depth + 1);
    }
     */
    
    static class DepthBinaryTree {
        BinaryTree binaryTree;
        int depth;
        
        public DepthBinaryTree(BinaryTree binaryTree, int depth) {
            this.binaryTree = binaryTree;
            this.depth = depth;
        }
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}

