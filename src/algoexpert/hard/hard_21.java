package algoexpert.hard;

public class hard_21 {
    public static LinkedList reverseLinkedList(LinkedList head) {
        LinkedList prev = null;
        LinkedList current = head;
        LinkedList next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
