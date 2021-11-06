package algoexpert.hard;

public class hard_24 {
    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        LinkedList head;

        // Init
        if (headOne.value <= headTwo.value) {
            head = headOne;
            headOne = headOne.next;
        } else {
            head = headTwo;
            headTwo = headTwo.next;
        }

        // Merge
        LinkedList current = head;
        while (headOne != null && headTwo != null) {
            if (headOne.value <= headTwo.value) {
                current.next = headOne;
                current = current.next;
                headOne = headOne.next;
            } else {
                current.next = headTwo;
                current = current.next;
                headTwo = headTwo.next;
            }
        }

        // Complete
        if (headOne != null) {
            current.next = headOne;
        } else {
            current.next = headTwo;
        }

        return head;
    }
}
