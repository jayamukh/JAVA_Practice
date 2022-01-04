/* *****************************************************************************
 *  Name:              Jaya Mukheerjee
 *  Count Inverse in an array:
 *  Last modified:     Jan 1, 2022
 **************************************************************************** */

import java.util.Arrays;
import java.util.Scanner;

public class CountInverseBruteForce {

    public static int countBF(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    count++;
                }

            }
        }
        return count;
    }

    public static int countMerge(int[] nums, int low, int mid, int high) {
        int[] leftArr = Arrays.copyOfRange(nums, low, mid);
        int[] rightArr = Arrays.copyOfRange(nums, mid + 1, high);
        int i = 0, j = 0, k = low, swap = 0;
        while (i < leftArr.length || j < rightArr.length) {

            if (i < leftArr.length && j < rightArr.length) {
                if (leftArr[i] > rightArr[j]) {
                    nums[k++] = rightArr[j++];
                    swap += (mid + 1) - (low + i);
                }
                else {
                    nums[k++] = leftArr[i++];
                }
            }
            else if (i < leftArr.length) {
                nums[k++] = leftArr[i++];
            }
            else {
                nums[k++] = rightArr[j++];
            }
        }
        return swap;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scn.nextInt();
        }
        //countBF(nums);

        System.out.println(
                mergeSortAndCount(nums, 0, nums.length - 1));
    }

    private static int mergeSortAndCount(int[] arr, int left,
                                         int right) {

        // Keeps track of the inversion count at a
        // particular node of the recursion tree
        int count = 0;

        if (left < right) {
            int m = (left + right) / 2;

            // Total inversion count = left subarray count
            // + right subarray count + merge count

            // Left subarray count
            count += mergeSortAndCount(arr, left, m);

            // Right subarray count
            count += mergeSortAndCount(arr, m + 1, right);

            // Merge count
            count += countMerge(arr, left, m, right);
        }

        return count;
    }

}
