package algoexpert.easy;

class easy_13 {

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        // Can linkedList be NULL or empty?
        LinkedList prev = linkedList;
        LinkedList current = linkedList.next;

        while (current != null) {
            if (prev.value == current.value) {
                prev.next = current.next;
                current = current.next;
            } else {
                prev = current;
                current = current.next;
            }
        }

        return linkedList;
    }
}

