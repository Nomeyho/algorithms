package algoexpert.hard;

public class hard_18 {
    public static LinkedList shiftLinkedList(LinkedList head, int k) {
        int length = length(head);
        int offset = Math.abs(k) % length;

        if (offset == 0) {
            return head;
        }

        int newTailPosition = k > 0 ? length - offset : offset;

        LinkedList oldTail = tail(head);
        LinkedList newTail = get(head, newTailPosition);
        LinkedList newHead = newTail.next;
        newTail.next = null;
        oldTail.next = head;

        return newHead;
    }

    private static int length(LinkedList head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }

    private static LinkedList tail(LinkedList head) {
        LinkedList tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        return tail;
    }

    private static LinkedList get(LinkedList head, int position) {
        LinkedList tmp = head;
        while (tmp != null && position > 1) {
            tmp = tmp.next;
            position--;
        }
        return tmp;
    }

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }
}
