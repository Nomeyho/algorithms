package algoexpert.medium;

public class medium_29 {
    public static AncestralTree getYoungestCommonAncestor(AncestralTree topAncestor,
                                                          AncestralTree descendantOne,
                                                          AncestralTree descendantTwo) {
        int depthOne = descendantOne.depth();
        int depthTwo = descendantTwo.depth();

        while (depthOne > depthTwo) {
            descendantOne = descendantOne.ancestor;
            depthOne--;
        }

        while (depthTwo > depthOne) {
            descendantTwo = descendantTwo.ancestor;
            depthTwo--;
        }

        // We are are the same depth on both side,
        // let's start looking for the first common ancestor
        while (descendantOne != descendantTwo) {
            descendantOne = descendantOne.ancestor;
            descendantTwo = descendantTwo.ancestor;
        }

        return descendantOne;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        int depth() {
            if (ancestor == null) {
                return 0;
            }

            return 1 + ancestor.depth();
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }

}
