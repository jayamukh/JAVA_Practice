/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class MergeN {

    public static ArrayList<Integer> merge(ArrayList<ArrayList<Integer>> arrays,
                                           int[] arrayLengths) {

        return new ArrayList<Integer>();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numArrays = Integer.parseInt(scanner.nextLine());
        int arrayLengths[] = Arrays.stream(scanner.nextLine().split(" "))
                                   .mapToInt(Integer::parseInt).toArray();
        ArrayList<ArrayList<Integer>> arrays = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < numArrays; ++i) {
            int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt)
                                .toArray();
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            for (int el : array) arrayList.add(Integer.valueOf(el));
            arrays.add(arrayList);
        }
        scanner.close();

        ArrayList<Integer> merged = merge(arrays, arrayLengths);
        StringBuffer sb = new StringBuffer();
        for (int s : merged) {
            sb.append(s);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
