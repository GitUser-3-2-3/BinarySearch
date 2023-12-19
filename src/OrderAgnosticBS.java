import java.util.Scanner;

public class OrderAgnosticBS {
    public static void main(String[] args) {
        System.out.println();
        Scanner sc = new Scanner(System.in);

        int[] arr = {17, 15, 14, 11, 8, 4, 1, 0, -4, -7, -11, -13, -19};
        System.out.println("Enter the target element: ");
        int target = sc.nextInt();
        System.out.println(orderAgnosticBS(arr, target));

        sc.close();
    }

    static int orderAgnosticBS(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

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
}
