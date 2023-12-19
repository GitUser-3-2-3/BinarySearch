import java.util.Scanner;

public class CeilingValue {
    public static void main(String[] args) {
        System.out.println();

        System.out.println("Enter the target value: ");
        System.out.println("Enter the target value: ");
        Scanner sc = new Scanner(System.in);

        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 11, 18 };
        int target = sc.nextInt();
        System.out.println(binarySearch(arr, target));

        sc.close();
    }

    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return arr[start];
    }
}
