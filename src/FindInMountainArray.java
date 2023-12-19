// https://leetcode.com/problems/find-in-mountain-array/description/

// 1. Find peak element
// 2. Binary search in ascending array
// 3. Binary search in descending array
public class FindInMountainArray {
    public static void main(String[] args) {
        System.out.println();
        int[] arr = {1, 2, 3, 4, 5, 3, 2, 1, 0};
        int target = 0;
        System.out.println(search(arr, target));
    }

    static int orderAgnosticBS(int[] arr, int target, int start, int end) {
        // finding whether the array is sorted in ascending or descending order
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            // finding the middle element
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            // if array is Ascending
            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // if array is descending
            else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    public static int peakIndexMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    static int search(int[] arr, int target) {
        int peak = peakIndexMountainArray(arr);
        int firstTry = orderAgnosticBS(arr, target, 0, peak);
        if (firstTry != -1) {
            return firstTry;
        }
        return orderAgnosticBS(arr, target, peak + 1, arr.length - 1);
    }
}
