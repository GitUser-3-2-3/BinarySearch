// https://leetcode.com/problems/peak-index-in-a-mountain-array/
public class MountainArray {
    public static void main(String[] args) {
        System.out.println();

        int[] arr = {0, 10, 5, 2};
        System.out.println(peakIndexMountainArray(arr));
    }

    public static int peakIndexMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                // you are in decreasing part of array.
                // this may be the ans but look at left
                // this is why end != mid -1;
                end = mid;
            } else {
                // you are in ascending part of the array
                start = mid + 1; // because we know that the arr[mid + 1] element > arr[mid] element
            }
        }
        // in the end start == end and pointing to the largest number because of the two checks above
        // start and end are always trying to find the max element in the above 2 checks
        // hence, when they are pointing to just one element, that is the max one because that is what the checks say
        return start; // or return end as both are the same
    }
}
