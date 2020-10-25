

class Solution2 {

    static ListNode L1;
    static ListNode L2;

    static {
        L1 = new ListNode(2);
        L1.next = new ListNode(4);
        L1.next.next = new ListNode(3);

        L2 = new ListNode(5);
        L2.next = new ListNode(6);
        L2.next.next = new ListNode(4);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(final String[] args) {
        final ListNode result = new Solution2().addTwoNumbers(L1, L2);
        System.out.println(result);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int report = 0;
        ListNode sum = null;
        ListNode prev = null;

        while (l1 != null || l2 != null || report > 0) {
            ListNode digit = new ListNode(report);

            if (l1 != null) {
                digit.val += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                digit.val += l2.val;
                l2 = l2.next;
            }

            // overflow
            if (digit.val >= 10) {
                digit.val -= 10;
                report = 1;
            } else {
                report = 0;
            }

            // cursor
            if (sum == null) {
                sum = digit;
                prev = digit;
            } else {
                prev.next = digit;
                prev = digit;
            }
        }

        return sum;
    }
}