// https://leetcode.com/problems/search-in-rotated-sorted-array/

// 1. Find the pivot in the array till where and from where your array will be ascending {3, 4, 5, 6, 7, 0, 1, 2}
// -> pivot = 7
// 2. Search in first half (simple binary search) (0 to pivot)
// 3. Otherwise, Search in second half (simple binary search) (pivot + 1 to end)

// How to find pivot?
//    * case 1: if arr[mid] > arr[mid + 1] -> mid is the pivot
//    * case 2: if arr[mid] < arr[mid - 1] -> (mid - 1) is the pivot
//    * case 3: if arr[mid] <= arr[start]   -> all elements from mid will be smaller than start. Hence, ignore all
//    elements after mid since we are looking for peak element i.e, largest. Ignore by doing end = mid - 1;
//    * case 4: if arr[mid] > arr[start]   -> means the largest element will be after arr[mid + 1] => start = mid + 1;
public class RotatedSearchArray {
    public static void main(String[] args) {
        System.out.println();

        int[] arr = {4, 5, 6, 7, 8, 0, 1, 2};
        RotatedSearchArray obj = new RotatedSearchArray();
        System.out.println(obj.search(arr, 0));
    }


    public int search(int[] nums, int target) {
        int pivot = findPivotWithDuplicates(nums);

        // if you did not find pivot that means the array is not rotated
        if (pivot == -1) {
            // just do normal binary search
            return binarySearch(nums, target, 0, nums.length - 1);
        }
        // if pivot is found you have found two ascending sorted array
        if (nums[pivot] == target) {
            return pivot;
        }
        if (target >= nums[0]) {
            return binarySearch(nums, target, 0, pivot - 1);
        }
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }

    int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // all the four cases here
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    int binarySearch(int[] arr, int target, int start, int end) {

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    int findPivotWithDuplicates(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            // all the four cases here
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            // if elements at middle, start, end are equal just skip the duplicates
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // skip the duplicates
                // NOTE: what if these elements were the pivots

                // check if start is pivot
                if (arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;
                // check if end is pivot
                if (arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            // left side is sorted, so pivot should be in right
            else if (arr[start] < arr[mid] || arr[start] == arr[mid] && arr[mid] > arr[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
