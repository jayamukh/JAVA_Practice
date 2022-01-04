/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Beams {
    public static void main(String[] args) {

        String[] str = new String[] { "011001", "000000", "010100", "001000" };
        System.out.println(numberOfBeams(str));
    }

    private static int numberOfBeams(String[] bank) {

        int count1 = 0, count = 0, beams = 0;

        for (int i = 0; i < bank.length; i++) {
            for (int j = 0; j < bank[i].length(); j++) {
                if (bank[i].charAt(j) == '1') {
                    count++;
                }
            }
            if (count > 0) {
                if (count1 == 0) {
                    count1 = count;
                }
                else {
                    beams += (count1 * count);
                    count1 = count;
                }
            }
            count = 0;
        }

        return beams;

    }
/*
    ["011001","000000","010100","001000"]
            ["000","111","000"]*/
}
