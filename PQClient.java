/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Transaction;

public class PQClient {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        MaxPQTest<Transaction> pq = new MaxPQTest<Transaction>(m + 1);

        while (StdIn.hasNextLine()) {
            String line = StdIn.readLine();
            Transaction transaction = new Transaction(line);
            pq.insert(transaction);
            if (pq.size() > m) {
                pq.delMax();
            }
            // low M entries are on the PQ
            Stack<Transaction> st = new Stack<Transaction>();
            for (Transaction tr : pq)
                st.push(tr);
            for (Transaction tr : st)
                StdOut.println(tr);
        }
    }
}
