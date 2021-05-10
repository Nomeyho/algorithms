package algoexpert.medium;

import java.util.LinkedList;

public class medium_44 {

    static class Item {
        int value;
        int min;
        int max;

        Item(int value, int min, int max) {
            this.value = value;
            this.min = min;
            this.max = max;
        }
    }

    static class MinMaxStack {

        final LinkedList<Item> stack = new LinkedList<>();

        public int peek() {
            return stack.peek().value;
        }

        public int pop() {
            return stack.pop().value;
        }

        public void push(Integer number) {
            if (stack.isEmpty()) {
                stack.addFirst(new Item(number, number, number));
            } else {
                Item prev = stack.peek();
                stack.addFirst(new Item(
                        number,
                        Math.min(prev.min, number),
                        Math.max(prev.max, number)
                ));
            }
        }

        public int getMin() {
            return stack.peek().min;
        }

        public int getMax() {
            return stack.peek().max;
        }
    }

}
