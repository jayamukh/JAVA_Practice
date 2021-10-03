/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.util.Scanner;

public class Solution {
    public static int removeDuplicatesSoln(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        while (i < (nums.length - 1)) {
            int p = nums[i];
            while ((i < (nums.length - 1)) && (p == nums[i + 1])) {
                nums[++i] = 101;
            }
            i++;
        }
        boolean flag = false;
        i = 0;
        int p = 0;
        int k = 1;
        while (i < nums.length) {
            if (nums[i] == 101 && !flag) {
                p = i;
                flag = true;
            }
            else if ((nums[i] != 101) && flag) {
                nums[p] = nums[i];
                nums[i] = 101;
                flag = false;
                i = p;
                k++;
            }
            else if (nums[i] == 101) {
                k++;
            }
            i++;
        }
        return k;
    }

    public static void main(String[] args) {

        // taking input
        if (args != null) {
            int temp = Integer.parseInt(args[0]);
            if ((temp > (3 * Math.pow(10, 4))) || (temp < 0))
                throw new IllegalArgumentException();
            Scanner sc = new Scanner(System.in);

            int[] a = new int[temp];
            for (int i = 0; i < temp; i++) {
                int n = sc.nextInt();
                if ((n > 100) || (n < (-100)))
                    throw new IllegalArgumentException();
                else
                    a[i] = n;
            }
            int k = removeDuplicatesSoln(a);
            System.out.println(k);
            for (int i = 0; i < a.length; i++)
                System.out.println(a[i]);

        }

    }
}
