package algoexpert.medium;

public class medium_26 {
    private static final int VISITED = Integer.MAX_VALUE;

    public static void main(String[] args) {
        boolean result = hasSingleCycle(new int[] {1, 1, 1, 1, 2});
        System.out.println(result);
    }
    
    public static boolean hasSingleCycle(int[] array) {
        int jumpCount = 0;
        int currentIndex = 0;

        // While has not visited all nodes
        while (jumpCount < array.length) {
            if (array[currentIndex] == VISITED) {
                return false;
            }

            int nextIndex = jump(currentIndex, array[currentIndex], array.length);
            array[currentIndex] = VISITED;
            currentIndex = nextIndex;
            jumpCount++;
        }

        return currentIndex == 0;
    }
    
    private static int jump(int currentIndex, int jump, int len) {
        int nextIndex = (currentIndex + jump) % len;
        
        if (nextIndex < 0) {
            return nextIndex + len;
        } else {
            return nextIndex;
        }
    }
}