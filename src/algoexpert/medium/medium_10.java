package algoexpert.medium;

public class medium_10 {

    public static void main(final String[] args) {
        BST _10 = new BST(10);
        BST _15 = new BST(15);
        BST _5 = new BST(5);
        
        BST root = _10;
        _10.left = _5;
        _10.right = _15;
        
        root.remove(5);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            if (value < this.value) {
                if (this.left == null) {
                    this.left = new BST(value);
                } else {
                    this.left.insert(value);
                }
            } else {
                if (this.right == null) {
                    this.right = new BST(value);
                } else {
                    this.right.insert(value);
                }
            }

            // Do not edit the return statement of this method.
            return this;
        }

        public boolean contains(int value) {
            if (value == this.value) {
                return true;
            } else if (value < this.value) {
                if (this.left == null) {
                    return false;
                } else {
                    return this.left.contains(value);
                }
            } else {
                if (this.right == null) {
                    return false;
                } else {
                    return this.right.contains(value);
                }
            }
        }

        public BST remove(int value) {
            return remove(null, value);
        }

        // TODO
        public BST remove(BST parent, int value) {
            if (value == this.value) {
                if (this.left != null && this.right != null) {
                    // successor always exist and has no left child
                    BST successor = removeSuccessor(this, this.right);
                    this.value = successor.value;
                } else if (this.left != null) {
                    // only left child
                    if (parent == null) {
                        this.value = this.left.value;
                        this.left = this.left.left;
                        this.right = this.left.right;
                    } else if (parent.left == this) {
                        parent.left = this.left;
                    } else if (parent.right == this) {
                        parent.right = this.left;
                    }
                } else if (this.right != null) {
                    // only right child
                    if (parent == null) {
                        this.value = this.right.value;
                        this.left = this.right.left;
                        this.right = this.right.right;
                    } else if (parent.left == this) {
                        parent.left = this.right;
                    } else if (parent.right == this) {
                        parent.right = this.right;
                    }
                } else {
                    // no child -> leaf node
                    if (parent == null) {
                        return this;
                    } else if (parent.left == this) {
                        parent.left = null;
                    } else if (parent.right == this) {
                        parent.right = null;
                    }
                }
            } else if (value < this.value) {
                if (this.left != null) {
                    this.left.remove(this, value);
                }
            } else {
                if (this.right != null) {
                    this.right.remove(this, value);
                }
            }

            // Do not edit the return statement of this method.
            return this;
        }

        private static BST removeSuccessor(BST parent, BST successor) {
            while (successor.left != null) {
                parent = successor;
                successor = successor.left;
            }

            parent.left = successor.right;
            successor.right = null;
            return successor;
        }
    }
}