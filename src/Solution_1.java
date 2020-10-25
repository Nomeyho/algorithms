import java.util.HashMap;
import java.util.Map;

class Solution_1 {
    public int[] twoSum(int[] nums, int target) {
        // rest -> index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            int n1 = nums[i];
            int n2 = target - n1;

            if (map.containsKey(n2)) {
                return new int[]{map.get(n2), i};
            } else {
                map.put(n1, i);
            }
        }

        throw new RuntimeException("No solution");
    }
}