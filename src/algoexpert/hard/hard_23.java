package algoexpert.hard;

public class hard_23 {
    public static LinkedList findLoop(LinkedList head) {
        LinkedList s = head.next;
        LinkedList f = head.next.next;
        
        // Make S and F meet
        while (s != f) {
            s = s.next;
            f = f.next.next;
        }
        
        // Remaining distance
        s = head;
        while (s != f) {
            s = s.next;
            f = f.next;
        }
        
        return s;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
