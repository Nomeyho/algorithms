package algoexpert.medium;

import java.util.ArrayList;
import java.util.List;

public class medium_34 {

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(List.of(
                48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41
        ));

        minHeap.insert(76);
        minHeap.peek();
        minHeap.remove();
        System.out.println(minHeap.heap);
    }

    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            heap = new ArrayList<>(array);

            for (int i = heap.size() / 2 - 1; i >= 0; i--) {
                minHeapify(i, heap);
            }

            return heap;
        }

        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            int leftIdx = getLeftIdx(currentIdx);
            int rightIdx = getRightIdx(currentIdx);
            int minIdx = -1;

            // two children
            if (leftIdx < heap.size() && rightIdx < heap.size()) {
                if (heap.get(leftIdx) < heap.get(rightIdx)) {
                    minIdx = leftIdx;
                } else {
                    minIdx = rightIdx;
                }
            }
            // left child only
            else if (leftIdx < heap.size()) {
                minIdx = leftIdx;
            }
            // right child only
            else if (rightIdx < heap.size()) {
                minIdx = rightIdx;
            }

            if (minIdx != -1 && heap.get(minIdx) < heap.get(currentIdx)) {
                swap(minIdx, currentIdx, heap);
                siftDown(minIdx, endIdx, heap);
            }
        }

        public void siftUp(int currentIdx, List<Integer> heap) {
            if (currentIdx == 0) {
                return;
            }

            int parentIdx = getParentIdx(currentIdx);

            if (heap.get(currentIdx) < heap.get(parentIdx)) {
                swap(currentIdx, parentIdx, heap);
                siftUp(parentIdx, heap);
            }
        }

        public int peek() {
            return heap.get(0);
        }

        public int remove() {
            swap(0, heap.size() - 1, heap);
            int value = heap.remove(heap.size() - 1);
            siftDown(0, heap.size() - 1, heap);
            return value;
        }

        public void insert(int value) {
            int index = heap.size();
            heap.add(value);
            siftUp(index, heap);
        }

        private void swap(int i, int j, List<Integer> heap) {
            int tmp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, tmp);
        }

        private int getParentIdx(int i) {
            return (int) ((i - 1) / 2.0);
        }

        private int getLeftIdx(int i) {
            return 2 * i + 1;
        }

        private int getRightIdx(int i) {
            return 2 * i + 2;
        }

        private void minHeapify(int currentIdx, List<Integer> heap) {
            int leftIdx = getLeftIdx(currentIdx);
            int rightIdx = getRightIdx(currentIdx);
            int minIdx = currentIdx;

            if (leftIdx < heap.size() && heap.get(leftIdx) < heap.get(minIdx)) {
                minIdx = leftIdx;
            }

            if (rightIdx < heap.size() && heap.get(rightIdx) < heap.get(minIdx)) {
                minIdx = rightIdx;
            }

            if (currentIdx != minIdx) {
                swap(currentIdx, minIdx, heap);
                minHeapify(minIdx, heap);
            }
        }
    }
}
