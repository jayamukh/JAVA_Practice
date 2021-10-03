/* *****************************************************************************
 *  Name:              Jaya Mukherjee
 *  Coursera User ID:  123456
 *  Last modified:     March 29, 2021
 **************************************************************************** */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Merge {

    public static ArrayList<Integer> mergeTwo(ArrayList<ArrayList<Integer>> arrays,
                                              int[] arrayLengths) {


        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int counter = 0; counter < arrays.size() - 1; counter++) {
            int pos1 = 0, pos2 = 0, pos3 = 0;
            ArrayList<Integer> innerList1;
            if ((counter > 0) && !result.isEmpty()) {
                innerList1 = new ArrayList<Integer>(result);
                pos3 = result.size();
            }
            else {
                innerList1 = arrays.get(counter);
                pos3 = arrayLengths[counter];
            }
            ArrayList<Integer> innerList2 = arrays.get(counter + 1);

            int[] list1 = innerList1.stream()
                                    .mapToInt(Integer::intValue)
                                    .toArray();
            int[] list2 = innerList2.stream()
                                    .mapToInt(Integer::intValue)
                                    .toArray();

            result.clear();
            while ((pos1 < pos3) || (pos2 < arrayLengths[counter + 1])) {

                if ((pos1 < pos3) && (pos2 < arrayLengths[counter + 1])) {
                    if (list1[pos1] < list2[pos2]) {
                        result.add(list1[pos1]);
                        pos1++;
                    }
                    else {
                        result.add(list2[pos2]);
                        pos2++;
                    }
                }
                else if (pos1 >= pos3) {
                    result.add(list2[pos2]);
                    pos2++;
                }
                else {
                    result.add(list1[pos1]);
                    pos1++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numArrays = Integer.parseInt(scanner.nextLine());
        int arrayLengths[] = Arrays.stream(scanner.nextLine().split(" "))
                                   .mapToInt(Integer::parseInt).toArray();

        ArrayList<ArrayList<Integer>> arrays = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < numArrays; ++i) {
            int[] array = Arrays.stream(scanner.nextLine().split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            for (int el : array) arrayList.add(Integer.valueOf(el));
            arrays.add(arrayList);
        }
        scanner.close();

       
        ArrayList<Integer> merged = mergeTwo(arrays, arrayLengths);
        StringBuffer sb = new StringBuffer();
        for (int s : merged) {
            sb.append(s);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
