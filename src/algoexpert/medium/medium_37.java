package algoexpert.medium;

public class medium_37 {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        LinkedList resultHead = null;
        LinkedList result = null;
        int remainder = 0;

        while (linkedListOne != null || linkedListTwo != null || remainder > 0) {
            int sum = remainder;
            sum += linkedListOne == null ? 0 : linkedListOne.value;
            sum += linkedListTwo == null ? 0 : linkedListTwo.value;

            if (sum >= 10) {
                remainder = 1;
                sum -= 10;
            } else {
                remainder = 0;
            }

            LinkedList digit = new LinkedList(sum);
            if (resultHead == null) {
                resultHead = digit;
            } else {
                result.next = digit;
            }

            result = digit;
            linkedListOne = linkedListOne == null ? null : linkedListOne.next;
            linkedListTwo = linkedListTwo == null ? null : linkedListTwo.next;
        }

        return resultHead;
    }
}
