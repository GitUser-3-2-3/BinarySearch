public class BinarySearch {
    public static void main(String[] args) {
        System.out.println();

        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int target = 7;
        System.out.println(binarySearch(arr, target));
    }

    static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
