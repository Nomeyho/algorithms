package algoexpert.hard;

import java.util.PriorityQueue;

class hard_20 {

    public static void main(String[] args) {
        ContinuousMedianHandler handler = new ContinuousMedianHandler();
        System.out.println(handler.getMedian());
        handler.insert(5);
        System.out.println(handler.getMedian());
        handler.insert(10);
        System.out.println(handler.getMedian());
        handler.insert(100);
        System.out.println(handler.getMedian());
    }
    
    static class ContinuousMedianHandler {
        double median = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(ContinuousMedianHandler::increasingOrder);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(ContinuousMedianHandler::decreasingOrder);

        public void insert(int number) {
            doInsert(number);
            balance();
            updateMedian();
        }
        
        private void doInsert(int number) {
            if (!minHeap.isEmpty() && minHeap.peek() < number) {
                minHeap.add(number);
            } else {
                maxHeap.add(number);
            }
        }
        
        private void balance() {
            if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.add(minHeap.poll());
            }

            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            }
        }
        
        private void updateMedian() {
            if (minHeap.isEmpty() && maxHeap.isEmpty()) {
                return;
            }
            
            if (minHeap.size() == maxHeap.size()) {
                this.median = (double) (minHeap.peek() + maxHeap.peek()) / 2;
            } else if (minHeap.size() > maxHeap.size()) {
                this.median = minHeap.peek();
            } else {
                this.median = maxHeap.peek();
            }
        }

        public double getMedian() {
            return median;
        }
        
        private static int increasingOrder(Integer a, Integer b) {
            return a - b;
        }

        private static int decreasingOrder(Integer a, Integer b) {
            return b - a;
        }
    }
}

