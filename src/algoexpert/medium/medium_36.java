package algoexpert.medium;

public class medium_36 {
    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        LinkedList node = getNodeAtPosition(head, k);
        LinkedList nodeToRemove = head;
        LinkedList nodeToRemovePrev = null;

        while (node != null) {
            node = node.next;
            nodeToRemovePrev = nodeToRemove;
            nodeToRemove = nodeToRemove.next;
        }

        if (nodeToRemove == head) {
            head.value = head.next.value;
            head.next = head.next.next;
        } else {
            nodeToRemovePrev.next = nodeToRemove.next;
        }
    }

    private static LinkedList getNodeAtPosition(LinkedList head, int k) {
        LinkedList node = head;

        for (int i = 0; i < k; ++i) {
            node = node.next;
        }

        return node;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

}
