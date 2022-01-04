/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class Divide2Int {

    /*public static int divide(long dividend, long divisor) {

        int i = 0;

        if (divisor > 0 && dividend > 0) {
            while (dividend >= divisor) {
                dividend -= divisor;
                i++;
            }

        }
        else if (divisor < 0 && dividend > 0) {
            while (dividend >= -divisor) {
                dividend += divisor;
                i++;
            }
            i = -i;

        }
        else if (divisor < 0 && dividend < 0) {
            while (-dividend >= -divisor) {
                dividend -= divisor;
                i++;
            }

        }
        else if (divisor > 0 && dividend < 0) {
            while (-dividend >= divisor) {
                dividend += divisor;
                i++;
            }
            i = -i;

        }


        return i;
    }*/

    public static int divide(int dividend, int divisor) {

        if (divisor == 0) {
            return dividend > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        if (dividend == 0) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNeg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        long up = Math.abs((long) dividend);
        long down = Math.abs((long) divisor);

        int i = 0;

        while (up >= down) {
            up -= down;
            i++;
        }

        return isNeg ? -i : i;
    }

    public static void main(String[] args) {

        //Scanner scn = new Scanner(System.in);
        int res = divide(Integer.MIN_VALUE, 2);
        System.out.println(res);

    }


}
