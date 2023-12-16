import java.util.Arrays;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FirstAndLastPosition {
    public static void main(String[] args) {
        System.out.println();

        int[] nums = {5, 7, 7, 8, 8, 8, 10};
        int target = 8;
        FirstAndLastPosition obj = new FirstAndLastPosition();
        System.out.println(Arrays.toString(obj.searchRange(nums, target)));
    }

    public int[] searchRange(int[] nums, int target) {

        // check the first occurrence of target
        int first = firstAndLast(nums, target, true);
        int last = firstAndLast(nums, target, false);

        return new int[]{first, last};
    }

    // this function just returns the index of the target element
    int firstAndLast(int[] nums, int target, boolean findFirstIndex) {
        int ans = -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target < nums[mid]) {
                right = mid - 1; // search left
            } else if (target > nums[mid]) {
                left = mid + 1; // search right
            } else {
                // potential answer found
                ans = mid;
                if (findFirstIndex) {
                    right = mid - 1; // search left
                } else {
                    left = mid + 1; // search right
                }
            }
        }
        return ans;
    }
}
