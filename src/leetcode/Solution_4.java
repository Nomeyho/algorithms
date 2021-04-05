package leetcode;

public class Solution_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // assumption: nums1.len > nums2.len
        int medianIndex = (nums1.length + nums2.length) / 2;
        double nums1Median = findMedian(nums1);


        return 0.0;
    }

    private static double findMedian(int[] nums) {
        if (nums.length == 0) {
            return 0.0;
        }

        if (nums.length % 2 == 0) {
            return nums[nums.length / 2];
        } else {
            int idx = (int) Math.floor(nums.length / 2.0);
            return (nums[idx] + nums[idx + 1]) / 2.0;
        }
    }

    private static int findInsertionIndex(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        return -1;
    }
}
