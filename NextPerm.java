/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.util.Arrays;

public class NextPerm {
    public static void main(String[] args) {

        nextPermutation(new int[] { 2, 3, 1 });
    }


    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        int j = n - 1;
        if (n == 2) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;

        }
        else if (n > 2) {
            if (nums[i] < nums[j]) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
            else {
                while (i > 0) {
                    --i;
                    //find just greater of nums[i]
                    int just_gr = Integer.MAX_VALUE;
                    int ind_gr = -1;
                    for (int k = i + 1; k <= j; k++) {
                        if (nums[k] > nums[i] && nums[k] < just_gr) {
                            just_gr = nums[k];
                            ind_gr = k;
                        }
                    }

                    if (ind_gr != -1) {
                        int temp = nums[i];
                        nums[i] = nums[ind_gr];
                        nums[ind_gr] = temp;

                        Arrays.sort(nums, i + 1, j + 1);
                        break;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(nums));

    }
}
