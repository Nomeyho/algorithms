package algoexpert.medium;

import java.util.ArrayList;

public class medium_47 {

    public static void main(String[] args) {
        ArrayList<Integer> stack = new ArrayList<>();
        stack.add(-5);
        stack.add(2);
        stack.add(-2);
        stack.add(4);
        stack.add(3);
        stack.add(1);

        ArrayList<Integer> result = new medium_47().sortStack(stack);
        System.out.println(result);
    }

    public ArrayList<Integer> sortStack(ArrayList<Integer> stack) {
        if (stack.size() <= 1) {
            return stack;
        }

        int element = pop(stack);

        sortStack(stack);
        insert(stack, element);
        return stack;
    }

    private void insert(ArrayList<Integer> sortedStack, int element) {
        if (sortedStack.size() == 0) {
            sortedStack.add(element);
            return;
        }

        int top = pop(sortedStack);

        if (element >= top) {
            push(sortedStack, top);
            push(sortedStack, element);
        } else {
            insert(sortedStack, element);
            push(sortedStack, top);
        }
    }

    private static void push(ArrayList<Integer> stack, int element) {
        stack.add(element);
    }

    private static int pop(ArrayList<Integer> stack) {
        return stack.remove(stack.size() - 1);
    }
}
