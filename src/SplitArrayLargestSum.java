// https://leetcode.com/problems/split-array-largest-sum/

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        System.out.println();

        int[] nums = { 7, 2, 5, 10, 8 };
        SplitArrayLargestSum obj = new SplitArrayLargestSum();
        System.out.println(obj.splitArray(nums, 2));
        
        System.out.println();
    }

    public int splitArray(int[] nums, int m) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]); // in the end of the loop this will contain the max item from the array
            end += nums[i];
        }

        // binary search
        while (start < end) {
            // try for the middle as potential answer
            int mid = start + (end - start) / 2;

            // calculate how many pieces we can divide this in with this max sum
            int sum = 0;
            int pieces = 1;

            for (int num : nums) {
                if (sum + num > mid) {
                    // you cannot add this in subarray, make new one
                    // say you add this in new subarray, then sum = num
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }

            if (pieces > m) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end; // here start == end, so we can return either
    }
}