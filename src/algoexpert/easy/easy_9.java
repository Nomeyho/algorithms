package algoexpert.easy;

import java.util.ArrayList;
import java.util.List;

class easy_9 {

    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {

            array.add(this.name);
            children.forEach((c) -> c.depthFirstSearch(array));

            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}

