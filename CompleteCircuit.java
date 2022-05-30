/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class CompleteCircuit {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int total_gas = 0;
        int total_cost = 0;

        for (int i : gas) {
            total_gas += i;
        }
        //System.out.println(total_gas);
        for (int j : cost) {
            total_cost += j;
        }
        //System.out.println(total_cost);
        if (total_gas < total_cost) {
            return -1;
        }

        System.out.println(total_gas);
        for (int ind = 0; ind < gas.length; ind++) {
            if (gas[ind] - cost[ind] < 0)
                continue;
            int tot_tank = 0;
            for (int j = ind; j < gas.length + ind; j++) {
                tot_tank += gas[j % gas.length] - cost[j % gas.length];
                if (tot_tank < 0)
                    break;
            }
            if (tot_tank >= 0)
                return ind;
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] gas = new int[] { 1, 2, 3, 4, 5 };
        int[] cost = new int[] { 3, 4, 5, 1, 2 };
        System.out.println(canCompleteCircuit(gas, cost));

    }
}
