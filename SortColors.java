/* *****************************************************************************
 *  Name:              Jaya Mukherjee
 *  Last modified:     Jan 1, 2022
 **************************************************************************** */

import java.util.Scanner;

public class SortColors {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }

        int low = 0, curr = 0, high = n - 1;

        while (curr <= high) {
            if (arr[curr] == 0) {
                int temp = arr[curr];
                arr[curr] = arr[low];
                arr[low] = temp;
                curr++;
                low++;
            }
            else if (arr[curr] == 2) {
                int temp = arr[curr];
                arr[curr] = arr[high];
                arr[high] = temp;
                high--;
            }
            else {
                curr++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}
